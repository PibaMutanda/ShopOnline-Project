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
 * Servlet implementation class DeleteServletArticle
 */
public class DeleteServletArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ArticleRepository articleRepository;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServletArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idstr = request.getParameter("id");
		Article article = articleRepository.findById(Long.parseLong(idstr));
		articleRepository.delete(article);
		response.sendRedirect(request.getContextPath()+"/displayListCateg.do");
	//	request.getRequestDispatcher("/WEB-INF/views/displayListArticles.jsp").forward(request, response);
	}

	
}
