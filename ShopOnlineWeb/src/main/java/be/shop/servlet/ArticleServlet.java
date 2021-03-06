package be.shop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.shop.entity.Article;
import be.shop.entity.Categorie;
import be.shop.repository.ArticleRepository;
import be.shop.repository.CategorieRepository;

/**
 * Servlet implementation class ArticleServlet
 */
public class ArticleServlet extends HttpServlet {
	
	@EJB
	private CategorieRepository categorieRepository;
	
	@EJB
	private ArticleRepository articleRepository;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categorie> categories = categorieRepository.findAll();
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/WEB-INF/views/articleregister.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> messageErros=new ArrayList<String>();
		String categ = request.getParameter("categ");
		String article = request.getParameter("article");
		String prixStr = request.getParameter("prix");
		String enVente = request.getParameter("enVente");
		String qteTotale = request.getParameter("qteTotale");
		if(categ==null || categ.equals(""))
			messageErros.add("Indiquez une catégorie");
		if(article == null || article.equals(""))
			messageErros.add("Indiquez le nom de l'article");
		if(prixStr == null || prixStr.equals(""))
			messageErros.add("Indiquez le prix de l'article");
		if(qteTotale==null || qteTotale.equals(""))
			messageErros.add("Indiquez la quantité totale disponible de l'article");
	   if(messageErros.size()>0){
		   request.setAttribute("messageErrors", messageErros);
		   request.getRequestDispatcher("/WEB-INF/views/articleregister.jsp").forward(request, response);
	   }
	   else{
		   Article article2 = new Article();
		   Categorie categorie = categorieRepository.findById(Long.parseLong(categ));
		   article2.setCateg(categorie);
		   article2.setDenomination(article);
		   article2.setPrix(Double.parseDouble(prixStr));
		   article2.setEnVente(enVente.charAt(0));
		   article2.setQteTotale(Integer.parseInt(qteTotale));
		   articleRepository.save(article2);
		   request.setAttribute("messageSuccess", "ArticleRepositoryTest enregistré avec succèss");
		   request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
	   }
	}

}
