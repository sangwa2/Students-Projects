package com.skill_share.model;
import java.util.Date;

 public class  Mdl_chat {
private int chat_id ;
private int subject ;
private String message ;
private int account ;
private int account_fro ;
 
 public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
    }
public int getChat_id() {
        return chat_id;
    }

 public void setSubject(int subject) {
        this.subject = subject;
    }
public int getSubject() {
        return subject;
    }

 public void setMessage(String message) {
        this.message = message;
    }
public String getMessage() {
        return message;
    }

 public void setAccount(int account) {
        this.account = account;
    }
public int getAccount() {
        return account;
    }

 public void setAccount_fro(int account_fro) {
        this.account_fro = account_fro;
    }
public int getAccount_fro() {
        return account_fro;
    }



}

