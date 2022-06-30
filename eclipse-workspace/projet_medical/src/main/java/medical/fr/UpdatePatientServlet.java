package medical.fr;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeletePatientServlet
 */
@WebServlet("/updatepatient")
public class UpdatePatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePatientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt( request.getParameter("id")); 
		PatientDAO pdao = new PatientDAO();

		Patient p = pdao.get(id); 
		
		request.setAttribute("p",p);
		
		getServletContext().getRequestDispatcher("/patientedit.jsp").forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt( request.getParameter("id")); 
		PatientDAO pdao = new PatientDAO();
		
		String email = request.getParameter("email"); 
		String telephone = request.getParameter("telephone"); 
		
		pdao.updatePatient(id, email , telephone );
		response.sendRedirect("listepatient"); 
	}
}
