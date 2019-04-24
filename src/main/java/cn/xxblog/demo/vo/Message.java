package cn.xxblog.demo.vo;

import lombok.Data;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@Data
public class Message {
    private String message;

    public Message(String message) {
        this.message = message;
    }

    public ByteArrayOutputStream getMessage() {
        //计算消息长度 = 消息长度(4) + 消息类型(4) + 真实消息内容长度 + 结尾标识长度(1)
        byte[] len = intToByteArray(4 + 4 + (message == null ? 0 : message.length()) + 1);
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        try {
            byteArray.write(len);
            byteArray.write(len);
            byteArray.write(intToByteArray(689));
            byteArray.write(message.getBytes("UTF-8"));
            byteArray.write(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArray;
    }


    public static byte[] intToByteArray(int input){
        return ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(input).array();
    }
}
