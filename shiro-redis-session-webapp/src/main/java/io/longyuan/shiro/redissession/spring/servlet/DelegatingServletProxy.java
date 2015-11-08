package io.longyuan.shiro.redissession.spring.servlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import java.io.IOException;

public class DelegatingServletProxy extends GenericServlet {

    private String targetBean;
    private Servlet proxy;

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException,
            IOException {
        proxy.service(request, response);
    }

    @Override
    public void init() throws ServletException {
        this.targetBean = getServletName();
        setServletBean();
        proxy.init(getServletConfig());
    }

    private void setServletBean() {
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        this.proxy = (Servlet) wac.getBean(targetBean);
    }
}
