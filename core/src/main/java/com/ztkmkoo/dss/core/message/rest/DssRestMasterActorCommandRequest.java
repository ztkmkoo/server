package com.ztkmkoo.dss.core.message.rest;

import akka.actor.typed.ActorRef;
import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

/**
 * Project: dss
 * Created by: @ztkmkoo(ztkmkoo@gmail.com)
 * Date: 20. 3. 3. 오후 10:07
 */
@Getter
public class DssRestMasterActorCommandRequest implements DssRestMasterActorCommand {

    private static final long serialVersionUID = 6046370337632314401L;
    private final String channelId;
    private final ActorRef<DssRestChannelHandlerCommand> sender;

    @Builder
    private DssRestMasterActorCommandRequest(String channelId, ActorRef<DssRestChannelHandlerCommand> sender) {
        this.channelId = channelId;
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "DssRestMasterActorCommandRequest{" +
                "channelId: '" + channelId + "', " +
                "sender: '" + (Objects.nonNull(sender)? sender.path().name() : "null") + "'" +
                "}";
    }
}