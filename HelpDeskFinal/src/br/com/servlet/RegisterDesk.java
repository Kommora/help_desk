package br.com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.control.ControllerDAOUser;
import br.com.object.User;
/**
 * Servlet implementation class RegisterDesk
 */
@SuppressWarnings("all")
@WebServlet("/RegisterDesk")
public class RegisterDesk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterDesk() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tipo= request.getParameter("selectUser");
		String nome= request.getParameter("nome");
		String email= request.getParameter("email");
		String senha= request.getParameter("senha");
		String cpf= request.getParameter("cpf");
		String telefone= request.getParameter("telefone");
		switch (tipo) {
		case "1":
			tipo="User";
			break;
		case "2":
			tipo="Expert";
			break;
		default:
			tipo="Admin";
			break;
		}
		User user = new User(nome, cpf, email, senha, tipo, telefone);
		ControllerDAOUser dao = new ControllerDAOUser();
		if(dao.insertDAO(user)!=null){
			HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("clienteIndex.jsp");
		}else{
			response.sendRedirect("pages/register.jsp");
		}
				
	}

}
