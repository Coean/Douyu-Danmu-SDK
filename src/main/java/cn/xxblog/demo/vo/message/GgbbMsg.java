package cn.xxblog.demo.vo.message;

import lombok.Data;

/**
 * 功能描述：房间内用户抢红包消息
 *
 * @auther: Devpan
 */
@Data
public class GgbbMsg extends BaseMsg {

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
     * 抢到的鱼丸数量
     */
    private String sl;

    /**
     * 礼包产生者 id
     */
    private String sid;

    /**
     * 抢礼包者 id
     */
    private String did;

    /**
     * 礼包产生者昵称
     */
    private String snk;

    /**
     * 抢礼包者昵称
     */
    private String dnk;

    /**
     * 礼包类型
     */
    private String rpt;

}
