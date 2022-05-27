package com.luozhihao.controller;

import com.luozhihao.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminHomeServlet", value = "/admin/home")
public class AdminHomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session!=null&& session.getAttribute("user")!=null) {
            User user = (User) session.getAttribute("user");
            if("admin".equals(user.getUsername())) {
                request.getRequestDispatcher("../WEB-INF/views/admin/index.jsp").forward(request,response);
            }else  {
                session.invalidate();
                request.setAttribute("message", "Unauthorized Access Admin Module!!!");
                request.getRequestDispatcher("../WEB-INF/views/login.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("message", "Please Login as admin!!!!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
