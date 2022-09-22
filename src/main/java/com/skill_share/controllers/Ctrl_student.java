
package com.skill_share.controllers;

import com.skill_share.dao.Dao_student;
import com.skill_share.model.Mdl_student;
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
@WebServlet(name = "/student", urlPatterns = {"/student"})
public class Ctrl_student extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Mdl_student.jsp";
    private static String LIST_STUDENT = "forms/frm_student.jsp";
    private Dao_student dao_student;

    public Ctrl_student() {
        super();
        dao_student = new Dao_student();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int student_id = Integer.parseInt(request.getParameter("student_id"));
            dao_student.delete_student(student_id);
            forward = LIST_STUDENT;
            request.setAttribute("teachers", dao_student.getAllstudent());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = LIST_STUDENT;
            int student_id = Integer.parseInt(request.getParameter("student_id"));
            Mdl_student mdl_student = dao_student.getStudentByid(student_id);
            request.setAttribute("student", mdl_student);
            request.setAttribute("students", dao_student.getAllstudent());
        } else if (action.equalsIgnoreCase("Frm_student")) {
            forward = LIST_STUDENT;
            request.setAttribute("students", dao_student.getAllstudent());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Mdl_student mdl_student = new Mdl_student();

        //-- Student
        
       
        try {
            mdl_student.setStudent_id(Integer.parseInt(request.getParameter("txt_student_id")));
        } catch (NumberFormatException ne) {
        }
        mdl_student.setAccount(Integer.parseInt(request.getParameter("txt_account")));
        mdl_student.setLevel(request.getParameter("txt_level"));
        mdl_student.setGender(request.getParameter("txt_gender"));
        mdl_student.setYear(request.getParameter("txt_gender"));
        String student = request.getParameter("txt_student_id");
        if (student == null || student.isEmpty()) {
            dao_student.add_student(mdl_student);
        } else {
            dao_student.update_student(mdl_student);
        }

    }
}
 