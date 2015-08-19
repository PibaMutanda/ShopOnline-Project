package be.shop.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.shop.entity.Categorie;
import be.shop.service.CategorieServices;

/**
 * Servlet implementation class DisplayCategoriesServlet
 */
public class DisplayCategoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private CategorieServices categorieServices;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayCategoriesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categorie> categories = categorieServices.findAll();
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/WEB-INF/views/displayShop.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
