package com.luozhihao.lab3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HitCountServlet",value = "/HitCountServlet")
public class HitCountServlet extends HttpServlet {

    private int i;

    @Override
    public void init() throws ServletException {
        i = 0;
        super.init();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        i++;
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.write("<h1 align='center'>Total Number of Hits</h1>");
        pw.write("<h1 align='center'>"+ (++i) +"</h1>");
    }
}