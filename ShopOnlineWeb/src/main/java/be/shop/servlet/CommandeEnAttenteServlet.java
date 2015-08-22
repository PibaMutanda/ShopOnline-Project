package be.shop.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.shop.entity.Commande;
import be.shop.repository.CommandeRepository;

/**
 * Servlet implementation class CommandeEnAttenteServlet
 */
public class CommandeEnAttenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private CommandeRepository commandeRepository;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommandeEnAttenteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Commande>commandes = commandeRepository.findAll();
		request.setAttribute("commandes", commandes);
		request.getRequestDispatcher("/WEB-INF/views/commandeEnAttente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
