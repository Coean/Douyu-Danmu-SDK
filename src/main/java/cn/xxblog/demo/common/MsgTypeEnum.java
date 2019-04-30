package cn.xxblog.demo.common;

public enum MsgTypeEnum {
    //所有消息
    ALL_MESSAGE("all"),
    //登录响应
    LOGIN_RES("loginres"),
    //服务心跳响应
    KEEP_LIVE("loginres"),
    //弹幕消息
    CHAT_MSG("chatmsg"),
    //领取鱼丸暴击
    ONLINE_GIFT("onlinegift"),
    //赠送礼物消息
    DGB("dgb"),
    //用户进入房间
    UENTER("uenter"),
    //房间开播关播
    RSS("rss"),
    //房间贡献排行榜更新广播
    RANK_LIST("ranklist"),
    //超级弹幕
    SSD("ssd"),
    //房间内礼物广播
    SPBC("spbc"),
    //房间用户抢红包
    GGBB("ggbb"),
    //房间分区排名变化消息
    RANK_UP("rankup"),
    //错误信息
    ERROR("error"),
    ;

    private String type;

    MsgTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
