package cn.xxblog.demo.vo;

import cn.xxblog.demo.util.SocketUtil;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
public class RoomSocket {
    private Integer roomId;
    private SocketUtil socketUtil;
    private Long nextKeepTime;

    public void validate() {
        if (Objects.isNull(this.socketUtil)) {
            throw new IllegalArgumentException("socketUtil不能为空");
        }
        if (Objects.isNull(this.roomId)) {
            throw new IllegalArgumentException("RoomID不能为空");

        }
    }
}