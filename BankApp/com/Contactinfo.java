

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/cinfo")
public class Contactinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Read Input
				String address = request.getParameter("address");
		    	String city = request.getParameter("city");
		    	String state = request.getParameter("state");
		    	String country = request.getParameter("country");
		    	String phone = request.getParameter("phone");
		    	
		    	//Response to welcome2output.jsp
		    	HttpSession ses = request.getSession();
		    	ses.setAttribute("fn", address);
		    	ses.setAttribute("mn", city);
		    	ses.setAttribute("ln", state);
		    	ses.setAttribute("ln", country);
		    	ses.setAttribute("ln", phone);
		    	
		    
		    	
		    	response.sendRedirect("html/bankinfo.html");
	}

}
