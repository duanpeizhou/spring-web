package com.bluelemontree.depth.web;

import com.bluelemontree.depth.param.SaveHello;
import com.bluelemontree.depth.param.User;
import com.bluelemontree.depth.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
    public String hello(@ModelAttribute User user) {
        logger.info("hello user = ", user);
        return helloService.hello();
    }

    @ResponseBody
    @PostMapping("/save")
    public SaveHello save(@RequestBody SaveHello saveHello, HttpServletRequest request) {
        logger.info("save hello = {}", saveHello);
        logger.info("request uri = {}", request.getRequestURI());
        logger.info("save hello.bigData = {}",saveHello.getBigData().isPresent());
        return saveHello;
    }

}
