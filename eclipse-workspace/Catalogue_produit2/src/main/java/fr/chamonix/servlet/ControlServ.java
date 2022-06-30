package fr.chamonix.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.chamonix.dao.ProduitDaoImp;
import fr.chamonix.dao.ProduitDaoable;
import fr.chamonix.entities.ProduitsStockageModel;

/**
 * Servlet implementation class ControlServ
 */
@WebServlet(name = "ControlServ", urlPatterns = {"/ControlServ", "*.cs"})
public class ControlServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private ProduitDaoable ProduitMetier;
     
     
     @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	ProduitMetier = new ProduitDaoImp();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println(path);
		if (path.equals("/ControlServ")) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
        else if (path.equals("/ControlServ/AddProduit")) {
        	request.getRequestDispatcher("saisieProduit.jsp").forward(request, response);
        }
			
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
