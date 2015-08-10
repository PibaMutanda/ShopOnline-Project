package be.shop.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.shop.entity.Client;
import be.shop.repository.ClientRepository;

/**
 * Servlet implementation class UpdateClientServlet
 */
public class UpdateClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private ClientRepository clientRepository;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateClientServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Client client = clientRepository.findById(Long.parseLong(id));
		request.setAttribute("clientModif", client);
		request.getRequestDispatcher("/WEB-INF/views/displayClient.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");      String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");   String email = request.getParameter("email");
		String rue = request.getParameter("rue");    String cp = request.getParameter("cp");
		String localite = request.getParameter("localite"); String indesiderable = request.getParameter("indesiderable");
		Client client = clientRepository.findById(Long.parseLong(id));
		if(client!=null){
			client.setCp(cp);  client.setEmail(email);   client.setLocalite(localite);   client.setIndesirable(Boolean.parseBoolean(indesiderable));
			client.setPrenom(prenom);   client.setNom(nom);  client.setRue(rue);
			clientRepository.save(client);
			request.getRequestDispatcher("/WEB-INF/views/displayClient.jsp").forward(request, response);
			
		}
		else{
			request.setAttribute("message", "Problème survenu lors de la mise à jours");
			request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
		}
	}

}
