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
import be.shop.entity.Article;
import be.shop.entity.Client;
import be.shop.entity.Commande;
import be.shop.repository.ArticleRepository;
import be.shop.repository.ClientRepository;
import be.shop.repository.CommandeRepository;

/**
 * Servlet implementation class CommandeServlet
 */
public class CommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CommandeRepository commandeRepository;

	@EJB
	private ArticleRepository articleRepository;

	@EJB
	private ClientRepository clientRepository;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommandeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<String> messageErrors = new ArrayList<String>();
		List<Article> articles = new ArrayList<Article>();
		Long sessionIdClient = null;
		Client client = null;
		int cpt = 0;
		String quantiteStrTab[] = request.getParameterValues("quantite");
		String idTab[] = request.getParameterValues("id");
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
		if (idTab == null || quantiteStrTab == null)
			messageErrors.add("Votre shop est en r&eacute;approvisionnement");
		else {
			for (String idStr : idTab) {
				Article article = articleRepository.findById(Long
						.parseLong(idStr));
				int quantite = Integer.parseInt(quantiteStrTab[cpt]);

				/*
				 * Vérification si la quantité d'achat est disposible
				 */
				if (quantite > article.getQteTotale())
					messageErrors
							.add("La quantit&eacute; en stock est insuffisant pour "
									+ article.getDenomination());
				// on actualise la quantité restante en stock dans le magasin
				else {
					Commande commande = new Commande();
					article.setQteTotale(article.getQteTotale() - quantite);
					Double totalArticle = quantite * article.getPrix();
					commande.addArticle(article);
					commande.setQuantite(quantite);
					commande.setTotalCommande(totalArticle);
					commande.setClient(client);
					commande.setDateCommande(new Date());
					if (quantite > 0) {
						articleRepository.save(article);
						commandeRepository.save(commande);
						articles.add(article);
					}
					cpt++;
				}
			}
		}

		if (messageErrors.size() > 0) {
			request.setAttribute("messageErrors", messageErrors);
			request.getRequestDispatcher("/WEB-INF/views/displayShop.jsp")
					.forward(request, response);
		} else {
			request.setAttribute("articles", articles);
			request.setAttribute("commandes",
					commandeRepository.findByClientAndDate(client, new Date()));
			request.getRequestDispatcher("/WEB-INF/views/confirmAchat.jsp")
					.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
