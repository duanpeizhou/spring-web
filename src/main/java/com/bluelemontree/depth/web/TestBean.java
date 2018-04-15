package com.bluelemontree.depth.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Service;

/**
 * @author duanpeizhou on 2018/4/15 下午8:59.
 */
@Service
public class TestBean implements ApplicationContextAware,ApplicationListener<ContextRefreshedEvent> {
    private static Logger logger = LoggerFactory.getLogger(TestBean.class);
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        String displayName = applicationContext.getDisplayName();
        logger.info("displayName = {}", displayName);
        String applicationName = applicationContext.getApplicationName();
        logger.info("applicationName = {}", applicationName);
        String name = applicationContext.getClass().getName();
        logger.info("name {}", name);

        ApplicationContext parent = applicationContext.getParent();
        logger.info("parent class name {}", parent.getClass().getName());
        logger.info("displayName = {}", parent.getDisplayName());
        logger.info("applicationName = {}", parent.getApplicationName());
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Object source = event.getSource();
        logger.info("source = {}", source);
    }
}
