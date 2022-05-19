package com.luozhihao.controller;

import com.luozhihao.dao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/getImg")
public class GetImageServlet extends HttpServlet {
    Connection con=null;

    @Override
    public void init() throws ServletException {
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        ProductDao dao=new ProductDao();
        int id=0;
        if (req.getParameter("id")!=null){
            id=Integer.parseInt(req.getParameter("id"));
        }
        try{
            byte[] imgByte=new byte[0];
            imgByte=dao.getPictureById(id,con);
            if (imgByte!=null){
                resp.setContentType("image/gif");
                OutputStream os= resp.getOutputStream();
                os.write(imgByte);
                os.flush();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
