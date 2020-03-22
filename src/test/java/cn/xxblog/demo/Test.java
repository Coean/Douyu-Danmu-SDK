package cn.xxblog.demo;

import cn.xxblog.demo.listener.GiftMsgListener;
import lombok.extern.slf4j.Slf4j;

/**
 * @author barryp
 * 2019-04-25 9:05
 * description:
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        DanMuClient danMuClient = new DanMuClient(485503);
        danMuClient.addListener(new GiftMsgListener());
        danMuClient.start();
//        MapToVoUtil<ChatMsg> mapToVoUtil  = new MapToVoUtil<ChatMsg>();
//        ChatMsg chatMsg = mapToVoUtil.convertByMap(new HashMap<>());

    }

}
