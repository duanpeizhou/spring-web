package com.bluelemontree.depth.service;

import com.bluelemontree.depth.mapper.HelloMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author duanpeizhou on 2018/4/15 下午7:00.
 */
@Service
public class HelloService {

    private static Logger logger = LoggerFactory.getLogger(HelloService.class);

    @Resource
    private HelloMapper helloMapper;

    public HelloService() {
        logger.info("HelloService bean created , properties:{}", helloMapper);
    }

    public String hello() {
        return helloMapper.hello();
    }

    @PostConstruct
    public void serviceInRootAc() {
        logger.info("method in root ac invoked , properties:{}", helloMapper);
    }
}
