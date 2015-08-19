package be.shop.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.shop.entity.Achat;
import be.shop.entity.Client;
import be.shop.repository.AchatRepository;
import be.shop.repository.ClientRepository;

/**
 * Servlet implementation class DisplayAchatClientServlet
 */
public class DisplayAchatClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ClientRepository clientRepository;
	
	@EJB
	private AchatRepository achatRepository;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAchatClientServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		Client client = clientRepository.findById(Long.parseLong(idStr));
		List<Achat> achats = achatRepository.findByClient(client);
		request.setAttribute("achats", achats);
		
		request.getRequestDispatcher("/WEB-INF/views/achatsClient.jsp").forward(request, response);
	}

	
}
