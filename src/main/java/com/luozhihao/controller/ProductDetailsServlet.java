package com.luozhihao.controller;


import com.luozhihao.dao.ProductDao;
import com.luozhihao.model.Category;
import com.luozhihao.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/productDetails")
public class ProductDetailsServlet  extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            List<Category>categoryList=Category.findAllCategory(con);
            req.setAttribute("categoryList",categoryList);
        }catch (SQLException e){
            e.printStackTrace();
        }
        //get product by id
        if (req.getParameter("id")!=null){
            int productId =Integer.parseInt(req.getParameter("id"));
            ProductDao productDao =new ProductDao();
            try {
                Product product=productDao.findById(productId,con);
                req.setAttribute("p",product);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        //forward
        String path="/WEB-INF/views/productDetails.jsp";
        req.getRequestDispatcher(path).forward(req,resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

