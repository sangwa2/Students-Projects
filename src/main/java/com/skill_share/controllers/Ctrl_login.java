/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skill_share.controllers;

import com.skill_share.dao.Dao_account;
import com.skill_share.model.Mdl_account;
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
import org.apache.log4j.Logger;

/**
 *
 * @author SANGWA
 */
@WebServlet(name = "/Ctrl_login", urlPatterns = {"/get_login"})
public class Ctrl_login extends HttpServlet {

    private Logger logger = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        logger = Logger.getRootLogger();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String direction = "";
        try {

            Dao_account dao_account = new Dao_account();
            Mdl_account mdl_account = new Mdl_account();
            mdl_account = dao_account.get_user_by_username_password(username, password);

            if (mdl_account.getAccount_id() != 0) {
                direction = "forms/admin_dashboard.jsp";
                session.setAttribute("userid", mdl_account.getAccount_id());
                session.setAttribute("user_details", mdl_account);
                session.setAttribute("cat", mdl_account.getAccount_category()); 
                
//                
//
//                response.addCookie(cUserName);
//                response.addCookie(cPassword);
//                response.addCookie(id);

                PrintWriter data = response.getWriter();
                data.print("ok");
                request.setAttribute("user_login", mdl_account);
            } else {
                request.setAttribute("user_login", "Invalid username/Password");
                direction = "login.jsp";
            }

//            logger.debug("Logging - debug: ");
//            logger.info(" Logging - info: ");
//            logger.warn(" Logging - warn: ");
//            logger.error("Logging - error: ");
//            logger.fatal("Logging - fatal: ");
        } catch (Exception ne) {
           

            logger.debug("Logging - debug: " + ne);
            logger.info(" Logging - info: " + ne);
            logger.warn(" Logging - warn: " + ne);
            logger.error("Logging - error: " + ne);
            logger.fatal("Logging - fatal: " + ne);

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

