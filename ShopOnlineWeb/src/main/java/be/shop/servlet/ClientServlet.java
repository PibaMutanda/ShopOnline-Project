package be.shop.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.shop.entity.Client;

/**
 * Servlet implementation class ClientServlet
 */

public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	           ArrayList<String> messageErrors = new ArrayList<String>();
	           Client client = new Client();
	           String nom = request.getParameter("nom");
	           String prenom = request.getParameter("prenom");
	           String rue = request.getParameter("rue");
	           String localite=request.getParameter("localite");
	           String cp=request.getParameter("cp");
	           String email=request.getParameter("email");
	           String password=request.getParameter("password");
	           String passwordConf = request.getParameter("passwordConf");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
