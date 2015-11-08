package io.longyuan.shiro.redissession.controller;

import com.google.common.collect.Maps;
import io.longyuan.shiro.redissession.service.ShiroSessionService;
import io.longyuan.shiro.redissession.session.ShiroSession;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private ShiroSessionService sessionService;

    @RequestMapping("/active")
    @ResponseBody
    public List<Map<String, Object>> getActiveSessions() {
        return sessionService.getActiveSessions();
    }

    @RequestMapping("/read")
    @ResponseBody
    public Session readSession() {
        return sessionService.getSession();
    }

    @RequestMapping("/add")
    @SuppressWarnings("unchecked")
    public String add(String dataName, String dataValue) {
        // 把账号信息放到Session中，并更新缓存,用于会话管理
        ShiroSession session = sessionService.getSession();
        Map<String, String> customMap = (Map<String, String>) session.getAttribute("custom");
        if(customMap==null){
            customMap = Maps.newHashMap();
        }

        customMap.put(dataName, dataValue);
        sessionService.setAttribute(dataName, dataValue);
        return "redirect:/";
    }

    public void setSessionService(ShiroSessionService sessionService) {
        this.sessionService = sessionService;
    }
}
