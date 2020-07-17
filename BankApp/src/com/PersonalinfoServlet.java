package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import java.util.regex.*;

import vo.PersonalInfoBean;

@WebServlet("/pls")
public class PersonalinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Read Input
		PersonalInfoBean person = new PersonalInfoBean();
		String firstName = request.getParameter("fname");
		String middleName = request.getParameter("mname");
		String lastName = request.getParameter("lname");
		String gender = request.getParameter("gender");
		person.setFirstname(firstName);
		person.setLastname(lastName);
		person.setMiddlename(middleName);
		person.setGender(gender);

		// Validation
		String errorMsg = "";
		if (isFieldBlank(firstName)) {
			errorMsg += "First Name missing </br>";
		}
		if (isFieldBlank(lastName)) {
			errorMsg += "Last Name missing </br>";
		}
		if (isAlphaNumeric(middleName)) {
			errorMsg += "Middle Name can contain only letters, numbers. Please enter valid Middle Name  </br>";
		}

		// Response

		if (isFieldBlank(errorMsg)) {
			HttpSession ses = request.getSession();
			ses.setAttribute("pinfo", person);
			response.sendRedirect("html/contactinfo.html");

		} else {
			// error
			request.setAttribute("errors", errorMsg);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/personalinfo.jsp");
			rd.forward(request, response);
		}

	}

	private boolean isAlphaNumeric(String fieldValue) {
		return fieldValue.matches("[^a-zA-Z0-9]+");

	}

	private boolean isFieldBlank(String fieldValue) {
		return fieldValue == null || fieldValue.trim().length() == 0;

	}

}
