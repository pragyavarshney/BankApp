

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/pls")
public class PersonalinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Read Input
		String firstName = request.getParameter("fname");
    	String middleName = request.getParameter("mname");
    	String lastName = request.getParameter("lname");
    	String gender = request.getParameter("gender");
    	
    	//Response 
    	HttpSession ses = request.getSession();
    	ses.setAttribute("fn", firstName);
    	ses.setAttribute("mn", middleName);
    	ses.setAttribute("ln", lastName);
    	ses.setAttribute("gn", gender);
    	
    	response.sendRedirect("html/contactinfo.html");
    	
	}

}
