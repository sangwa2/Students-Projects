package com.skill_share.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.skill_share.Util.Util;
import com.skill_share.model.Mdl_account;
import java.util.Date;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.skill_share.model.Mdl_;
import com.skill_share.model.Mdl_;
public class Dao_ {

    private Connection connection;

    public Dao_() {
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
    public void add_(Mdl_ ) {
        connect_db();
        PreparedStatement preparedStatement=null;
         try {
            preparedStatement = connection.prepareStatement("insert into     ()     values ()");
            // Parameters start with 1
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (connection != null) {
                    preparedStatement.close();
                    connection.close();
                }
            } catch (Exception e) {
            }
            
        }
    }

    public void delete_(int _id) {
        PreparedStatement preparedStatement=null;
         try {
            preparedStatement = connection.prepareStatement("delete from  where _id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, _id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if (connection != null) {
                    preparedStatement.close();
                    connection.close();
                }
            } catch (Exception e) {
            }
            
        }
    }

    public void update_(Mdl_ ) {
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement = connection.prepareStatement("update  set  "
                    + "where _id=?");
            // Parameters start with 1
                              preparedStatement.setInt(1, .get_id());      preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if (connection != null) {
                    preparedStatement.close();
                    connection.close();
                }
            } catch (Exception e) {
            }
            
        }
    }

    public List<Mdl_> getAll() {
        connect_db();
        PreparedStatement preparedStatement = null;
        ResultSet rs=null;        List<Mdl_> s = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            rs = statement.executeQuery("select   * from  limit 80 ");
          
  	 while (rs.next()) {
                Mdl_  = new Mdl_();
                .set(rs.getString(""));
                s.add();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("There is not data or what?" + e.toString());
        }finally {
            try {
                if (connection != null) {
                    preparedStatement.close();
                    rs.close();
                    connection.close();
                                    }
            } catch (Exception e) {
            }
        }
        return s;
    }

    public Mdl_ getByid(int _id) {
        connect_db();
        PreparedStatement preparedStatement = null;
        ResultSet rs=null;        Mdl_  = new Mdl_();
        try {
            preparedStatement = connection.prepareStatement("select * from  where _id=?");
            preparedStatement.setInt(1, _id);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                .set(rs.getString("")  );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (connection != null) {
                    preparedStatement.close();
                    connection.close();
                }
            } catch (Exception e) {
            }
        }

        return ;
    }

 //--false -- --


}

