package cn.xxblog.demo.vo;

public class Constants {

    public static Long DEFAULT_KEEP_ALIVE_TIME = 42 * 1000L;

    public static Integer DEFAULT_GROUP = -9999;


    public static final String DOUYU_HOST = "danmuproxy.douyu.com";

    public static final Integer DOUYU_PORT = 8601;

    private static String KEEP_ALIVE = "type@=keeplive/tick@=%d/\0";

    private static String LOGIN_MESSAGE = "type@=loginreq/roomid@=%d/\0";
    private static String JOIN_GROUP_MESSAGE = "type@=joingroup/rid@=%d/gid@=%d/\0";

    private static String ROOM_GIFT = "type@=dmfbdreq/dfl@=sn@AA=105@ASss@AA=0@AS@Ssn" +
            "@AA=106@ASss@AA=0@AS@Ssn@AA=107@ASss@AA=0@AS@Ssn@AA=108@ASss@AA=0@AS@Ssn@AA=110@ASss@AA=0@AS@S/";


    /**
     * return keep alive message.
     */
    public static Message keepAliveMessage() {
        return new Message(String.format(KEEP_ALIVE, (System.currentTimeMillis() / 1000)));
    }

    /**
     * return join danmu group message
     */
    public static Message joinGroupMessage(Integer roomId) {
        return new Message(String.format(JOIN_GROUP_MESSAGE, roomId, DEFAULT_GROUP));
    }

    /**
     * return login message group
     */
    public static Message loginMessage(Integer roomId) {
        return new Message(String.format(LOGIN_MESSAGE, roomId));
    }

    /**
     * return login message group
     */
    public static Message getAllGift() {
        return new Message(ROOM_GIFT);
    }
}
