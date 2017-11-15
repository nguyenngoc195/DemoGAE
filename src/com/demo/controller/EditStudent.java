package com.demo.controller;

import com.demo.entity.Student;
import com.googlecode.objectify.ObjectifyService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.googlecode.objectify.ObjectifyService.factory;
import static com.googlecode.objectify.ObjectifyService.ofy;
public class EditStudent extends HttpServlet {

    static {
        ObjectifyService.register(Student.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student editSt = new Student();



        long Id = Long.parseLong(req.getParameter("id"));
        String rollNumber = req.getParameter("rollNumber");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        int Status = Integer.parseInt(req.getParameter("status"));

        editSt.setId(Id);
        editSt.setRollNumber(rollNumber);
        editSt.setEmail(email);
        editSt.setStatus(Status);
        editSt.setName(req.getParameter("name"));

        ofy().save().entity(editSt).now();
        resp.sendRedirect("/_ah/admin");
    }
}
