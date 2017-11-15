package com.demo.controller;

import com.demo.entity.Student;
import com.googlecode.objectify.ObjectifyService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


import static com.googlecode.objectify.ObjectifyService.ofy;

public class Home extends HttpServlet {

    static {
        ObjectifyService.register(Student.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student obj = new Student();
        long id = Long.parseLong(req.getParameter("id")) ;
        ofy().load().entity(obj).now();
        resp.sendRedirect("/editStudent");

    }
}
