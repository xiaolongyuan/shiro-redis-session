package io.longyuan.shiro.redissession.service;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * Created by LongYuan on 2015-11-8.
 */
public abstract class ShiroSessionMessageListener implements MessageListener {

    @Override
    public final void onMessage(Message message, byte[] bytes) {

        onMessage(new ShiroSessionMessage(message.getChannel(),message.getBody()));

    }
    public abstract void onMessage(ShiroSessionMessage message) ;

}
