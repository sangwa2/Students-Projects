
package com.skill_share.dao;

import com.skill_share.Util.Util;
import com.skill_share.model.Mdl_account;
import com.skill_share.model.Mdl_chat;
import com.skill_share.model.Mdl_login;
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
public class Dao_chat {

    private Connection connection;

    public Dao_chat() {
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
  
    public void add_chat(Mdl_chat chat) {
        connect_db();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into chat (subject,message,account,account_fro) values (?,?,?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, chat.getSubject());
            preparedStatement.setString(2, chat.getMessage());
            preparedStatement.setInt(3, chat.getAccount());
            preparedStatement.setInt(4, chat.getAccount_fro());
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

    public void delete_chat(int chat_id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from chat where chat_id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, chat_id);
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

    public void update_chat(Mdl_chat chat) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update chat set subject=?,message=?,account=?,account_fro=? "
                    + "where chat_id=?");
            // Parameters start with 1
            preparedStatement.setString(1, chat.getSubject());
            preparedStatement.setString(2, chat.getMessage());
            preparedStatement.setInt(3, chat.getAccount());
            preparedStatement.setInt(4, chat.getAccount_fro());
            preparedStatement.setInt(5, chat.getChat_id());
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

    public List<Mdl_chat> getAllchat() {
        connect_db();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Mdl_chat> chats = new ArrayList<Mdl_chat>();
        try {
            Statement statement = connection.createStatement();
            rs = statement.executeQuery("select * from chat limit 80 ");
            while (rs.next()) {
                Mdl_chat chat = new Mdl_chat();
                chat.setChat_id(rs.getInt("chat_id"));
                chat.setSubject(rs.getString("subject"));
                chat.setMessage(rs.getString("message"));
                chat.setAccount(rs.getInt("account"));
                chat.setAccount_fro(rs.getInt("account_fro"));
                chats.add(chat);
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
        return chats;
    }

    public Mdl_chat getChatByid(int chat_id) {
        connect_db();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Mdl_chat chat = new Mdl_chat();
        try {
            preparedStatement = connection.prepareStatement("select * from chat where chat_id=?");
            preparedStatement.setInt(1, chat_id);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                chat.setChat_id(rs.getInt("chat_id"));
                chat.setSubject(rs.getString("subject"));
                chat.setMessage(rs.getString("message"));
                chat.setAccount(rs.getInt("account"));
                chat.setAccount_fro(rs.getInt("account_fro"));
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
        return chat;
    }

}
