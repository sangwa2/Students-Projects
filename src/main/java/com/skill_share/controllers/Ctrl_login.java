/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill_share.controllers;

import com.skill_share.dao.Dao_account;
import com.skill_share.model.Mdl_account;
import com.skill_share.model.Mdl_login;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author SANGWA
 */
@WebServlet(name = "/Ctrl_login", urlPatterns = {"/login"})
public class Ctrl_login extends HttpServlet {

   

    @Override
    public void init(ServletConfig config) throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("txt_username");
            String password = request.getParameter("txt_password");
        String direction = "";
//        System.out.println("username: "+ username);
//        System.out.println("password: "+ password);
        try {
            Dao_account dao_account = new Dao_account();
            Mdl_account mdl_account = new Mdl_account();
            Mdl_login mdl_login=new Mdl_login();
            mdl_login.setUsername(username);//take username
            mdl_login.setPassword(password);
            mdl_account = dao_account.get_login(mdl_login);

            if (mdl_account.getAccount_id() != 0) {
                System.out.println("Found acc_id: "+ mdl_account.getAccount_id());
                direction = "forms/admin_dashboard.jsp";
                session.setAttribute("userid", mdl_account.getAccount_id());
                session.setAttribute("user_details", mdl_account);
                session.setAttribute("cat", mdl_account.getAccount_category()); 
                PrintWriter data = response.getWriter();
                data.print("ok");
                request.setAttribute("user_login", mdl_account);
            } else {
                request.setAttribute("user_login", "Invalid username/Password");
                direction = "/forms/frm_login.jsp";
            }

        } catch (Exception ne) {
            
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ne.printStackTrace(pw);

            request.setAttribute("user_login", "failed");
            request.setAttribute("err", sw.toString());
            direction = "login.jsp";
        }

        RequestDispatcher view = request.getRequestDispatcher(direction);
        view.forward(request, response);

    }
}

