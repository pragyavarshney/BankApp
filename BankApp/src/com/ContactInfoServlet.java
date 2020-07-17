package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.regex.*;

import vo.ContactInfoBean;

@WebServlet("/cinfo")
public class ContactInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Read Input
		ContactInfoBean contact = new ContactInfoBean();
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		contact.setAddress(address);
		contact.setCity(city);
		contact.setCountry(country);
		contact.setEmail(email);
		contact.setPhone(phone);
		contact.setState(state);

//		Validations
		String errorMsg = "";

		if (isFieldBlank(address)) {
			errorMsg += "Address is  missing </br>";
		}

		if (isFieldBlank(city)) {
			errorMsg += "City is missing </br>";
		}
		if (isFieldBlank(state)) {
			errorMsg += "State is missing </br>";
		}
		if (isFieldBlank(country)) {
			errorMsg += "Country is missing </br>";
		}

		if (isFieldBlank(email)) {
			errorMsg += "Email ID missing </br>";
		}
		if (isEmailCheck(email)) {
			errorMsg += "Invalid Address. for eg:a@b.com  </br>";
		}
		if (isNumberCheck(phone)) {
			errorMsg += "Phone Number contains 10 digits. Please enter valid Phone Number </br>";
		}

		// Response to welcome2output.jsp
		if (isFieldBlank(errorMsg)) {
			HttpSession ses = request.getSession();
			ses.setAttribute("cinfo", contact);
			response.sendRedirect("html/bankinfo.html");

		} else {
			// error
			request.setAttribute("errors", errorMsg);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/contactinfo.jsp");
			rd.forward(request, response);
		}

	}

	private boolean isNumberCheck(String fieldValue) {
		Pattern p = Pattern.compile("((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");
		Matcher m = p.matcher(fieldValue);
		return !(m.find() && m.group().contentEquals(fieldValue));

	}

	private boolean isEmailCheck(String fieldValue) {
//		 regular expression provided in OWASP Validation Regex repository.
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (fieldValue == null)
			return true;
		return !(pat.matcher(fieldValue).matches());
	}

	private boolean isFieldBlank(String fieldValue) {
		return fieldValue == null || fieldValue.trim().length() == 0;

	}

}
