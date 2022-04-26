package com.luozhihao.controller;

import com.luozhihao.dao.UserDao;
import com.luozhihao.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        /// TODO 1: GET 4 CONTEXT PARAM - DRIVER , URL , USERNAME , PASSWORD
        // TODO 2: GET JDBC connection
        //only one one
        con = (Connection) getServletContext().getAttribute("con");
        //check the video live demo#4
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // doPost(request,response);//call dopost
        //when user click Login from menu- method is get
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out= response.getWriter();
        // TODO 3: GET REQUEST PARAMETER - USERNAME AND PASSWORD
        String username=request.getParameter("username");
        String password=request.getParameter("password");


        UserDao userDao=new UserDao();
        try {
            User user=userDao.findByUsernamePassword(con,username,password);
            if(user!=null){
                //将数据保存在session中
//                request.setAttribute("user",user);
                //add code for rememberMe
                String rememberMe=request.getParameter("rememberMe");
                if (rememberMe!=null&&rememberMe.equals("1")){
                    // want to rememberMe
                    //create 3cookies
                    Cookie usernameCookie=new Cookie("username",user.getUsername());
                    Cookie passwordCookie=new Cookie("password",user.getPassword());
                    Cookie rememberMeCookie=new Cookie("rememberMe",rememberMe);
                    //set age of cookies
                    usernameCookie.setMaxAge(50);
                    passwordCookie.setMaxAge(50);
                    rememberMeCookie.setMaxAge(50);

                    //add cookir to response
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }
                request.getSession().setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }else{
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }






//        try {
//
//            //lets change code to make MVC

//
//            //TODO 4: VALIDATE USER - SELEECT * FROM USERTABLE WHERE USERNAME='XXX'
//            // AND PASSWORD='YYY'
//            String sql="select id,username,password,email,gender,birthdate from usertable where username='"+username+"' and password='"+password+"'";
//
//            ResultSet rs =con.createStatement().executeQuery(sql);
//            if (rs.next()){
//                //week 5 code
//                //out.print("Login Successful!!!");
//                //out.print("Welcome"+username);
//                //get from rs and set into resquest attribute
//
//                request.setAttribute("id",rs.getInt("id"));
//                request.setAttribute("username",rs.getString("username"));
//                request.setAttribute("password",rs.getString("password"));
//                request.setAttribute("email",rs.getString("email"));
//                request.setAttribute("gender",rs.getString("gender"));
//                request.setAttribute("birthDate",rs.getString("birthdate"));
//                //forward to userInfo.jsp
//                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
//
//            }else{
//                //out.print("Username or password Error!!!");
//                request.setAttribute("message","Username or Password Error!!!");
//                request.getRequestDispatcher("login.jsp").forward(request,response);
//
//            }//end of else
//
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

    }
}