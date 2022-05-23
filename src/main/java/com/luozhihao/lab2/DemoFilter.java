package com.luozhihao.lab2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "DemoFilter")
public class DemoFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter-->before chain");
        chain.doFilter(request, response);
        System.out.println("Filter-->after chain");
    }
}
