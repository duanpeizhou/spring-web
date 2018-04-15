package com.bluelemontree.depth.web;

import com.bluelemontree.depth.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author duanpeizhou on 2018/4/15 下午6:51.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Resource
    private HelloService helloService;

    public HelloController() {
        logger.info("HelloController  constructor  invoke");
    }

    @GetMapping("/name")
    public String hello() {
        return helloService.hello();
    }


    @PostConstruct
    public void init() {
        logger.info("init method in web ac invoke", helloService);
    }
}
