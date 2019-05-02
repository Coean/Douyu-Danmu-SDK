package cn.xxblog.demo.vo.message;

import lombok.Data;

/**
 * 功能描述：用户进房通知消息
 */
@Data
public class UenterMsg extends BaseMsg {


    /**
     * 原消息ID
     */
    private String uuid;

    /**
     * 房间ID
     */
    private String rid;

    /**
     * 弹幕组ID
     */
    private String gid;

    /**
     * 用户ID
     */
    private String uid;

    /**
     * 用户昵称
     */
    private String nn;

    /**
     * 用户等级
     */
    private String level;

    /**
     * 礼物头衔：默认值 0（表示没有头衔）
     */
    private String gt;

    /**
     * 房间权限组：默认值 1（表示普通权限用户）
     */
    private String rg;

    /**
     * 平台权限组：默认值 1（表示普通权限用户）
     */
    private String pg;

    /**
     * 用户头像
     */
    private String ic;

    /**
     * 贵族等级
     */
    private String nl;

}
