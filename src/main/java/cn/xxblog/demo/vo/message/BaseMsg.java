package cn.xxblog.demo.vo.message;

import lombok.Data;

import java.io.Serializable;

/**
 * 功能描述：通用消息实体
 */
@Data
public class BaseMsg implements Serializable {

    private String type;

    private String rawMessage;
}
