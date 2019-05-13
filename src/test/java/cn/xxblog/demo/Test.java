package cn.xxblog.demo;

import cn.xxblog.demo.listener.ChatMsgListener;
import lombok.extern.slf4j.Slf4j;

/**
 * @author barryp
 *     2019-04-25 9:05
 *     description:
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        DanMuClient danMuClient = new DanMuClient(485503);
        danMuClient.addListener(new ChatMsgListener());
        danMuClient.start();

        // MapToVoUtil<ChatMsg> util = new MapToVoUtil<>();
        // util.convertByMap(new HashMap<>(), ChatMsg.class);
    }

}
