package io.longyuan.shiro.redissession.spring.filter;


import io.longyuan.shiro.redissession.spring.bean.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Autowired
    private SpringBean springBean;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("MyFilter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        springBean.filter();
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("MyFilter destroy");
    }
}