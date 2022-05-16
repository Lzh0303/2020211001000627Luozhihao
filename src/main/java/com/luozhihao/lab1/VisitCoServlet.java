package com.luozhihao.lab1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/count")
public class VisitCoServlet extends HttpServlet {
    private int n=0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        n++;
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<div style='text-align:center;'><h2>This Servlet Clicks Times</h2></div>");
        out.println("<div style='text-align:center;'><h4>"+n+"</h4></div>");
    }
}

