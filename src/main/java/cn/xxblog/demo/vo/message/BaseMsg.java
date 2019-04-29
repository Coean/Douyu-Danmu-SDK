package cn.xxblog.demo.vo.message;

/**
 * 功能描述：通用消息实体
 */
public class BaseMsg implements MsgEntity {
    private String uuid;
    private String type;
    private String message;

    public BaseMsg() {

    }

    public BaseMsg(String uuid, String type, String message) {
        this.uuid = uuid;
        this.type = type;
        this.message = message;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseMsg{" +
                "uuid='" + uuid + '\'' +
                ", type='" + type + '\'' +
                ", message='" + message + '\'' +
                '}';
    }


}
