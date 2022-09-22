package com.skill_share.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
 import com.skill_share.model.Mdl_account;

import com.skill_share.dao.Dao_profile;
import com.skill_share.dao.Dao_account;
import com.skill_share.dao.Dao_account_category;
import com.skill_share.model.Mdl_profile;
import com.skill_share.model.Mdl_account;
import com.skill_share.model.Mdl_account_category;
import java.text.DateFormat;

 @WebServlet(name="/users" , urlPatterns = {"/users"})
public class Ctrl_users extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Mdl_users.jsp";
    private static String LIST_ACCOUNT = "forms/frm_users.jsp";
 private Dao_profile dao_profile;
 private Dao_account dao_account;
 private Dao_account_category dao_account_category;
 public Ctrl_users() {
        super();
 	dao_profile = new Dao_profile();
 	dao_account = new Dao_account();
 	dao_account_category = new Dao_account_category();
 }
     @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int account_id = Integer.parseInt(request.getParameter("account_id"));
            dao_account.delete_account(account_id);
            forward = LIST_ACCOUNT;
            request.setAttribute("accounts", dao_account.getAllaccount());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = LIST_ACCOUNT;
            int account_id = Integer.parseInt(request.getParameter("account_id"));
            Mdl_account mdl_account  = dao_account.getAccountByid(account_id);
            request.setAttribute("account", mdl_account);
            request.setAttribute("accounts", dao_account.getAllaccount());
        } else if (action.equalsIgnoreCase("Frm_account")) {
            forward = LIST_ACCOUNT;
            request.setAttribute("accounts", dao_account.getAllaccount());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Mdl_profile mdl_profile = new Mdl_profile();
		Mdl_account mdl_account = new Mdl_account();
		Mdl_account_category mdl_account_category = new Mdl_account_category();

		 //-- Profile
        	try{
            	mdl_profile.setProfile_id( Integer.parseInt(request.getParameter("txt_profile_id")));
        	}catch(NumberFormatException ne){}
		 mdl_profile.setName(Integer.parseInt(request.getParameter("txt_name")));
		 mdl_profile.setSurname(request.getParameter("txt_surname"));
	try {
            Date date_birth = new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("txt_date_birth"));
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            mdl_profile.setDate_birth(String.valueOf(date_birth));
        	} catch (ParseException e) {
            e.printStackTrace();
        	}
		 mdl_profile.setGender(request.getParameter("txt_gender"));
		 mdl_profile.setTel(request.getParameter("txt_tel"));
		 mdl_profile.setEmail(request.getParameter("txt_email"));
		 mdl_profile.setResidence(request.getParameter("txt_residence"));
		 mdl_profile.setImage(Integer.parseInt(request.getParameter("txt_image")));
        	 String profile =request.getParameter("txt_profile_id");
	if (profile == null ||  profile.isEmpty()) {
            	dao_profile.add_profile(mdl_profile);
        	} else {
            	dao_profile.update_profile(mdl_profile);
        	}
		
 int last_profile = new Dao_profile().get_last_profile().getProfile_id();

		 //-- Account
        	try{
            	mdl_account.setAccount_id( Integer.parseInt(request.getParameter("txt_account_id")));
        	}catch(NumberFormatException ne){}
		 mdl_account.setUsername(request.getParameter("txt_username"));
		 mdl_account.setPassword(request.getParameter("txt_password"));
		 mdl_account.setAccount_category(Integer.parseInt(request.getParameter("txt_account_category")));
		 mdl_account.setProfile(last_profile);
        	 String account =request.getParameter("txt_account_id");
	if (account == null ||  account.isEmpty()) {
            	dao_account.add_account(mdl_account);
        	} else {
            	dao_account.update_account(mdl_account);
        	}

		 //-- Account_category
        	try{
            	mdl_account_category.setAccount_category_id( Integer.parseInt(request.getParameter("txt_account_category_id")));
        	}catch(NumberFormatException ne){}
		 mdl_account_category.setName(request.getParameter("txt_name"));
        	 String account_category =request.getParameter("txt_account_category_id");
	if (account_category == null ||  account_category.isEmpty()) {
            	dao_account_category.add_account_category(mdl_account_category);
        	} else {
            	dao_account_category.update_account_category(mdl_account_category);
        	}

}
}
