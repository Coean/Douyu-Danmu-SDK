package cn.xxblog.demo;
import cn.xxblog.demo.util.MessageUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author barryp
 * 2019-04-25 9:05
 *     description:
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        log.info("hahhahh ");
        MessageUtil.parseMessageType("type@=keeplive/tick@=1556614599/uc@=0/rap@=0/hot@=0/ahot@=0/");

        // DanMuClient danMuClient = new DanMuClient(757122);
        // danMuClient.start();
    }

}
