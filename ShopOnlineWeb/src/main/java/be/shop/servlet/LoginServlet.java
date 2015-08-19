package be.shop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.shop.entity.Client;
import be.shop.service.ClientServices;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ClientServices clientServices;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     List<String> messageErrors = new ArrayList<String>();
			String password = request.getParameter("password");
			String email= request.getParameter("email");
			String admin = request.getParameter("admin");
			if(password == null || password.equals(""))
				messageErrors.add("Saisir le mot de passe");
			if(email==null || email.equals(""))
				messageErrors.add("Saisir l'adresse é-mail");
			if(admin==null || admin.equals("")){
				Client client = clientServices.loginClient(email, password);
				if(client == null)
					messageErrors.add("L'adresse é-mail ou le mot de passe incorrect");
				if(messageErrors.size()>0){
					request.setAttribute("messageErrors", messageErrors);
					request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
				}
				else
				{
					HttpSession session = request.getSession();
					String identity = client.getPrenom()+"  "+client.getNom();
					session.setAttribute("sessionIdClient", client.getId());
					session.setAttribute("identity", identity);
				    request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
				}
			}
	}

}
