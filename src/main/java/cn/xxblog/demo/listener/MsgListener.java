package cn.xxblog.demo.listener;
import cn.xxblog.demo.vo.BaseMsg;

/**
 * @author barryp
 * @create 2019-04-26 13:01
 *     description:
 */
public interface MsgListener<T extends BaseMsg>  {

    /**
     * @param message raw mssage from douyu server.
     *
     * @return T extends BaseMsg
     * */
    void handleMessage(T message);

}
