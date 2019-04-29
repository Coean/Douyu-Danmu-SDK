package cn.xxblog.demo.util;
import cn.xxblog.demo.vo.Message;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author barryp
 * @create 2019-04-29 9:29
 *     description:
 */
public class SocketUtilTest {
    private SocketUtil socketUtil;

    @Before
    public void before(){
        socketUtil = new SocketUtil();
    }


    @Test
    public void send() {
        Assert.assertNotNull(socketUtil.getSocket());
        socketUtil.send(new Message("test"));
    }
}