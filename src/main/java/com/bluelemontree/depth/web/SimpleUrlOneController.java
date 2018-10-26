package com.bluelemontree.depth.web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author duanpeizhou on 2018/10/25 上午11:05.
 */
public class SimpleUrlOneController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView index = new ModelAndView("index");
        index.addObject("name", "SimpleUrlOneController");
        return index;
    }
}
