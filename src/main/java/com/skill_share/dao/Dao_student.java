/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skill_share.dao;

import com.skill_share.Util.Util;
import com.skill_share.model.Mdl_chat;
import com.skill_share.model.Mdl_student;
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
public class Dao_student {

    private Connection connection;

    public Dao_student() {
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

   
    public void add_student(Mdl_student student) {
        connect_db();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into student (account,level,gender,year) values (?,?,?,?)");
            // Parameters start with 1
            preparedStatement.setInt(1, student.getAccount());
            preparedStatement.setString(2, student.getLevel());
            preparedStatement.setString(3, student.getGender());
            preparedStatement.setString(4, student.getYear());
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

    public void delete_student(int student_id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from student where student_id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, student_id);
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

    public void update_student(Mdl_student student) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update student set account=?,level=?,gender=?,year=? "
                    + "where student_id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, student.getAccount());
            preparedStatement.setString(2, student.getLevel());
            preparedStatement.setString(3, student.getGender());
            preparedStatement.setString(4, student.getYear());
            preparedStatement.setInt(5, student.getStudent_id());
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

    public List<Mdl_student> getAllstudent() {
        connect_db();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Mdl_student> students = new ArrayList<Mdl_student>();
        try {
            Statement statement = connection.createStatement();
            rs = statement.executeQuery("select * from student limit 80 ");
            while (rs.next()) {
                Mdl_student student = new Mdl_student();
                student.setStudent_id(rs.getInt("chat_id"));
                student.setAccount(rs.getInt("account"));
                student.setLevel(rs.getString("level"));
                student.setGender(rs.getString("gender"));
                student.setYear(rs.getString("year"));
                students.add(student);
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
        return students;
    }

    public Mdl_student getStudentByid(int student_id) {
        connect_db();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Mdl_student student = new Mdl_student();
        try {
            preparedStatement = connection.prepareStatement("select * from student where student_id=?");
            preparedStatement.setInt(1, student_id);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                student.setStudent_id(rs.getInt("student_id"));
                student.setAccount(rs.getInt("account"));
                student.setLevel(rs.getString("level"));
                student.setGender(rs.getString("gender"));
                student.setYear(rs.getString("year"));
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
        return student;
    }
}
