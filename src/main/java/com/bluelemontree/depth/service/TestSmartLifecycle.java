package com.bluelemontree.depth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author duanpeizhou on 2018/4/15 下午10:07.
 */
@Service
public class TestSmartLifecycle implements SmartLifecycle {

    private static Logger logger = LoggerFactory.getLogger(TestSmartLifecycle.class);
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

        logger.info("TestSmartLifecycle ....TestSmartLifecycle ... 2");

    }

    @Override
    public void stop() {
        System.out.println("stop");
        isRunning = false;
    }

    /**
     * 1. 只有该方法返回false时，start方法才会被执行。
     * 2. 只有该方法返回true时，stop(Runnable callback)或stop()方法才会被执行。
     */
    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public int getPhase() {
        return Integer.MAX_VALUE - 2;
    }

    @PostConstruct
    private void init() {
        logger.info("TestSmartLifecycle .... PostConstruct");
    }

}
