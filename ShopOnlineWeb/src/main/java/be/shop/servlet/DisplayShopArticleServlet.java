package be.shop.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.shop.entity.Article;
import be.shop.entity.Categorie;
import be.shop.repository.CategorieRepository;
import be.shop.service.ArticleServices;

/**
 * Servlet implementation class DisplayShopArticleServlet
 */
public class DisplayShopArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ArticleServices articleServices;
	
	@EJB
	private CategorieRepository categorieRepository;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayShopArticleServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		Categorie categ = categorieRepository.findById(Long.parseLong(idStr));
		List<Article> articles = articleServices.findByCateg(categ);
		request.setAttribute("articles", articles);
		request.getRequestDispatcher("/WEB-INF/views/displayShop.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
