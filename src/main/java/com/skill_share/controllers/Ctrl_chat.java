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
 import com.skill_share.model.Mdl_chat;

import com.skill_share.dao.Dao_chat;
import com.skill_share.model.Mdl_chat;
import java.text.DateFormat;

 @WebServlet(name="/chat" , urlPatterns = {"/chat"})
public class Ctrl_chat extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Mdl_chat.jsp";
    private static String LIST_CHAT = "forms/frm_chat.jsp";
 private Dao_chat dao_chat;
 public Ctrl_chat() {
        super();
 	dao_chat = new Dao_chat();
 }
     @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int chat_id = Integer.parseInt(request.getParameter("chat_id"));
            dao_chat.delete_chat(chat_id);
            forward = LIST_CHAT;
            request.setAttribute("chats", dao_chat.getAllchat());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = LIST_CHAT;
            int chat_id = Integer.parseInt(request.getParameter("chat_id"));
            Mdl_chat mdl_chat  = dao_chat.getChatByid(chat_id);
            request.setAttribute("chat", mdl_chat);
            request.setAttribute("chats", dao_chat.getAllchat());
        } else if (action.equalsIgnoreCase("Frm_chat")) {
            forward = LIST_CHAT;
            request.setAttribute("chats", dao_chat.getAllchat());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Mdl_chat mdl_chat = new Mdl_chat();

		 //-- Chat
        	try{
            	mdl_chat.setChat_id( Integer.parseInt(request.getParameter("txt_chat_id")));
        	}catch(NumberFormatException ne){}
		 mdl_chat.setSubject(Integer.parseInt(request.getParameter("txt_subject")));
		 mdl_chat.setMessage(request.getParameter("txt_message"));
		 mdl_chat.setAccount(Integer.parseInt(request.getParameter("txt_account")));
		 mdl_chat.setAccount_fro(Integer.parseInt(request.getParameter("txt_account_fro")));
        	 String chat =request.getParameter("txt_chat_id");
	if (chat == null ||  chat.isEmpty()) {
            	dao_chat.add_chat(mdl_chat);
        	} else {
            	dao_chat.update_chat(mdl_chat);
        	}

}
}
