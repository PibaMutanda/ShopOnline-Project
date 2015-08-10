package be.shop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.shop.entity.Client;
import be.shop.repository.ClientRepository;

/**
 * Servlet implementation class SearchClientServlet
 */
public class SearchClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ClientRepository clientRepository;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> messageErros= new ArrayList<String>();
		String email= request.getParameter("email");
		if(email==null)
			messageErros.add("Saisir l'adresse email");
		Client client = clientRepository.findByEmail(email);
		if(client==null)
			messageErros.add("client non repertorié dans notre système");
		if(messageErros.size()>0){
			request.setAttribute("messageErrors", messageErros);
			request.getRequestDispatcher("/WEB-INF/vues/displayClient.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("client", client);
			request.getRequestDispatcher("/WEB-INF/vues/displayClient.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
