package io.longyuan.shiro.redissession.controller;

import io.longyuan.shiro.redissession.filter.MyAuthenticationFilter;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class LoginController {

    /**
     * shiro通过/login访问该控制器方法，由该方法跳转到真实登陆页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal() != null) {
            return "portal";
        }
        return "login";
    }

    /**
     * 只有登陆认证失败才会访问到该方法
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String fail(@RequestParam(MyAuthenticationFilter.DEFAULT_LOGINNAME_PARAM) String userName, Model model) {
        model.addAttribute(MyAuthenticationFilter.DEFAULT_LOGINNAME_PARAM, userName);
        model.addAttribute(MyAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME, true);
        return "login";
    }
}
