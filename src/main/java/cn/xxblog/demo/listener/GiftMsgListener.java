package cn.xxblog.demo.listener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import cn.xxblog.demo.common.MsgType;
import cn.xxblog.demo.common.MsgTypeEnum;
import cn.xxblog.demo.util.DateTimeUtil;
import cn.xxblog.demo.vo.message.DgbMsg;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Devpan
 * description:
 */
@Slf4j
@MsgType(msgType = MsgTypeEnum.DGB)
public class GiftMsgListener implements MsgListener<DgbMsg> {
    private String giftFormat = "%s,%s,%s,%s,%s,%s,%s,%s,%s\n";

    File outputFile = new File("C:\\willow-blog\\gift_java.csv");
    PrintWriter pw = null;

    @Override
    public void handleMessage(MsgTypeEnum msgType, DgbMsg message) {
        if ("20620".equals(message.getGfid()) || "20623".equals(message.getGfid()) || "20625".equals(message.getGfid())) {
            log.info("chat:" + message.getRawMessage());
            String line = String.format(giftFormat, message.getRid(), message.getUid(), message.getNn(), message.getLevel(), getGiftName(message.getGfid()),
                                        message.getGfcnt(), message.getBcnt(), message.getBst(), DateTimeUtil.getTime());
            writeToFile(line);
        }

    }

    private void writeToFile(String line) {
        try {
            Boolean flag = !outputFile.exists();
            if (Objects.isNull(pw)) {
                FileWriter fw = new FileWriter(outputFile, true);
                pw = new PrintWriter(fw);
            }
            if (flag) {
                pw.write('\uFEFF');
                pw.write("房间号,用户ID,昵称,等级,礼物名称,礼物数量,连击数,礼物价值,时间");
                pw.write("\n");
            }
            pw.write(line);
            pw.flush();
        } catch (IOException e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }

    private String getGiftName(String gfId) {
        if ("20620".equals(gfId)) {
            return "魔法皇冠";
        }
        if ("20621".equals(gfId)) {
            return "魔法之翼";
        }
        if ("20623".equals(gfId)) {
            return "魔法乐园";
        }
        if ("20625".equals(gfId)) {
            return "魔法棒";
        }
        return gfId;
    }
}
