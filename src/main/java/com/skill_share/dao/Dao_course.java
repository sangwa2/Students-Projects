/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skill_share.dao;

import com.skill_share.Util.Util;
import com.skill_share.model.Mdl_chat;
import com.skill_share.model.Mdl_course;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SANGWA
 */
public class Dao_course {
     private Connection connection;

    public Dao_course() {
    connect_db();
            }
  private void connect_db() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/" + Util.db;
            String user = Util.username;
            String passwd = Util.password;
            connection = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            System.out.println("Error on db: " + e.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger("The connection error: " + Util.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  private String course_title ;
  
    public void add_course(Mdl_course course) {
        connect_db();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into course (course_title) values (?)");
            // Parameters start with 1
            preparedStatement.setString(1, course.getCourse_title());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    preparedStatement.close();
                    connection.close();
                }
            } catch (Exception e) {
            }

        }
    }

    public void delete_course(int course_id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from course where course_id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, course_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    preparedStatement.close();
                    connection.close();
                }
            } catch (Exception e) {
            }
        }
    }

    public void update_cource(Mdl_course cource) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update cource set course_title=? "
                    + "where cource_id=?");
            // Parameters start with 1
            preparedStatement.setString(1, cource.getCourse_title());
            preparedStatement.setInt(2, cource.getCourse_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    preparedStatement.close();
                    connection.close();
                }
            } catch (Exception e) {
            }
        }
    }

    public List<Mdl_course> getAllcourse() {
        connect_db();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Mdl_course> courses = new ArrayList<Mdl_course>();
        try {
            Statement statement = connection.createStatement();
            rs = statement.executeQuery("select * from course limit 80 ");
            while (rs.next()) {
                Mdl_course course = new Mdl_course();
                course.setCourse_id(rs.getInt("course_id"));
                course.setCourse_title(rs.getString("course_title"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("There is not data or what?" + e.toString());
        } finally {
            try {
                if (connection != null) {
                    preparedStatement.close();
                    rs.close();
                    connection.close();
                }
            } catch (Exception e) {
            }
        }
        return courses;
    }

    public Mdl_course getCourseByid(int course_id) {
        connect_db();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Mdl_course course = new Mdl_course();
        try {
            preparedStatement = connection.prepareStatement("select * from course where course_id=?");
            preparedStatement.setInt(1, course_id);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                course.setCourse_id(rs.getInt("course_id"));
                course.setCourse_title(rs.getString("course_title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    preparedStatement.close();
                    connection.close();
                }
            } catch (Exception e) {
            }
        }
        return course;
    }
}
