package com.luozhihao.lab2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = {"/lab2/welcome.jsp"})
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("LoginFilter -> init()");
    }

    public void destroy() {
        System.out.println("destroy -- > LoginFilter");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("LoginFilter --> request before chain");

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        if (request.getSession() != null && request.getSession().isNew()){
            request.getRequestDispatcher("/lab2/welcome.jsp").forward(request,response);
        }else {
            response.sendRedirect(request.getContextPath() + "/lab2/login.jsp");
        }
        chain.doFilter(request, response);
        System.out.println(" LoginFilter --> request after chain");
    }
}
