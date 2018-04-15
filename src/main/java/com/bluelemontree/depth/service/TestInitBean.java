package com.bluelemontree.depth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author duanpeizhou on 2018/4/15 下午8:08.
 */

@Service
public class TestInitBean implements InitializingBean, ApplicationListener<ContextStartedEvent> {

    private static Logger logger = LoggerFactory.getLogger(TestInitBean.class);
    private TestInitBeanDependency testInitBeanDependency;

    public TestInitBean() {
        logger.info("InitializingBean TestInitBean method invoked");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("InitializingBean afterPropertiesSet method invoked {}", testInitBeanDependency);
    }

    @PostConstruct
    public void initMethod() {
        logger.info("InitializingBean PostConstruct method invoked.testInitBeanDependency{}", testInitBeanDependency);
    }

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        String applicationName = applicationContext.getApplicationName();
        logger.info("applicationName = {}", applicationName);
        String displayName = applicationContext.getDisplayName();
        logger.info("displayName = {}", displayName);
        ApplicationContext parent = applicationContext.getParent();
        logger.info("parent = {}", parent);

    }
}
