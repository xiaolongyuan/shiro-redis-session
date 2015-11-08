package io.longyuan.shiro.redissession.service;

import org.apache.shiro.session.Session;

import java.io.Serializable;
import java.util.Collection;


public interface ShiroSessionRepository {

    /**
     * 保存会话
     * @param session
     */
    void saveSession(Session session);

    /**
     * 保存会话
     * @param session
     */
    void updateSession(Session session);

    /**
     * 刷新缓存重新计算过期时间
     * @param sessionId
     */
    void refreshSession(Serializable sessionId);

    /**
     * 删除会话
     * @param sessionId
     */
    void deleteSession(Serializable sessionId);

    /**
     * 获取会话
     * @param sessionId
     * @return
     */
    Session getSession(Serializable sessionId);

    /**
     * 获取所会话
     * @return
     */
    Collection<Session> getAllSessions();
}