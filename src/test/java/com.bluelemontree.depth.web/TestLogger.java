package com.bluelemontree.depth.web;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.time.LocalDate;

/**
 * @author duanpeizhou on 2018/6/8 下午2:34.
 */
public class TestLogger {

    @Test
    public void testLogCreate() {
        Logger logger = Logger.getLogger("MyLogger");
        logger.info("hello");
        System.out.println(getStr(1));
    }

    private String getStr(int times) {
        try {
            if (times == 1) {
                System.out.println(times);
                System.out.println("true");
                return "ok";
            }
            System.out.println("else");
        } finally {
            System.out.println("finally");
        }
        return "shutdown";
    }

    @Test
    public void testLocalDate() {
        LocalDate date = LocalDate.now();
        int day = 5;
        for (int i = 0; i < 5; i++) {
            System.out.println(date);
            date = date.plusDays(1);
        }

    }

}
