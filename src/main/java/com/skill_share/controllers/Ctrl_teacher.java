package com.skill_share.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.skill_share.dao.Dao_teacher;
import com.skill_share.model.Mdl_teacher;

 @WebServlet(name="/teacher" , urlPatterns = {"/teacher"})
public class Ctrl_teacher extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Mdl_teacher.jsp";
    private static String LIST_TEACHER = "forms/frm_teacher.jsp";
 private Dao_teacher dao_teacher;
 public Ctrl_teacher() {
        super();
 	dao_teacher = new Dao_teacher();
 }
     @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int teacher_id = Integer.parseInt(request.getParameter("teacher_id"));
            dao_teacher.delete_teacher(teacher_id);
            forward = LIST_TEACHER;
            request.setAttribute("teachers", dao_teacher.getAllteacher());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = LIST_TEACHER;
            int teacher_id = Integer.parseInt(request.getParameter("teacher_id"));
            Mdl_teacher mdl_teacher  = dao_teacher.getTeacherByid(teacher_id);
            request.setAttribute("teacher", mdl_teacher);
            request.setAttribute("teachers", dao_teacher.getAllteacher());
        } else if (action.equalsIgnoreCase("Frm_teacher")) {
            forward = LIST_TEACHER;
            request.setAttribute("teachers", dao_teacher.getAllteacher());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Mdl_teacher mdl_teacher = new Mdl_teacher();

		 //-- Teacher
        	try{
            	mdl_teacher.setTeacher_id( Integer.parseInt(request.getParameter("txt_teacher_id")));
        	}catch(NumberFormatException ne){}
		 mdl_teacher.setEdu_level(request.getParameter("txt_edu_level"));
		 mdl_teacher.setSpecification(request.getParameter("txt_specification"));
		 mdl_teacher.setAccount(Integer.parseInt(request.getParameter("txt_account")));
        	 String teacher =request.getParameter("txt_teacher_id");
	if (teacher == null ||  teacher.isEmpty()) {
            	dao_teacher.add_teacher(mdl_teacher);
        	} else {
            	dao_teacher.update_teacher(mdl_teacher);
        	}

}
}
