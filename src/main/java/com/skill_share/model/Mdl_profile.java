package com.skill_share.model;
import java.util.Date;

 public class  Mdl_profile {
private int profile_id ;
private int name ;
private String surname ;
private String date_birth ;
private String gender ;
private String tel ;
private String email ;
private String residence ;
private int image ;
 
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



}

