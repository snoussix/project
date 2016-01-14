package com.sdzee.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.bdd.TestMongo;

/**
 * Servlet implementation class action
 */
@WebServlet("/action")
public class action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	    public static final String ATT_MESSAGES = "messages";
	    public static final String VUE          = "/WEB-INF/actionb.jsp";

	    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	        /* Initialisation de l'objet Java et récupération des messages */
	        TestMongo test = new TestMongo();
	        List<String> messages = new ArrayList<>();//test.executerTests( request, "DHR" );
	        messages.add("reda");
	        /* Enregistrement de la liste des messages dans l'objet requête */
	        request.setAttribute( ATT_MESSAGES, messages );

	        /* Transmission vers la page en charge de l'affichage des résultats */
	        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TestMongo test = new TestMongo();
        List<String> messages = test.executerTests( request, request.getParameter("q") );
        String mess=null;
		Iterator<String> messIterator = messages.iterator();
		while (messIterator.hasNext()) {
			mess+=messIterator.next();
		}     
		//request.setAttribute( ATT_MESSAGES, messages );
        response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        response.getWriter().write(mess);
        //this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

}
