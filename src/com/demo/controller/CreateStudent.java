package com.demo.controller;

import com.demo.entity.Student;
import com.googlecode.objectify.ObjectifyService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class CreateStudent extends HttpServlet{
    static {
        ObjectifyService.register(Student.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long Id = System.currentTimeMillis();
        String Rollnumber = req.getParameter("rollNumber");
        String Name = req.getParameter("name");
        String Email = req.getParameter("email");
        int Status = Integer.parseInt(req.getParameter("status"));

        Student obj = new Student();

        obj.setId(Id);
        obj.setRollNumber(Rollnumber);
        obj.setName(Name);
        obj.setEmail(Email);
        obj.setStatus(Status);
        ofy().save().entity(obj).now();
        resp.sendRedirect("/_ah/admin");
    }
}
