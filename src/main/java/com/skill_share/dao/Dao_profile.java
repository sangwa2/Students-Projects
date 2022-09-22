/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skill_share.dao;

import com.skill_share.Util.Util;
import com.skill_share.model.Mdl_profile;
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
public class Dao_profile {

    private Connection connection;

    public Dao_profile() {
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

    public void add_profile(Mdl_profile profile) {
        connect_db();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into profile(name,surname,date_birth,gender,tel,email,residence,image) values (?,?,?,?,?,?,?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, profile.getName());
            preparedStatement.setString(2, profile.getSurname());
            preparedStatement.setObject(3, profile.getDate_birth());
            preparedStatement.setString(4, profile.getGender());
            preparedStatement.setString(5, profile.getTel());
            preparedStatement.setString(6, profile.getEmail());
            preparedStatement.setString(7, profile.getResidence());
            preparedStatement.setInt(8, profile.getImage());
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

    public void delete_profile(int profile_id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from profile where profile_id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, profile_id);
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

    public void update_profile(Mdl_profile profile) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update profile set name=?,surname=?,date_birth=?,gender=?,tel=?,email=?,residence=?,image=? "
                    + "where profile_id=?");
            // Parameters start with 1
            preparedStatement.setString(1, profile.getName());
            preparedStatement.setString(2, profile.getSurname());
            preparedStatement.setObject(3, profile.getDate_birth());
            preparedStatement.setString(4, profile.getGender());
            preparedStatement.setString(5, profile.getTel());
            preparedStatement.setString(6, profile.getEmail());
            preparedStatement.setString(7, profile.getResidence());
            preparedStatement.setInt(8, profile.getImage());
            preparedStatement.setInt(9, profile.getProfile_id());
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

//    public List<Mdl_profile> getAllprofile() {
//        connect_db();
//        PreparedStatement preparedStatement = null;
//        ResultSet rs = null;
//        List<Mdl_profile> profiles = new ArrayList<>();
//        try {
//            Statement statement = connection.createStatement();
//            rs = statement.executeQuery("select   * from profile limit 80 ");
//
//            while (rs.next()) {
//                Mdl_profile profile = new Mdl_profile();
//                profile.setProfile_id(rs.getInt("profile_id"));
//                profile.setName(rs.getString("name"));
//                profile.setSurname(rs.getString("surname"));
//                profile.setDate_birth(String.valueOf(rs.getDate("date_birth")));
//                profile.setGender(rs.getString("gender"));
//                profile.setTel(rs.getString("tel"));
//                profile.setEmail(rs.getString("email"));
//                profile.setResidence(rs.getString("residence"));
//                profile.setImage(rs.getInt("image"));
//                //account
//                profile.setUsername(rs.getString("surname"));
//                profiles.add(profile);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("There is not data or what?" + e.toString());
//        } finally {
//            try {
//                if (connection != null) {
//                    preparedStatement.close();
//                    rs.close();
//                    connection.close();
//                }
//            } catch (Exception e) {
//            }
//        }
//        return profiles;
//    }

    public Mdl_profile getProfileByid(int profile_id) {
        connect_db();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Mdl_profile profile = new Mdl_profile();
        try {
            preparedStatement = connection.prepareStatement("select * from profile where profile_id=?");
            preparedStatement.setInt(1, profile_id);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                profile.setProfile_id(rs.getInt("profile_id"));
                profile.setName(rs.getString("name"));
                profile.setSurname(rs.getString("surname"));
                profile.setDate_birth(String.valueOf(rs.getDate("date_birth")));
                profile.setGender(rs.getString("gender"));
                profile.setTel(rs.getString("tel"));
                profile.setEmail(rs.getString("email"));
                profile.setResidence(rs.getString("residence"));
                profile.setImage(rs.getInt("image"));
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

        return profile;
    }

//    public Mdl_account get_user_by_username_password(String username, String password) {
//
//        PreparedStatement preparedStatement = null;
//        ResultSet rs = null;
//        Mdl_account account = new Mdl_account();
//        try {
//            preparedStatement = connection.prepareStatement("select * from account where username=? and password=?");
//            preparedStatement.setString(1, username);
//            preparedStatement.setString(2, password);
//            rs = preparedStatement.executeQuery();
//            if (rs.next()) {
//                account.setAccount_id(rs.getInt("account_id"));
//                account.setUsername(rs.getString("username"));
//                account.setPassword(rs.getString("password"));
//                account.setAccount_category(rs.getInt("account_category"));
//                account.setProfile(rs.getInt("profile"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (connection != null) {
//                    preparedStatement.close();
//                    connection.close();
//                }
//            } catch (Exception e) {
//            }
//        }
//
//        return account;
//    } //--true --profile --

    public Mdl_profile get_last_profile() {

        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Mdl_profile profile = new Mdl_profile();
        try {
            preparedStatement = connection.prepareStatement("select * from profile order by profile.profile_id desc limit 1");
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                profile.setProfile_id(rs.getInt("profile_id"));
                profile.setName(rs.getString("name"));
                profile.setSurname(rs.getString("surname"));
                profile.setDate_birth(String.valueOf(rs.getDate("date_birth")));
                profile.setGender(rs.getString("gender"));
                profile.setTel(rs.getString("tel"));
                profile.setEmail(rs.getString("email"));
                profile.setResidence(rs.getString("residence"));
                profile.setImage(rs.getInt("image"));
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

        return profile;
    }

//    public List<Mdl_profile> getAllprofile_by_category(String name) {
//        connect_db();
//        PreparedStatement preparedStatement = null;
//        ResultSet rs = null;
//        List<Mdl_profile> profiles = new ArrayList<>();
//        try {
//            String sql = "select  account_category.name as account_name,profile.profile_id,profile.name,profile.surname,profile.gender,profile.tel from profile  "
//                    + " join account on account.profile=profile.profile_id "
//                    + " join account_category on account.account_category = account_category_id"
//                    + " where account_category.name=? ";
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, name);
//            rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                Mdl_profile profile = new Mdl_profile();
//                profile.setProfile_id(rs.getInt("profile_id"));
//                profile.setName(rs.getString("name"));
//                profile.setSurname(rs.getString("surname"));
////                profile.setAccount_category(rs.getInt("account_category"));
//                profile.setGender(rs.getString("gender"));
//                profile.setTel(rs.getString("account_name"));
//
//                profile.setAccount_name(rs.getString("tel"));
//                profiles.add(profile);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("There is not data or what?" + e.toString());
//        } finally {
//            try {
//                if (connection != null) {
//                    preparedStatement.close();
//                    rs.close();
//                    connection.close();
//                }
//            } catch (Exception e) {
//            }
//        }
//        return profiles;
//    }

//    public List<Mdl_profile> get_per_cat_acc() {
//        connect_db();
//        PreparedStatement preparedStatement = null;
//        ResultSet rs = null;
//        List<Mdl_profile> profiles = new ArrayList<>();
//
//        try {
//            preparedStatement = connection.prepareStatement("select profile.profile_id,profile.name,profile.surname,profile.gender,profile.tel,profile.residence,profile.image,"
//                    + " account_category.name as acc_name,"
//                    + "                     account.username,account.password,account.account_category as a_category,account.profile,account.search_card "
//                    + "                     from profile"
//                    + "                     join account on account.profile = profile.profile_id"
//                    + "                     join account_category on account_category.account_category_id =account.account_category");
//
//            rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                Mdl_profile profile = new Mdl_profile();
//                profile.setProfile_id(rs.getInt("profile_id"));
//                profile.setName(rs.getString("name"));
//                profile.setSurname(rs.getString("surname"));
//                profile.setGender(rs.getString("gender"));
//                profile.setTel(rs.getString("tel"));
//                // account
//                profile.setUsername(rs.getString("username"));
//                profile.setPassword(rs.getString("password"));
//                profile.setAccount_category(rs.getInt("a_category"));
//                profile.setSearch_card(rs.getString("search_card"));
//
//                profiles.add(profile);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (connection != null) {
//                    preparedStatement.close();
//                    connection.close();
//                }
//            } catch (Exception e) {
//            }
//        }
//
//        return profiles;
//    }

//    public List<Mdl_profile> get_search(int account_id) {
//        connect_db();
//        PreparedStatement preparedStatement = null;
//        ResultSet rs = null;
//        List<Mdl_profile> profiles = new ArrayList<>();
//
//        try {
//            preparedStatement = connection.prepareStatement("select profile.profile_id,profile.name,profile.surname,profile.gender,profile.tel,profile.residence,profile.image,account_category.name as acc_name,"
//                    + "                     account.username,account.password,account.account_category ,account.profile,account.search_card,bank.last_transaction_date,bank.balance,bank.account,"
//                    + "                     health.last_check_date,health.hospital_name,health.issue,health.health_acc,"
//                    + "                     education.last_level,education.school_name,education.field,education.edu_acc"
//                    + "                     from profile\n"
//                    + "                     join account on account.profile = profile.profile_id\n"
//                    + "                     join account_category on account_category.account_category_id =account.account_category"
//                    + "                     left join bank on account.account_id = bank.account "
//                    + "                     left join health on account.account_id=health.health_acc"
//                    + "                     left join education on account.account_id=education.edu_acc where account.search_card=?");
//
//            preparedStatement.setInt(1, account_id);
//            rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                Mdl_profile profile = new Mdl_profile();
//                profile.setProfile_id(rs.getInt("profile_id"));
//                profile.setName(rs.getString("name"));
//                profile.setSurname(rs.getString("surname"));
//                profile.setGender(rs.getString("gender"));
//                profile.setTel(rs.getString("tel"));
//                // account
//                profile.setUsername(rs.getString("username"));
//                profile.setPassword(rs.getString("password"));
//                profile.setAcount_category(rs.getInt("account_category"));
//                profile.setSearch_card(rs.getString("search_card"));
//                //bank
//                profile.setLast_transaction_date(rs.getString("last_transaction_date"));
//                profile.setBalance(rs.getInt("balance"));
//                profile.setAccount(rs.getInt("account"));
//                // health
//                profile.setLast_check_date(rs.getString("last_check_date"));
//                profile.setHospital_name(rs.getString("hospital_name"));
//                profile.setHealth_acc(rs.getInt("health_acc"));
//                // education
//                profile.setLast_level(rs.getString("last_level"));
//                profile.setSchool_name(rs.getString("school_name"));
//                profile.setField(rs.getString("field"));
//                profile.setIssue(rs.getString("issue"));
//                profile.setEdu_acc(rs.getInt("edu_acc"));
//
//                profiles.add(profile);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (connection != null) {
//                    preparedStatement.close();
//                    connection.close();
//                }
//            } catch (Exception e) {
//            }
//        }
//
//        return profiles;
//    }

}
