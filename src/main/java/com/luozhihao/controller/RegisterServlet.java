package com.luozhihao.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private Connection con;

    @Override
    public void init() throws ServletException {
        super.init();
//4. Get all 4 context init parameters within RegisterServletàinit()
       /* ServletContext context=getServletContext();
        String driver=context.getInitParameter("driver");//<param-name>driver</param-name>
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        //5.Create database connection within init()
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("init()--> " + con);// ok(java code)- ok(use config-in web.xml) -- ok -use( @webservlet )--> (use context) ok-- use mysql ( no need to change in java code )
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/


        con = (Connection) getServletContext().getAttribute("con");//name of attibute
        //please check the video live demo#4

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //when method =post -request come in doPost

        //get all data - from Request
        String username =request.getParameter("username");//get Username <input type="text" name="username" />
        String password =request.getParameter("password");//get  password <input type="password" name="password" />
        String email =request.getParameter("email");//get <input type="text" name="email" />
        String gender =request.getParameter("gender");//get <input type="radio" name="gender"
        String birthDate =request.getParameter("birthdate");//get Birth Date <input type="text" name="birthDate" />

        //6.Insert a row into database table “usertable” in doPost()

        try {
            Statement st = con.createStatement();
            String sql = "insert into user(username,password,email,gender,birthdate)" +
                    " values('" + username + "','" + password + "','" + email + "','" + gender + "','" + birthDate + "')";
            System.out.println("sql" + sql);//check sql is ok or not

            int n = st.executeUpdate(sql);
            System.out.println("n-->" + n);//== 1 success--insert


            //7. seleect all rows from user table
            //  sql="select id,username,password,email,gender,birthdate from usertable ";
            // ResultSet rs= st.executeQuery(sql);
            //PrintWriter out=response.getWriter();

          /*  out.println("<html><title></title><body><table border=1><tr>");
            out.println("<td>Username</td><td>password</td><td>Email</td><td>Gender</td><td>Birthday</td><tr/>");
          while(rs.next()){
//get one by one
                out.println("<tr>");
                out.println("<td>"+rs.getString("username")+"</td>");
                out.println("<td>"+rs.getString("password")+"</td>");
                out.println("<td>"+rs.getString("email")+"</td>");
                out.println("<td>"+rs.getString("gender")+"</td>");
                out.println("<td>"+rs.getString("birthdate")+"</td>");

                out.println("</tr>");


            }
            out.println("</table></body></html>");*/

            //use request attribute
            //set rs into request attribute
            //request.setAttribute("rsname",rs); //name - string , value - any type (object)

            //request.getRequestDispatcher("userList.jsp").forward(request,response);

            //week6
            //after register a new user - user can login
            response.sendRedirect("login");

        } catch (SQLException e) {
            e.printStackTrace();
        }


        //print all data-- write into response
         /*PrintWriter out=response.getWriter();
         out.println("UserName : "+username);
        out.println("Password : "+password);
        out.println("email : "+email);
        out.println("gender : "+gender);
        out.println("BirthDate : "+birthDate);
        out.println("UserName : "+username);*/

        //

    }
}
