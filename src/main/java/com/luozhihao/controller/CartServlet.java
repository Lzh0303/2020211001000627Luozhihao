package com.luozhihao.controller;

import com.luozhihao.dao.ProductDao;
import com.luozhihao.model.Item;
import com.luozhihao.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServlet",value = "/cart")
public class CartServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null){
            if (request.getParameter("action") == null){
                displayCart(request,response);
            }else if (request.getParameter("action").equals("add")){
                try{
                    buy(request,response);
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }else if (request.getParameter("action").equals("remove")){
                remove(request,response);
            }
        }else {
            response.sendRedirect("login");
        }
    }

    private void displayCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message","Your Cart");
        request.getRequestDispatcher("/WEB-INF/views/cart.jsp").forward(request,response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        int id = 0;
        if (request.getParameter("productId") != null){
            id = Integer.parseInt(request.getParameter("productId"));
        }
        int index = isExisting(id,cart);
        cart.remove(index);
        session.setAttribute("cart",cart);
        response.sendRedirect(request.getContextPath()+"/cart");
    }

    private void buy(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        HttpSession session = request.getSession();
        int id = request.getParameter("productId") != null ? Integer.parseInt(request.getParameter("productId")):0;
        int quantityParam = request.getParameter("quantity") != null ? Integer.parseInt(request.getParameter("quantity")) : 1;
        if (id==0||quantityParam==0){
            return;
        }
        ProductDao dao = new ProductDao();
        if (session.getAttribute("cart") == null){
            ArrayList<Item> cart = new ArrayList<Item>();
            Product p = dao.findById(id, con);
            cart.add(new Item(p,quantityParam));
            session.setAttribute("cart",cart);
        }else {
            List<Item> cart = (List<Item>) session.getAttribute("cart");
            int index = isExisting(id,cart);
            if (index == -1){
                cart.add(new Item(dao.findById(id,con),1));
            }else {
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
            }
            session.setAttribute("cart",cart);
        }
        response.sendRedirect(request.getContextPath()+"/cart");
    }

    private int isExisting(int id, List<Item> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getProductId() == id){
                return i;
            }
        }
        return -1;
    }
}
