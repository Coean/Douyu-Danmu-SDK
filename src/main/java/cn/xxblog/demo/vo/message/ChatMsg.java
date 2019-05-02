package cn.xxblog.demo.vo.message;

import lombok.Data;

/**
 * 功能描述：弹幕消息
 */
@Data
public class ChatMsg extends BaseMsg {

    /**
     * 原消息ID
     */
    private String uuid;

    /**
     * 弹幕唯一ID
     */
    private String cid;

    /**
     * 弹幕组ID
     */
    private String gid;

    /**
     * 房间ID
     */
    private String rid;

    /**
     * 发送者 uid
     */
    private String uid;

    /**
     * 用户昵称
     */
    private String nn;

    /**
     * 消息内容
     */
    private String txt;

    /**
     * 用户等级
     */
    private String level;

    /**
     * 礼物头衔：默认值 0（表示没有头衔）
     */
    private String gt;

    /**
     * 消息颜色：默认值 0（表示默认颜色弹幕）
     */
    private String col;

    /**
     * 客户端类型：默认值 0
     */
    private String ct;

    /**
     * 房间权限组：默认值 1（表示普通权限用户）
     */
    private String rg;

    /**
     * 平台权限组：默认值 1（表示普通权限用户）
     */
    private String pg;

    /**
     * 弹幕具体类型: 默认值 0（普通弹幕）
     */
    private String cmt;

    /**
     * 用户头像
     */
    private String ic;

    /**
     * 贵族等级
     */
    private String nl;

    /**
     * 贵族弹幕标识,0-非贵族弹幕,1-贵族弹幕,默认值 0
     */
    private String nc;

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

    /**
     * 主播等级
     */
    private String ol;

    /**
     * 是否反向弹幕标记: 0-普通弹幕，1-反向弹幕, 默认值 0
     */
    private String rev;

    /**
     * 是否高亮弹幕标记: 0-普通，1-高亮, 默认值 0
     */
    private String hl;

    /**
     * 是否粉丝弹幕标记: 0-非粉丝弹幕，1-粉丝弹幕, 默认值 0
     */
    private String ifs;

    /**
     * 弹幕发送时间
     */
    private String cst;

    /**
     * 转换为弹幕消息展示 (name: txt)
     *
     * @return
     */
    public String toChatStr() {
        return String.format("%s: %s", nn, txt);
    }
}
