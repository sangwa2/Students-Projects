package com.skill_share.model;
import java.util.Date;

 public class  Mdl_account {
private int account_id ;
 
 //------ Other fields
private int profile_id ;
private int name ;
private String surname ;
private String date_birth ;
private String gender ;
private String tel ;
private String email ;
private String residence ;
private int image ;
private int account_category_id ;
private String name ;
private String username ;
private String password ;
private int account_category ;
private int profile ;
 
 public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }
public int getAccount_id() {
        return account_id;
    }


//---Other fnx
  public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
    }
public int getProfile_id() {
        return profile_id;
    }

 public void setName(int name) {
        this.name = name;
    }
public int getName() {
        return name;
    }

 public void setSurname(String surname) {
        this.surname = surname;
    }
public String getSurname() {
        return surname;
    }

 public void setDate_birth(String date_birth) {
        this.date_birth = date_birth;
    }
public String getDate_birth() {
        return date_birth;
    }

 public void setGender(String gender) {
        this.gender = gender;
    }
public String getGender() {
        return gender;
    }

 public void setTel(String tel) {
        this.tel = tel;
    }
public String getTel() {
        return tel;
    }

 public void setEmail(String email) {
        this.email = email;
    }
public String getEmail() {
        return email;
    }

 public void setResidence(String residence) {
        this.residence = residence;
    }
public String getResidence() {
        return residence;
    }

 public void setImage(int image) {
        this.image = image;
    }
public int getImage() {
        return image;
    }

 public void setAccount_category_id(int account_category_id) {
        this.account_category_id = account_category_id;
    }
public int getAccount_category_id() {
        return account_category_id;
    }

 public void setName(String name) {
        this.name = name;
    }
public String getName() {
        return name;
    }

 public void setUsername(String username) {
        this.username = username;
    }
public String getUsername() {
        return username;
    }

 public void setPassword(String password) {
        this.password = password;
    }
public String getPassword() {
        return password;
    }

 public void setAccount_category(int account_category) {
        this.account_category = account_category;
    }
public int getAccount_category() {
        return account_category;
    }

 public void setProfile(int profile) {
        this.profile = profile;
    }
public int getProfile() {
        return profile;
    }



}

