package com.sdzee.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.bdd.TestMongo;

public class GestionMongo extends HttpServlet {
    public static final String ATT_MESSAGES = "messages";
    public static final String VUE          = "/WEB-INF/test_mongo.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

		String message ="PEPS";
		request.setAttribute("test", message);
		this.getServletContext().getRequestDispatcher(VUE ).forward( request, response );
    }
}