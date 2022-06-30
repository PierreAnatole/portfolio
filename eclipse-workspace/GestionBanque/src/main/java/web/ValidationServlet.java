package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.ValidationForm;
import entities.User;

/**
 * Servlet implementation class ValidationServlet
 */
@WebServlet("/validation")
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setUsername(login);
		user.setPassword(password);
		
		ValidationForm validationForm = new ValidationForm();
		if (validationForm.isValid(login, password)) {
			request.setAttribute("login", login);
			request.setAttribute("password", password);
			request.setAttribute("user", user);
			getServletContext().getRequestDispatcher("/validation.jsp").forward(request,response);
		}
		else {
			getServletContext().getRequestDispatcher("/fail.jsp").forward(request,response);
		}
	}

}
