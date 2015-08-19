package be.shop.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.shop.entity.Article;
import be.shop.entity.Commande;
import be.shop.repository.CommandeRepository;
import be.shop.service.ArticleServices;

/**
 * Servlet implementation class DetailAchatsClientServlet
 */
public class DetailAchatsClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CommandeRepository commandeRepository;

	@EJB
	private ArticleServices articleServices;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailAchatsClientServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idStrCmd = request.getParameter("id");
		Commande commande = commandeRepository.findById(Long
				.parseLong(idStrCmd));
		List<Article> articles = articleServices.findByCommande(commande);
		request.setAttribute("articles", articles);
		request.getRequestDispatcher("/WEB-INF/views/achatsClient.jsp")
				.forward(request, response);
	}

}
