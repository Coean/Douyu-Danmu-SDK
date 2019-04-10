package cn.xxblog.demo;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseMsg implements Serializable {

    private String type;


}
