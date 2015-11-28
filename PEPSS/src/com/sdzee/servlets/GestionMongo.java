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
        /* Initialisation de l'objet Java et r�cup�ration des messages */
        TestMongo test = new TestMongo();
        List<String> messages = test.executerTests( request );

        /* Enregistrement de la liste des messages dans l'objet requ�te */
        request.setAttribute( ATT_MESSAGES, messages );

        /* Transmission vers la page en charge de l'affichage des r�sultats */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}