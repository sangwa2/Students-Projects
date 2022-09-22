/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skill_share.dao;

import com.skill_share.Util.Util;
import com.skill_share.model.Mdl_chat;
import com.skill_share.model.Mdl_headmaster;
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
public class Dao_headmaster {
     private Connection connection;

    public Dao_headmaster() {
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
  
 
    public void add_headmaster(Mdl_headmaster headmaster) {
        connect_db();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into headmaster (name,surname,school) values (?,?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, headmaster.getName());
            preparedStatement.setString(2, headmaster.getSurname());
            preparedStatement.setString(3, headmaster.getSchool());
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

    public void delete_headmaster(int headmaster_id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from headmaster where headmaster_id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, headmaster_id);
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

    public void update_headmaster(Mdl_headmaster headmaster) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update headmaster set name=?,surname=?,school=? "
                    + "where headmaster_id=?");
            // Parameters start with 1
            preparedStatement.setString(1, headmaster.getName());
            preparedStatement.setString(2, headmaster.getSurname());
            preparedStatement.setString(3, headmaster.getSchool());
            preparedStatement.setInt(4, headmaster.getHeadmaster_id());
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

    public List<Mdl_headmaster> getAllheadmaster() {
        connect_db();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Mdl_headmaster> headmasters = new ArrayList<Mdl_headmaster>();
        try {
            Statement statement = connection.createStatement();
            rs = statement.executeQuery("select * from headmaster limit 80 ");
            while (rs.next()) {
                Mdl_headmaster headmaster = new Mdl_headmaster();
                headmaster.setHeadmaster_id(rs.getInt("headmaster_id"));
                headmaster.setName(rs.getString("name"));
                headmaster.setSurname(rs.getString("surname"));
                headmaster.setSchool(rs.getString("school"));
                headmasters.add(headmaster);
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
        return headmasters;
    }

    public Mdl_headmaster getHeadmaterByid(int headmaster_id) {
        connect_db();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Mdl_headmaster headmaster = new Mdl_headmaster();
        try {
            preparedStatement = connection.prepareStatement("select * from headmaster where headmaster_id=?");
            preparedStatement.setInt(1, headmaster_id);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                headmaster.setHeadmaster_id(rs.getInt("headmaster_id"));
                headmaster.setName(rs.getString("name"));
                headmaster.setSurname(rs.getString("surname"));
                headmaster.setSchool(rs.getString("school"));
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
        return headmaster;
    }
}
