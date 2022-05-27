package com.luozhihao.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        String txt = request.getParameter("txt");
        if (search.equals("baidu")){
            response.sendRedirect("https://www.baidu.com/s?ie=utf-8&f=8&wd="+txt);
        }
        if(search.equals("bing")){
            response.sendRedirect("https://www.bing.com/search?q="+txt+"&ie=UTF-8");
        }
        if (search.equals("google")){
            response.sendRedirect("https://www.google.com/search?q="+txt+"&ie=UTF-8");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
