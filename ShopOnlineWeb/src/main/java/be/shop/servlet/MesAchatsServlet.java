package be.shop.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.shop.entity.Client;
import be.shop.entity.Commande;
import be.shop.repository.AchatRepository;
import be.shop.repository.ClientRepository;
import be.shop.repository.CommandeRepository;

/**
 * Servlet implementation class MesAchatsServlet
 */
public class MesAchatsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ClientRepository clientRepository;
	
	@EJB
	private AchatRepository achatRepository;
	
	@EJB
	private CommandeRepository commandeRepository;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MesAchatsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String idStr = request.getParameter("id");
	      Client client = clientRepository.findById(Long.parseLong(idStr));
	      List<Commande> mesAchats = commandeRepository.findTenPurchaseOfClient(client);
	      request.setAttribute("mesCommandes", mesAchats);
	      request.getRequestDispatcher("/WEB-INF/views/mesAchats.jsp").forward(request, response);
	}

	
}
