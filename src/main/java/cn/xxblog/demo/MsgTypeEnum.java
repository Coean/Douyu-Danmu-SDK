package cn.xxblog.demo;

public enum MsgTypeEnum {
    CHAT_MSG("chat_msg"),

    ;

    private String type;

    MsgTypeEnum(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
