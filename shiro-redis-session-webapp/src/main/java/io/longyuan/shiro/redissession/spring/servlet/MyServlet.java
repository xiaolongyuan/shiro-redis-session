package io.longyuan.shiro.redissession.spring.servlet;

import io.longyuan.shiro.redissession.spring.bean.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class MyServlet extends HttpServlet {

    @Autowired
    private SpringBean springBean;

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        springBean.servlet();
        PrintWriter out = response.getWriter();
        out.println("<h3>Hello World</h3>");
        out.flush();
        out.close();
    }
}