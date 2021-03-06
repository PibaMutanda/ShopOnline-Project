package be.shop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.shop.entity.Client;
import be.shop.service.ClientServices;

/**
 * Servlet implementation class ClientServlet
 */

public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(name="clientServices")
    private ClientServices clientServices;
       
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
	          request.getRequestDispatcher("/WEB-INF/views/clientregister.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ArrayList<String> messageErrors = new ArrayList<String>();
         String nom = request.getParameter("nom").trim();
         String prenom = request.getParameter("prenom").trim();
         String rue = request.getParameter("rue").trim();
         String localite=request.getParameter("localite");
         String cp=request.getParameter("cp").trim();
         String email=request.getParameter("email").trim();
         String password=request.getParameter("password").trim();
         String passwordConf = request.getParameter("passwordConf").trim();
         if(nom==null||nom.equals(""))
      	   messageErrors.add("Renseignez le nom");
         if(prenom==null||prenom.equals(""))
        	 messageErrors.add("Saisir le prénom");
         if(rue==null || rue.equals(""))
      	   messageErrors.add("Indiquez la rue");
         if(cp==null || cp.equals(""))
      	   messageErrors.add("Indiquez le code postal");
         if(!cp.matches("^[0-9]{4}$"))
      	   messageErrors.add("Code Postal non valide");
         if(localite==null || localite.equals(""))
      	   messageErrors.add("Indiquez la localité");
         if(email==null || email.equals(""))
      	   messageErrors.add("Indiquez l'adresse mail");
         if(!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"))
      		   messageErrors.add("Votre adresse mail n'est pas correcte");
         if(password==null || password.equals(""))
      	   messageErrors.add("Indiquez votre mot de passe");
         if(!password.equals(passwordConf))
      	   messageErrors.add("Indiquez le même mot de passe");
         if(messageErrors.size()>0){
      	   request.setAttribute("messageErrors", messageErrors);
      	   getServletContext().getRequestDispatcher("/WEB-INF/views/clientregister.jsp").forward(request, response);
         }
         else{
      	    Client client = new Client();
      	    client.setNom(nom);   client.setPrenom(prenom);   client.setCp(cp);   client.setEmail(email);
      	    client.setDateInscription(new Date());  client.setLocalite(localite);  client.setRue(rue);
      	    client.setPassword(password);   client.setPasswordConf(passwordConf);
      	    clientServices.registerClient(client);
      	    getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
         }
	}

}
