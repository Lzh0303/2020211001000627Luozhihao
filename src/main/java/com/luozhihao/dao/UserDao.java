package com.luozhihao.dao;

import com.luozhihao.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


//@WebServlet(name = "LoginServlet", value = "/login")
public class UserDao implements IUserDao {

    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql="delete from usertable where id=?";
        PreparedStatement st=con.prepareStatement(sql);
//        st.setString(1,user.getId());
        int rs=st.executeUpdate();
        return rs;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql="update user set username=?,password=?,email=?,gender=?,birthdate=? where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,user.getUsername());
        st.setString(2,user.getPassword());
        st.setString(3, user.getEmail());
        st.setString(4,user.getGender());
        st.setString(5,new SimpleDateFormat("yyyy-MM-dd").format(user.getBirthdate()));
        st.setString(6,String.valueOf(user.getId()));
        int rs=st.executeUpdate();
        return rs;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        return null;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql="select id,username,password,email,gender,birthdate from user where username=? and password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs=st.executeQuery();

        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("Id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        return null;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        return null;
    }
}
