package be.shop.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.shop.entity.Categorie;
import be.shop.repository.CategorieRepository;

/**
 * Servlet implementation class ListCategServlet
 */
public class ListCategServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CategorieRepository categorieRepository;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categorie> listCateg = categorieRepository.findAll();
		request.setAttribute("listCateg", listCateg);
		request.getRequestDispatcher("/WEB-INF/views/displayListCategs.jsp").forward(request, response);
	}


}
