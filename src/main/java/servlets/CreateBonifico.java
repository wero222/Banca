package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.Banca;

/**
 * Servlet implementation class CreateBonifico
 */
@WebServlet("/create-bonifico")
public class CreateBonifico extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateBonifico() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String da = request.getParameter("da");
		String a = request.getParameter("a");
		String importo = request.getParameter("importo");
		
		Banca banca = new Banca();
		
		// verifico che i conti correnti esistono
		if(!banca.contoExists(da)) {
			response.sendRedirect(request.getContextPath() + "/nuovo-bonifico.jsp?errore=da");
			return;
		}
		if(!banca.contoExists(a)) {
			response.sendRedirect(request.getContextPath() + "/nuovo-bonifico.jsp?errore=a");
			return;
		}
		// i conti devono essere diversi
		float importoFloat;
		try {
			importoFloat = Float.parseFloat(request.getParameter("importo"));
		}
		catch(NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/nuovo-bonifico.jsp?errore=importo");
			return;
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
