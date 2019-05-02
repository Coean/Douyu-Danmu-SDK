package cn.xxblog.demo.vo.message;

import lombok.Data;

/**
 * 功能描述：赠送礼物
 */
@Data
public class DgbMsg extends BaseMsg {
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
     * 礼物ID
     */
    private String gfid;

    /**
     * 礼物显示样式
     */
    private String gs;

    /**
     * 用户ID
     */
    private String uid;

    /**
     * 用户昵称
     */
    private String nn;

    /**
     * 大礼物标识：默认值为 0（表示是小礼物）
     */
    private String bg;

    /**
     * 礼物个数：默认值 1（表示 1 个礼物）
     */
    private String gfcnt;

    /**
     * 礼物连击次数：默认值 1（表示 1 连击）
     */
    private String hits;

    /**
     * 贵族等级
     */
    private String nl;

    /**
     * 粉丝牌名称
     */
    private String bnn;

    /**
     * 粉丝牌等级
     */
    private String bl;

    /**
     * 粉丝牌关联房间号
     */
    private String brid;

    /**
     * 徽章信息校验码
     */
    private String hc;

}
