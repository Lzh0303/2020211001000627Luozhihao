package com.luozhihao.lab1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MyDearJsp")
public class MyDearServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name").trim();
        System.out.printf(name);
        String _class = req.getParameter("class").trim();
        String ID = req.getParameter("ID").trim();
        String submit = req.getParameter("submit").trim();
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        out.print("<html>\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">"+
                "<title>MyDearServlet</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    name:"+name+"<br/>\n" +
                "    submit:"+submit+"<br/>\n"+
                "    class:"+_class+"<br/>\n" +
                "    ID:"+ID+"<br/>\n" +
                "</body>\n" +
                "</html>");
        out.close();
    }

}