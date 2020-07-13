

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/bif")
public class BankInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Read Input
				String bankname = request.getParameter("bname");
		    	String acc = request.getParameter("account");
		    	String ssn = request.getParameter("ssn");
		    	
		    	
		    	//Response 
		    	HttpSession ses = request.getSession();
		    	ses.setAttribute("bn", bankname);
		    	ses.setAttribute("acc", acc);
		    	ses.setAttribute("ssn", ssn);
		    	
		    	response.sendRedirect("jsp/success.jsp");
	}

}
