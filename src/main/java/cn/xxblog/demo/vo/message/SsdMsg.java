package cn.xxblog.demo.vo.message;

import lombok.Data;

/**
 * 功能描述：超级弹幕消息
 */
@Data
public class SsdMsg extends BaseMsg {

    /**
     * 原消息ID
     */
    private String uuid;

    /**
     * 超级弹幕ID
     */
    private String sdid;

    /**
     * 房间ID
     */
    private String rid;

    /**
     * 弹幕组ID
     */
    private String gid;

    /**
     * 跳转房间ID
     */
    private String trid;

    /**
     * 超级弹幕内容
     */
    private String content;

}
