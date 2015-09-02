package be.shop.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.shop.entity.Achat;
import be.shop.entity.Commande;
import be.shop.repository.AchatRepository;
import be.shop.service.CommandeServices;

/**
 * Servlet implementation class DetailCommandeClientServlet
 */
public class DetailCommandeClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CommandeServices commandeServices;

	@EJB
	private AchatRepository achatRepository;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailCommandeClientServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		Achat achat = achatRepository.findById(Long.parseLong(idStr));
		List<Commande> commandesClient = commandeServices.findByAchat(achat);
		request.setAttribute("commandes", commandesClient);
		request.getRequestDispatcher("/WEB-INF/views/detailCommandeClient.jsp")
				.forward(request, response);
	}

}
