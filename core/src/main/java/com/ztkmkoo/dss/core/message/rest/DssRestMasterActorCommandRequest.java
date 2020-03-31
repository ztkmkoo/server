package com.ztkmkoo.dss.core.message.rest;

import akka.actor.typed.ActorRef;
import com.ztkmkoo.dss.core.network.rest.enumeration.DssRestContentType;
import com.ztkmkoo.dss.core.network.rest.enumeration.DssRestMethodType;
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
    private final DssRestMethodType methodType;
    private final DssRestContentType contentType;
    private final String path;
    private final String content;

    @Builder
    DssRestMasterActorCommandRequest(
            String channelId,
            ActorRef<DssRestChannelHandlerCommand> sender,
            DssRestMethodType methodType,
            DssRestContentType contentType,
            String path,
            String content) {
        Objects.requireNonNull(channelId);
        Objects.requireNonNull(sender);
        Objects.requireNonNull(methodType);
        Objects.requireNonNull(path);

        this.channelId = channelId;
        this.sender = sender;
        this.methodType = methodType;
        this.contentType = contentType;
        this.path = path;
        this.content = content;
    }

    @Override
    public String toString() {
        return "DssRestMasterActorCommandRequest{" +
                "channelId: '" + channelId + "', " +
                "sender: '" + (Objects.nonNull(sender)? sender.path().name() : "null") + "', " +
                "methodType: '" + methodType.name() + "', " +
                "contentType: '" + contentType.name() + "', " +
                "path: '" + path + "', " +
                "content: '" + content + "'" +
                "}";
    }
}
