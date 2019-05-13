package cn.xxblog.demo.common;

import java.util.Arrays;

import cn.xxblog.demo.exception.DouyuSdkMessageTypeNotFoundException;
import cn.xxblog.demo.vo.message.BaseMsg;
import cn.xxblog.demo.vo.message.ChatMsg;
import cn.xxblog.demo.vo.message.DgbMsg;
import cn.xxblog.demo.vo.message.ErrorMsg;
import cn.xxblog.demo.vo.message.GgbbMsg;
import cn.xxblog.demo.vo.message.SpbcMsg;
import cn.xxblog.demo.vo.message.SsdMsg;
import cn.xxblog.demo.vo.message.UenterMsg;
import lombok.Getter;

@Getter
public enum MsgTypeEnum {
    //所有消息
    ALL_MESSAGE("all", BaseMsg.class),
    //登录响应
    LOGIN_RES("loginres", BaseMsg.class),
    //服务心跳响应
    KEEP_LIVE("keeplive", BaseMsg.class),
    //服务器ping响应
    PING_REQ("pingreq", BaseMsg.class),
    //弹幕消息
    CHAT_MSG("chatmsg", ChatMsg.class),
    //领取鱼丸暴击
    ONLINE_GIFT("onlinegift", BaseMsg.class),
    //赠送礼物消息
    DGB("dgb", DgbMsg.class),
    //用户进入房间
    UENTER("uenter", UenterMsg.class),
    //房间开播关播
    RSS("rss", BaseMsg.class),
    //房间贡献排行榜更新广播
    RANK_LIST("ranklist", BaseMsg.class),
    //超级弹幕
    SSD("ssd", SsdMsg.class),
    //房间内礼物广播
    SPBC("spbc", SpbcMsg.class),
    //房间用户抢红包
    GGBB("ggbb", GgbbMsg.class),
    //房间分区排名变化消息
    RANK_UP("rankup", BaseMsg.class),
    //错误信息
    ERROR("error", ErrorMsg.class),
    ;

    private String type;
    private Class msgClassType;

    MsgTypeEnum(String type, Class msgClassType) {
        this.type = type;
        this.msgClassType = msgClassType;
    }

    public static MsgTypeEnum findByName(String type) {
        return Arrays.stream(MsgTypeEnum.values()).filter(t -> t.type.equals(type)).findFirst()
                     .orElseThrow(DouyuSdkMessageTypeNotFoundException::new);
    }
}
