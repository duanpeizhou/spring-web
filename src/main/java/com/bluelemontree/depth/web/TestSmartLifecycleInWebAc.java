package com.bluelemontree.depth.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Service;

/**
 * @author duanpeizhou on 2018/4/15 下午10:54.
 */
@Service
public class TestSmartLifecycleInWebAc implements SmartLifecycle {
    private static Logger logger = LoggerFactory.getLogger(TestSmartLifecycleInWebAc.class);

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
        logger.info("TestSmartLifecycleInWebAc started");
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
        return Integer.MAX_VALUE - 5;
    }
}
