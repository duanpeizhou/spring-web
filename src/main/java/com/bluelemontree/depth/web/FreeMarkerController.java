package com.bluelemontree.depth.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author duanpeizhou on 2018/10/22 下午9:27.
 */
@Controller
@RequestMapping("/freemarker")
public class FreeMarkerController {

    @GetMapping("/home.html")
    public String index(Model model) {
        model.addAttribute("name", "段培州");
        return "/index";
    }

    @GetMapping("/home2")
    public String index2() {
        return "/index";
    }

}
