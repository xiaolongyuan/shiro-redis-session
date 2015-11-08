package io.longyuan.shiro.redissession.spring.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("springBean")
public class SpringBean {

    private static final Logger logger = LoggerFactory.getLogger(SpringBean.class);

    public void listener() {
        logger.info("listener use spring bean");
    }

    public void servlet() {
        logger.info("servlet use spring bean");
    }

    public void filter() {
        logger.info("filter use spring bean");
    }


}