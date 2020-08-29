package io.github.ztkmkoo.dss.core.message;

import akka.actor.typed.ActorRef;
import io.github.ztkmkoo.dss.core.actor.enumeration.DssMasterActorStatus;
import lombok.Builder;
import lombok.Getter;

/**
 * @author Kebron ztkmkoo@gmail.com
 * @create 2020-08-23 00:32
 */
public interface DssMasterCommand extends DssCommand {

    class Bind implements DssMasterCommand{
        private static final long serialVersionUID = -6291619473907870504L;
    }

    class Shutdown implements DssMasterCommand {
        private static final long serialVersionUID = 8437169186189342859L;
    }

    @Getter
    class StatusRequest implements DssMasterCommand {
        private static final long serialVersionUID = 8724292690016254956L;

        private final ActorRef<DssMasterCommand> sender;

        @Builder
        public StatusRequest(ActorRef<DssMasterCommand> sender) {
            this.sender = sender;
        }
    }

    @Getter
    class StatusResponse implements DssMasterCommand {
        private static final long serialVersionUID = 7231536850003256590L;

        private final DssMasterActorStatus status;

        @Builder
        public StatusResponse(DssMasterActorStatus status) {
            this.status = status;
        }
    }

    @Getter
    class StatusUpdate implements DssMasterCommand {
        private static final long serialVersionUID = 9124412765371994928L;

        private final DssMasterActorStatus status;

        @Builder
        public StatusUpdate(DssMasterActorStatus status) {
            this.status = status;
        }
    }
}