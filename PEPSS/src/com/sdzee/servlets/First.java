package com.sdzee.servlets;

import java.io.IOException;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class First extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException{
		String message ="PEPS";
		request.setAttribute("test", message);
		this.getServletContext().getRequestDispatcher( "/WEB-INF/NewFile.jsp" ).forward( request, response );
	}
}
