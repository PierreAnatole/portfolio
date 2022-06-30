package com.entreprise.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entreprise.metier.CapitalInvalideException;
import com.entreprise.metier.DureeInvalideException;
import com.entreprise.metier.EmpruntInvalideException;
import com.entreprise.metier.InfosEmpruntModel;

/**
 * Servlet implementation class EmpruntServlet
 */
@WebServlet("/formulaireEmprunt")
public class EmpruntServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpruntServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		getServletContext().getRequestDispatcher("/formulaire.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		

		// Verification capital
		String empruntStr = request.getParameter("emprunt");
		String empruntRegex="0*(([0-9])|([1-4][0-9])|50)"; // Chiffre entre 0 et 50 avec parfois des 0 derrière
		String empruntDecimalRegex = "(0*(([0-9])|([1-4][0-9])))\\.([0-9]{1,2})"; //// Chiffre entre 0 et 49.99 avec 1 ou deux chiffres après le point
		if (!(empruntStr.matches(empruntRegex) || empruntStr.matches(empruntDecimalRegex) )) {
			EmpruntInvalideException empruntInvalide = new EmpruntInvalideException();
			request.setAttribute( "empruntInvalide" , empruntInvalide );
		}
		double emprunt = Double.valueOf(empruntStr);

		// Verification capital
		String capitalStr = request.getParameter("capital");
		String capitalRegex="0*(([0-9])|([1-4][0-9])|50)"; // Chiffre entre 0 et 50 avec parfois des 0 derrière
		if (!(capitalStr.matches(capitalRegex))) {
			CapitalInvalideException capitalInvalide = new CapitalInvalideException();
			request.setAttribute( "capitalInvalide" , capitalInvalide );
		}
		int capital = Integer.valueOf(capitalStr);
				
		
		// Verification duree
		String dureeStr = request.getParameter("duree");
		String dureeRegex="0*(([0-9])|([1-4][0-9])|50)"; // Chiffre entre 0 et 50 avec parfois des 0 derrière
		if (!(dureeStr.matches(dureeRegex))) {
			DureeInvalideException dureeInvalide = new DureeInvalideException();
			request.setAttribute( "dureeInvalide" , dureeInvalide );
		}
		int duree = Integer.valueOf(dureeStr);
		
		// Calculs
		InfosEmpruntModel modelEmprunt = new InfosEmpruntModel(capital,emprunt,duree);
		double mensualite = modelEmprunt.CalculMensualite(capital, emprunt, duree);
		
		request.setAttribute( "mensualite" , mensualite );
		getServletContext().getRequestDispatcher("/formulaire.jsp").forward(request,response);
	}

}
