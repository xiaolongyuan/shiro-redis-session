package redis.test;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class DefaultMessageDelegate implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("pattern:"+new String(pattern)+"\tchannel:"+new String(message.getChannel())+"\tbody:"+new String(message.getBody()));
    }
    // implementation elided for clarity...
}