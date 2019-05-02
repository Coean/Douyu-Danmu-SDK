package cn.xxblog.demo.vo.message;

import lombok.Data;

/**
 * 功能描述：礼物广播消息
 *
 * @auther: Devpan
 */
@Data
public class SpbcMsg extends BaseMsg {

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
     * 赠送者昵称
     */
    private String sn;

    /**
     * 受赠者昵称
     */
    private String dn;

    /**
     * 礼物名称
     */
    private String gn;

    /**
     * 礼物数量
     */
    private String gc;

    /**
     * 赠送房间
     */
    private String drid;

    /**
     * 广播样式
     */
    private String gs;

    /**
     * 是否有礼包（0-无礼包，1-有礼包）
     */
    private String gb;

    /**
     * 广播展现样式（1-火箭，2-飞机）
     */
    private String es;

    /**
     * 礼物 id
     */
    private String gfid;

    /**
     * 特效 id
     */
    private String eid;

}
