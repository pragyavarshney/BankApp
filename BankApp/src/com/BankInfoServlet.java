package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.BankInfoBean;

@WebServlet("/bif")
public class BankInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Read Input
		BankInfoBean bankinfo = new BankInfoBean();
		String bankname = request.getParameter("bname");
		String acc = request.getParameter("account");
		String ssn = request.getParameter("ssn");
		bankinfo.setAccount(acc);
		bankinfo.setBankName(bankname);
		bankinfo.setSsn(ssn);

		// Response
		HttpSession ses = request.getSession();
		ses.setAttribute("binfo", bankinfo);
		
		response.sendRedirect("jsp/success.jsp");
	}

}
