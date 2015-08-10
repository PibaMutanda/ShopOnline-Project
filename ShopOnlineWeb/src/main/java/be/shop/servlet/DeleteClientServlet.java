package be.shop.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.shop.entity.Client;
import be.shop.repository.ClientRepository;

/**
 * Servlet implementation class DeleteClientServlet
 */
public class DeleteClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ClientRepository clientRepository;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("id");
		Client client = clientRepository.findById(Long.parseLong(id));
		clientRepository.delete(client);
		request.setAttribute("message", "Suppression Réussi!!");
		request.getRequestDispatcher("/WEB-INF/views/displayClient.jsp").forward(request, response);
		
		
	}

	

}
