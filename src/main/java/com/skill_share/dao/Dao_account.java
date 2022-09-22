package com.skill_share.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.skill_share.Util.Util;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.skill_share.model.Mdl_account;
import com.skill_share.model.Mdl_login;
public class Dao_account {

    private Connection connection;

    public Dao_account() {
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
    public void add_account(Mdl_account account) {
        connect_db();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into account (username,password,account_catategory,profile,search_card) values (?,?,?,?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setInt(3, account.getAccount_category());
            preparedStatement.setInt(4, account.getProfile());
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

    public void delete_account(int account_id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from account where account_id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, account_id);
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

    public void update_account(Mdl_account account) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update account set username=?,password=?,account_category=?,profile=? "
                    + "where account_id=?");
            // Parameters start with 1
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setInt(3, account.getAccount_category());
            preparedStatement.setInt(4, account.getProfile());
            preparedStatement.setInt(5, account.getAccount_id());
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

    public List<Mdl_account> getAllaccount() {
        connect_db();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Mdl_account> accounts = new ArrayList<Mdl_account>();
        try {
            Statement statement = connection.createStatement();
            rs = statement.executeQuery("select * from account limit 80 ");
            while (rs.next()) {
                Mdl_account account = new Mdl_account();
                account.setAccount_id(rs.getInt("account_id"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setAccount_category(rs.getInt("account_category"));
                account.setProfile(rs.getInt("profile"));
                accounts.add(account);
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
        return accounts;
    }

    public Mdl_account getAccountByid(int account_id) {
        connect_db();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Mdl_account account = new Mdl_account();
        try {
            preparedStatement = connection.prepareStatement("select * from account where account_id=?");
            preparedStatement.setInt(1, account_id);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                account.setAccount_id(rs.getInt("account_id"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setAccount_category(rs.getInt("account_category"));
                account.setProfile(rs.getInt("profile"));
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
        return account;
    }

    public Mdl_account getAccountByprofile_id(int profile_id) {
//        System.out.println(Dao_profile.class.getName() + "personid:  " + profile_id);
        connect_db();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Mdl_account account = new Mdl_account();
        try {
            preparedStatement = connection.prepareStatement("select account.account_id, account.username,account.password"
                    + "    from profile"
                    + "    join account on account.profile = profile.profile_id"
                    + "    where profile.profile_id=?");
            preparedStatement.setInt(1, profile_id);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                account.setAccount_id(rs.getInt("account_id"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
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

        return account;
    }

    public Mdl_account get_login(Mdl_login mdl_login) {
        Mdl_account mdl_account = new Mdl_account();
        connect_db();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement("select account.account_id,account.username,account.password, account_category.name"
                    + "  from account "
                    + " join account_category on account_category.account_category_id=account.account_category"
                    + " where account.username=? and account.password=?");
            preparedStatement.setString(1, mdl_login.getUsername());
            preparedStatement.setString(2, mdl_login.getPassword());
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                mdl_account.setAccount_id(rs.getInt(1));
                mdl_account.setUsername(rs.getString(2));
                mdl_account.setPassword(rs.getString(3));
                mdl_account.setName(rs.getString(4));
            }
        } catch (SQLException e) {
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
        return mdl_account;
    }
    
     public List<Mdl_account> get_pr_acc() {
        connect_db();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Mdl_account> accounts= new ArrayList<>();
        try {
            String sql = "select   account.account_id, profile.name,profile.surname from profile  "
                    + " join account on account.profile=profile.profile_id ";

            preparedStatement = connection.prepareStatement(sql);
            
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Mdl_account account= new Mdl_account();
                account.setAccount_id(rs.getInt("account_id"));
                account.setName(rs.getString("name"));
                account.setSurname(rs.getString("surname"));
                accounts.add(account);
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
        return accounts;
    }

 //--false -- --


}

