package com.bluelemontree.depth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Service;

/**
 * @author duanpeizhou on 2018/4/15 下午10:43.
 */
@Service
public class TestSmartBeanLifecycle3 implements SmartLifecycle {

    private static Logger logger = LoggerFactory.getLogger(TestSmartBeanLifecycle3.class);

    private boolean isRunning = false;

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable callback) {
        callback.run();
        isRunning = false;
    }

    @Override
    public void start() {
        logger.info("TestSmartBeanLifecycle3 ... started");
        isRunning = true;
    }

    @Override
    public void stop() {
        isRunning = false;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public int getPhase() {
        return Integer.MAX_VALUE - 3;
    }
}
