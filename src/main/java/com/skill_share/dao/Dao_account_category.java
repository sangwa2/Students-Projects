/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skill_share.dao;

import com.skill_share.Util.Util;
import com.skill_share.model.Mdl_account_category;
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
public class Dao_account_category {
   

     private Connection connection;

    public Dao_account_category() {
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

    public void add_account_category(Mdl_account_category account_category) {
        connect_db();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into account_category(name)values(?)");
            // Parameters start with 1
            preparedStatement.setString(1, account_category.getName());
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

    public void delete_account_category(int account_category_id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from account_category where account_category_id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, account_category_id);
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

    public void update_account_category(Mdl_account_category account_category) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update account_category set name=? "
                    + "where account_category_id=?");
            // Parameters start with 1
            preparedStatement.setString(1, account_category.getName());
            preparedStatement.setInt(2, account_category.getAccount_category_id());
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

    public List<Mdl_account_category> getAllaccount_category() {
        connect_db();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Mdl_account_category> account_categorys = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            rs = statement.executeQuery("select * from account_category limit 80 ");
            while (rs.next()) {
                Mdl_account_category account_category = new Mdl_account_category();
                account_category.setAccount_category_id(rs.getInt("account_category_id"));
                account_category.setName(rs.getString("name"));
                account_categorys.add(account_category);
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
        return account_categorys;
    }

    public Mdl_account_category getAccount_categoryByid(int account_category_id) {
        connect_db();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Mdl_account_category account_category = new Mdl_account_category();
        try {
            preparedStatement = connection.prepareStatement("select * from account_category where account_category_id=?");
            preparedStatement.setInt(1, account_category_id);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                account_category.setAccount_category_id(rs.getInt("account_category_id"));
                account_category.setName(rs.getString("name"));
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

        return account_category;
    }

    public Mdl_account_category get_last_category() {
        connect_db();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Mdl_account_category category = new Mdl_account_category();
        try {
            preparedStatement = connection.prepareStatement("select * from account_category order by account_category.account_category_id desc limit 1");
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                category.setAccount_category_id(rs.getInt("account_category_id"));
                category.setName(rs.getString("name"));

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

        return category;
    }
}
