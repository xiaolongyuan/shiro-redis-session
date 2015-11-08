package io.longyuan.shiro.redissession.spring.listener;

import io.longyuan.shiro.redissession.spring.bean.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 功能说明：测试自定义Listener使用spring使用注解定义的bean
 */
public class MyListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(MyListener.class);


    @Override
    public void contextInitialized(ServletContextEvent event) {
        WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
        SpringBean bean = (SpringBean) springContext.getBean("springBean");
        bean.listener();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("MyListener contextDestroyed");
    }
}