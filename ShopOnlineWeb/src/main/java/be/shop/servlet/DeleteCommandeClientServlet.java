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
import be.shop.repository.ArticleRepository;
import be.shop.repository.CommandeRepository;

/**
 * Servlet implementation class DeleteCommandeClientServlet
 */
public class DeleteCommandeClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	CommandeRepository commandeRepository;
	
	@EJB
	ArticleRepository articleRepository;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCommandeClientServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /*
     * Quand une commande est annulée on remet le(s) article(s) commandé(s) en ventes*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		Commande commande = commandeRepository.findById(Long.parseLong(idStr));
		List<Article> articles = articleRepository.findByCommande(commande);
		for (Article article : articles) {
			if(commande.getId() == article.getCommande().getId()){
				article.setQteTotale(article.getQteTotale() + commande.getQuantite());
			    articleRepository.save(article);
			}
		}
		commandeRepository.delete(commande);
		request.setAttribute("commandes", commandeRepository.findAllWithoutPurchase());
		request.getRequestDispatcher("/WEB-INF/views/commandeEnAttente.jsp").forward(request, response);
	}
}
