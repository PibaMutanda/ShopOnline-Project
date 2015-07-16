package be.shop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.resteasy.util.GetRestful;

import be.shop.entity.Categorie;
import be.shop.repository.CategorieRepository;
import be.shop.service.CategorieServices;

/**
 * Servlet implementation class CategorieServlet
 */
public class CategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CategorieServices categorieServices;

	@EJB
	private CategorieRepository categorieRepository;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategorieServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<String> messageErrors = new ArrayList<String>();
		Categorie categorie = null;
		String categ = request.getParameter("categ");
		if (categ == null)
			messageErrors.add("Indiquez la catégorie");
		categorie = categorieServices.findByName(categ);
		if (categorie != null) {
			if (categ.equalsIgnoreCase(categorie.getNom()))
				messageErrors.add(categ + "  existe déjà!!");
		}
		if (messageErrors.size() > 0) {
			request.setAttribute("messageErrors", messageErrors);
			getServletContext().getRequestDispatcher("/categorieregister.jsp")
					.forward(request, response);
		} else {
			categorie = new Categorie();
			categorie.setNom(categ);
			categorieRepository.save(categorie);
			request.setAttribute("messageSuccess",
					"Catégorie enregistrée avec succès");
			getServletContext().getRequestDispatcher("/index.jsp").forward(
					request, response);
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
