

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medical.fr.PatientDAO;

/**
 * Servlet implementation class AddPatientServlet
 */
@WebServlet("/addpatient")
public class AddPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPatientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		
		PrintWriter pr = response.getWriter(); 
		pr.println("<html>"
				+ "<head><title>Ajouter un patient</title>"
				+ "<!-- CSS only -->\r\n"
				+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor\" crossorigin=\"anonymous\">"
				+ "</head>"
				+ "<body>"
				+ "<h1 class='text-center'>Ajouter un patient</h1>"
				+ "<form name='addpatient' method='post' action='' class='w-50 mx-auto d-block'>"
				+ "<input class=\"form-control mb-3\" type='text' name='prenom' placeholder='Prénom du patient'>"
				+ "<input class=\"form-control mb-3\" type='text' name='nom' placeholder='Nom du patient'>"
				+ "<input class=\"form-control mb-3\" type='text' name='telephone' placeholder='Téléphone'>"
				+ "<input class=\"form-control mb-3\" type='text' name='email' placeholder='Email'>"
				+ "<button class='btn btn-primary' type='submit'>Envoyer</button"
				+ "</form>"
				+ "</body>"
				+ "</html>"); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html"); 
		
		String prenom = request.getParameter("prenom"); 
		String nom = request.getParameter("nom"); 
		String telephone = request.getParameter("telephone"); 
		String email = request.getParameter("email"); 
		
		PatientDAO pdao = new PatientDAO();
		pdao.createPatient(prenom, nom, email, telephone); 
		
		PrintWriter pr = response.getWriter(); 
		pr.println("Patient ajouté avec succès <br> <a href='listepatient'>Retour</a>");
	}

}
