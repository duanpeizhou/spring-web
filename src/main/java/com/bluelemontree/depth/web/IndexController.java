package com.bluelemontree.depth.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author duanpeizhou on 2018/10/24 下午8:18.
 */
@RestController
public class IndexController {

    @GetMapping("/index.do")
    public String index() {
        return "index";
    }
}
