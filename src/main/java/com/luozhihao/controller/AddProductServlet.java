package com.luozhihao.controller;

import com.luozhihao.dao.ProductDao;
import com.luozhihao.model.Category;
import com.luozhihao.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AddProductServlet",value = "/admin/addProduct")
@MultipartConfig(maxFileSize = 16177215)
public class AddProductServlet extends HttpServlet {
    private Connection con=null;
    @Override
    public void init() throws ServletException {
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品类型
        try {
            List<Category> list=Category.findAllCategory(con);
            req.setAttribute("categoryList",list);
            //we will use late
            String path="../WEB-INF/views/admin/addProduct.jsp";
            req.getRequestDispatcher(path).forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取产品名
        String productName=req.getParameter("productName");
        //获取产品描述
        String productDescription=req.getParameter("productDescription");
        //获取商品价格
        double price=req.getParameter("price")!=null?Double.parseDouble(req.getParameter("price")):0.0;
        //获取商品类型编号
        Integer categoryId=req.getParameter("categoryId")!=null?Integer.parseInt(req.getParameter("categoryId")):0;
        //获取产品图片
        InputStream inputStream=null;
        Part filePart=req.getPart("picture");
        if (filePart!=null){
            inputStream=filePart.getInputStream();
        }
        //创建产品对象
        Product product=new Product();
        product.setProductName(productName);
        product.setProductDescription(productDescription);
        product.setPrice(price);
        product.setCategoryId(categoryId);
        product.setPicture(inputStream);
        //保存
        ProductDao productDao=new ProductDao();
        try {
            int save = productDao.save(product, con);
            if (save>0){
                resp.sendRedirect("productList");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
