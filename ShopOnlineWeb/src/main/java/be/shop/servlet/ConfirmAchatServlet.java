package be.shop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.shop.entity.Achat;
import be.shop.entity.Client;
import be.shop.entity.Commande;
import be.shop.repository.AchatRepository;
import be.shop.repository.ClientRepository;
import be.shop.repository.CommandeRepository;

/**
 * Servlet implementation class ConfirmAchatServlet
 */
public class ConfirmAchatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CommandeRepository commandeRepository;

	@EJB
	private ClientRepository clientRepository;

	@EJB
	private AchatRepository achatRepository;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfirmAchatServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<String> messageErrors = new ArrayList<String>();
		String message = null;
		Long sessionIdClient = null;
		String idStrTab[] = request.getParameterValues("id");
		String prixTotalTab[] = request.getParameterValues("total");
		String qteAchatTab[] = request.getParameterValues("quantite");
		int totalQte = 0;
		double prixTotal = 0.0;
		Client client = null;
		// On recupère la session du client
		sessionIdClient = (Long) request.getSession().getAttribute(
				"sessionIdClient");
		if (sessionIdClient == null)
			messageErrors
					.add("Inscrivez-vous sur le site avant de pouvoir effectuer les achats");
		else
			client = clientRepository.findById(sessionIdClient);
		if (client == null)
			messageErrors
					.add("Achat non autorisé!! Veuillez contacter nos service");
		if (idStrTab == null || prixTotalTab == null || qteAchatTab == null) {
			messageErrors
					.add("Sorry ! vous ne pouvez pas effectu&eacute; ces achats, par contre nous conservons votre commande pendant deux jour <br> Veuillez contacter nos services");

		} else {
			 Achat achat = new Achat();
			message = "Votre commande est enregistr&eacute; avec succe&egrave;";
			request.setAttribute("message", message);
			for (String idStr : idStrTab) {
				Commande commande = commandeRepository.findById(Long
						.parseLong(idStr));
				achat.addCommande(commande);
			}
			for (String quantite : qteAchatTab) {
				totalQte += Integer.parseInt(quantite);
			}
			for (String prix : prixTotalTab) {
				prixTotal += Double.parseDouble(prix);
			}
			if (totalQte <= 0)
				messageErrors.add("Aucun achat r&eacute;alis&eacute;");
			if (messageErrors.size() > 0) {
				request.setAttribute("messageErrors", messageErrors);
				request.getRequestDispatcher("/WEB-INF/views/achatsClient.jsp")
						.forward(request, response);
			} else {
				achat.setClient(client);
				achat.setDateAchat(new Date());
				achat.setQuantiteAchat(totalQte);
				achat.setTotalAchat(prixTotal);
				achatRepository.save(achat);
				List<Commande> commandes = commandeRepository
						.findByAchat(achat);
				for (Commande commande : commandes) {
					commandeRepository.delete(commande);
				}
				request.setAttribute("message", message);
				request.getRequestDispatcher("/WEB-INF/views/displayShop.jsp")
						.forward(request, response);
			}
		}

	}

}
