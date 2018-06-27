package com.bluelemontree.depth.web;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author duanpeizhou on 2018/6/8 下午2:34.
 */
public class TestLogger {

    @Test
    public void testLogCreate() {
        Logger logger = Logger.getLogger("MyLogger");
        logger.info("hello");
    }
}
