package io.longyuan.shiro.redissession.listener;

import io.longyuan.shiro.redissession.service.ShiroSessionService;
import io.longyuan.shiro.redissession.session.CachingShiroSessionDao;
import lombok.Setter;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroSessionListener implements SessionListener {

    private static final Logger logger = LoggerFactory.getLogger(ShiroSessionListener.class);

    @Setter
    private ShiroSessionService shiroSessionService;

    @Setter
    private CachingShiroSessionDao sessionDao;

    @Override
    public void onStart(Session session) {
        // 会话创建时触发
        logger.debug("session {} onStart", session.getId());
    }

    @Override
    public void onStop(Session session) {
        sessionDao.delete(session);
        shiroSessionService.sendUncacheSessionMessage(session.getId());
        logger.debug("session {} onStop", session.getId());
    }

    @Override
    public void onExpiration(Session session) {
        sessionDao.delete(session);
        shiroSessionService.sendUncacheSessionMessage(session.getId());
        logger.debug("session {} onExpiration", session.getId());
    }

}
