package com.bluelemontree.depth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Service;

/**
 * @author duanpeizhou on 2018/4/15 下午8:18.
 */
@Service
public class TestInitBeanDependency implements ApplicationListener<ContextStartedEvent> {

    private static Logger logger = LoggerFactory.getLogger(TestInitBeanDependency.class);

    public TestInitBeanDependency() {
        logger.info("TestInitBeanDependency ");
    }

//    @PostConstruct
//    private void initMethod() {
//        logger.info("InitializingBean  initMethod");
//    }

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        String applicationName = applicationContext.getApplicationName();
        logger.info("applicationName = {}", applicationName);
        String displayName = applicationContext.getDisplayName();
        ApplicationContext parent = applicationContext.getParent();
        logger.info("displayName = {}", displayName);
        logger.info("parent = {}", parent);
    }
}
