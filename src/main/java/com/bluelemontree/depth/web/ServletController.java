package com.bluelemontree.depth.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author by duanpeizhou on 2018/4/15 下午5:47.
 */
public class ServletController extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("hello world");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("servlet " + this.getServletName() + "has started");
    }

    @Override
    public void destroy() {
        System.out.println("servlet " + this.getServletName() + "has destroy");
    }
}
