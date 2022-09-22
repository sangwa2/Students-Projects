
package com.skill_share.controllers;

import com.skill_share.dao.Dao_course;
import com.skill_share.model.Mdl_course;
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
@WebServlet(name = "/course", urlPatterns = {"/course"})
public class Ctrl_course extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Mdl_course.jsp";
    private static String LIST_COURSE = "forms/frm_course.jsp";
    private Dao_course dao_course;

    public Ctrl_course() {
        super();
        dao_course = new Dao_course();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int course_id = Integer.parseInt(request.getParameter("course_id"));
            dao_course.delete_course(course_id);
            forward = LIST_COURSE;
            request.setAttribute("courses", dao_course.getAllcourse());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = LIST_COURSE;
            int course_id = Integer.parseInt(request.getParameter("course_id"));
            Mdl_course mdl_course = dao_course.getCourseByid(course_id);
            request.setAttribute("course", mdl_course);
            request.setAttribute("courses", dao_course.getAllcourse());
        } else if (action.equalsIgnoreCase("Frm_course")) {
            forward = LIST_COURSE;
            request.setAttribute("courses", dao_course.getAllcourse());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Mdl_course mdl_course = new Mdl_course();

        //-- Student
        
       
        try {
            mdl_course.setCourse_id(Integer.parseInt(request.getParameter("txt_course_id")));
        } catch (NumberFormatException ne) {
        }
        mdl_course.setCourse_title(request.getParameter("txt_level"));
       
        String course = request.getParameter("txt_course_id");
        if (course == null || course.isEmpty()) {
            dao_course.add_course(mdl_course);
        } else {
            dao_course.update_cource(mdl_course);
        }

    }
}