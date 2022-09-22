/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skill_share.dao;

import com.skill_share.Util.Util;
import com.skill_share.model.Mdl_student;
import com.skill_share.model.Mdl_teacher;
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
public class Dao_teacher {
    
    private Connection connection;

    public Dao_teacher() {
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
private String edu_level ;
private String specification ;
private int account ;
 
   
    public void add_teacher(Mdl_teacher teacher) {
        connect_db();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into teacher (edu_level,specification,account) values (?,?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, teacher.getEdu_level());
            preparedStatement.setString(2, teacher.getSpecification());
            preparedStatement.setInt(3, teacher.getAccount());
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

    public void delete_teacher(int teacher_id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from teacher where teacher_id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, teacher_id);
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

    public void update_teacher(Mdl_teacher teacher ) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update teacher set edu_level=?,specification=?,account=? "
                    + "where teacher_id=?");
            // Parameters start with 1
            preparedStatement.setString(1, teacher.getEdu_level());
            preparedStatement.setString(2, teacher.getSpecification());
            preparedStatement.setInt(3, teacher.getAccount());
            preparedStatement.setInt(4, teacher.getTeacher_id());
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

    public List<Mdl_teacher> getAllteacher() {
        connect_db();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Mdl_teacher> teachers = new ArrayList<Mdl_teacher>();
        try {
            Statement statement = connection.createStatement();
            rs = statement.executeQuery("select * from teacher limit 80 ");
            while (rs.next()) {
                Mdl_teacher teacher = new Mdl_teacher();
                teacher.setTeacher_id(rs.getInt("teacher_id"));
                teacher.setEdu_level(rs.getString("edu_level"));
                teacher.setSpecification(rs.getString("specification"));
                teacher.setAccount(rs.getInt("account"));
                teachers.add( teacher);
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
        return teachers;
    }

    public Mdl_teacher getTeacherByid(int teacher_id) {
        connect_db();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Mdl_teacher  teacher = new Mdl_teacher();
        try {
            preparedStatement = connection.prepareStatement("select * from teacher where teacher_id=?");
            preparedStatement.setInt(1, teacher_id);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                teacher.setTeacher_id(rs.getInt("teacher_id"));
                teacher.setEdu_level(rs.getString("edu_level"));
                teacher.setSpecification(rs.getString("specification"));
                teacher.setAccount(rs.getInt("account"));
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
        return teacher;
    }
    
}
