package io.longyuan.shiro.redissession.service;

import org.springframework.data.redis.connection.DefaultMessage;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import java.io.Serializable;

/**
 * Created by LongYuan on 2015-11-8.
 */
public class ShiroSessionMessage extends DefaultMessage {

    private JdkSerializationRedisSerializer redisSerializer = new JdkSerializationRedisSerializer();

    public final MessageBody msgBody;

    public ShiroSessionMessage(byte[] channel, byte[] body) {
        super(channel, body);

        msgBody = (MessageBody) redisSerializer.deserialize(body);

    }


    public static class MessageBody implements Serializable {
        public final Serializable sessionId;
        public final String nodeId;
        public String msg = "";

        public MessageBody(Serializable sessionId, String nodeId) {
            this.sessionId = sessionId;
            this.nodeId = nodeId;
        }

        public MessageBody(Serializable sessionId, String nodeId, String msg) {
            this.sessionId = sessionId;
            this.nodeId = nodeId;
            this.msg = msg;
        }

        @Override
        public String toString() {
            return "MessageBody{" +
                    "sessionId='" + sessionId + '\'' +
                    ", nodeId='" + nodeId + '\'' +
                    ", msg='" + msg + '\'' +
                    '}';
        }
    }


}
