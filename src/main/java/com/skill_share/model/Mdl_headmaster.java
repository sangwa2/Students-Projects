package com.skill_share.model;

import java.util.Date;

public class Mdl_headmaster {

    private int headmaster_id;
    private String name;
    private String surname;
    private String school;

    public void setHeadmaster_id(int headmaster_id) {
        this.headmaster_id = headmaster_id;
    }

    public int getHeadmaster_id() {
        return headmaster_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

}
