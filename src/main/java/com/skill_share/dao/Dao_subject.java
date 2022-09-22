/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skill_share.dao;

import com.skill_share.Util.Util;
import com.skill_share.model.Mdl_chat;
import com.skill_share.model.Mdl_subject;
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
public class Dao_subject {
     private Connection connection;

    public Dao_subject() {
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
  private String description ;
private int course ;
  
    public void add_subject(Mdl_subject subject) {
        connect_db();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into subject (description,course) values (?,?)");
            // Parameters start with 1
            preparedStatement.setString(1,subject.getDescription());
            preparedStatement.setInt(2, subject.getCourse());
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

    public void delete_subject(int subject_id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from subject where subject_id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, subject_id);
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

    public void update_subject(Mdl_subject subject) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update subject set description=?,course=? "
                    + "where subject_id=?");
            // Parameters start with 1
            preparedStatement.setString(1, subject.getDescription());
            preparedStatement.setInt(2, subject.getCourse());
            preparedStatement.setInt(3, subject.getSubject_id());
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

    public List<Mdl_subject> getAllsubject() {
        connect_db();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Mdl_subject> subjects = new ArrayList<Mdl_subject>();
        try {
            Statement statement = connection.createStatement();
            rs = statement.executeQuery("select * from subject limit 80 ");
            while (rs.next()) {
                Mdl_subject subject = new Mdl_subject();
                subject.setSubject_id(rs.getInt("subject_id"));
                subject.setDescription(rs.getString("decription"));
                subject.setCourse(rs.getInt("course"));
                subjects.add(subject);
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
        return subjects;
    }

    public Mdl_subject getChatByid(int subject_id) {
        connect_db();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Mdl_subject subject = new Mdl_subject();
        try {
            preparedStatement = connection.prepareStatement("select * from subject where subject_id=?");
            preparedStatement.setInt(1, subject_id);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                subject.setSubject_id(rs.getInt("subject_id"));
                subject.setDescription(rs.getString("description"));
                subject.setCourse(rs.getInt("course"));
               
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
        return subject;
    }
}
