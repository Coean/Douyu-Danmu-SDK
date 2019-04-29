package cn.xxblog.demo.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * HexUtil Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Apr 29, 2019</pre>
 */
public class HexUtilTest {
    /**
     * Method: bytes2HexStringWithSpace(byte[] b)
     */
    @Test
    public void testBytes2HexStringWithSpace() throws Exception {
        byte[] bytes = HexUtil.hexString2Bytes("0102030405");
        Assert.assertArrayEquals(new byte[] {1, 2, 3, 4, 5}, bytes);
    }

    /**
     * Method: hexString2Bytes(String hexString)
     */
    @Test
    public void testHexString2Bytes() throws Exception {
        String s = HexUtil.bytes2HexString(new byte[] {1, 2, 3, 4, 5});
        System.out.println(s);
        Assert.assertEquals("0102030405", s);
    }


} 
