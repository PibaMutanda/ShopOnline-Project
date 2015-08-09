package be.shop.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.shop.entity.Article;
import be.shop.repository.ArticleRepository;

/**
 * Servlet implementation class UpdateServletArticle
 */
public class UpdateServletArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ArticleRepository articleRepository;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServletArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idArticle = request.getParameter("id");
	    Article article = articleRepository.findById(Long.parseLong(idArticle));
	    request.setAttribute("article", article);
	    request.getRequestDispatcher("/WEB-INF/views/updateArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		String denomination = request.getParameter("denomination");
		String prix = request.getParameter("prix");
		String enVente = request.getParameter("enVente");
		Article article = articleRepository.findById(Long.parseLong(idStr));
		article.setDenomination(denomination); 
		article.setPrix(Double.parseDouble(prix));
		article.setEnVente(enVente.charAt(0));
		articleRepository.save(article);
		response.sendRedirect(request.getContextPath()+"/displayListCateg.do");
	}

}
