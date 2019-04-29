package cn.xxblog.demo.core;

import cn.xxblog.demo.util.HexUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Devpan
 */
@Slf4j
public class ReceivedThread extends Thread {
    private Socket socket;

    private Core core;

    public ReceivedThread(Socket socket, Core core) {
        this.socket = socket;
        this.core = core;
    }

    @Override
    public void run() {
        log.info("start receive message.");
        try {
            if (socket == null || !socket.isConnected()) {
                return;
            }

            int len;
            byte[] buffer = new byte[8 * 1024];
            InputStream in = socket.getInputStream();

            while (socket.isConnected() && (len = in.read(buffer)) != -1) {
                splitResponse(Arrays.copyOf(buffer, len)).forEach(core::handMessage);
            }
            System.out.println(socket.isConnected());
            log.info("receive message finished.");
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }

    /**
     * 分离同时返回的多组数据
     * 不优雅的方法：
     * 1.先将字节数组转化为对应的十六进制字符串
     * 2.然后用斗鱼定义的请求码"b2020000"来分割字符串
     * 3.判断"00"为消息尾部
     * 4.遍历分离出多组Response
     */
    public static List<String> splitResponse(byte[] buffer) {
        if (buffer == null || buffer.length <= 0) {
            return null;
        }

        List<String> resList = new ArrayList<>();
        String byteArray = HexUtil.bytes2HexString(buffer).toLowerCase();

        String[] responseStrings = byteArray.split("b2020000");
        int end;
        for (int i = 1; i < responseStrings.length; i++) {
            if (!responseStrings[i].contains("00")) {
                continue;
            }
            end = responseStrings[i].indexOf("00");
            byte[] bytes = HexUtil.hexString2Bytes(responseStrings[i].substring(0, end));
            if (bytes != null) {
                resList.add(new String(bytes));
            }
        }

        return resList;
    }

}
