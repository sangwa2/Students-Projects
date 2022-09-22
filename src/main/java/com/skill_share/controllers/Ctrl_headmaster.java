
package com.skill_share.controllers;

import com.skill_share.dao.Dao_headmaster;
import com.skill_share.model.Mdl_headmaster;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SANGWA
 */
@WebServlet(name = "Ctrl_headmaster", urlPatterns = {"/headmaster"})
public class Ctrl_headmaster extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Mdl_headmaster.jsp";
    private static String LIST_HEADMASTER = "forms/frm_headmaster.jsp";
 private Dao_headmaster dao_headmaster;
 public Ctrl_headmaster() {
        super();
 	dao_headmaster = new Dao_headmaster();
 }
     @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int headmaster_id = Integer.parseInt(request.getParameter("headmaster_id"));
            dao_headmaster.delete_headmaster(headmaster_id);
            forward = LIST_HEADMASTER;
            request.setAttribute("headmasters", dao_headmaster.getAllheadmaster());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = LIST_HEADMASTER;
            int headmaster_id = Integer.parseInt(request.getParameter("headmaster_id"));
            Mdl_headmaster mdl_headmaster  = dao_headmaster.getHeadmaterByid(headmaster_id);
            request.setAttribute("headmaster", mdl_headmaster);
            request.setAttribute("headmasters", dao_headmaster.getAllheadmaster());
        } else if (action.equalsIgnoreCase("Frm_headmaster")) {
            forward = LIST_HEADMASTER;
            request.setAttribute("headmasters", dao_headmaster.getAllheadmaster());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Mdl_headmaster mdl_headmaster = new Mdl_headmaster();

		 //-- Headmaster
        	try{
            	mdl_headmaster.setHeadmaster_id(Integer.parseInt(request.getParameter("txt_headmaster_id")));
        	}catch(NumberFormatException ne){}
		 mdl_headmaster.setName(request.getParameter("txt_name"));
		 mdl_headmaster.setSurname(request.getParameter("txt_surname"));
		 mdl_headmaster.setSchool((request.getParameter("txt_school")));
        	 String headmaster =request.getParameter("txt_headmaster_id");
	if (headmaster == null ||  headmaster.isEmpty()) {
            	dao_headmaster.add_headmaster(mdl_headmaster);
        	} else {
            	dao_headmaster.update_headmaster(mdl_headmaster);
        	}

}
}
