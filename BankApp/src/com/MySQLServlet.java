package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.BankInfoBean;
import vo.ContactInfoBean;
import vo.PersonalInfoBean;

@WebServlet("/mss")
public class MySQLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MySQLServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession ses = request.getSession();
		PersonalInfoBean person = (PersonalInfoBean) ses.getAttribute("pinfo");
		String firstName = person.getFirstname();
		String middleName = person.getMiddlename();
		String lastName = person.getLastname();
		String gender = person.getGender();
		try {
			addPersons(firstName, middleName, lastName, gender);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ContactInfoBean contact = (ContactInfoBean) ses.getAttribute("cinfo");
		String address = contact.getAddress();
		String city = contact.getCity();
		String country = contact.getCountry();
		String email = contact.getEmail();
		String phone = contact.getPhone();
		String state = contact.getState();
		try {
			addContact(address, city, country, email, phone, state);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BankInfoBean bank = (BankInfoBean) ses.getAttribute("binfo");
		String bankname = bank.getBankName();
		String acc = bank.getAccount();
		String ssn = bank.getSsn();

		try {
			addBank(bankname, acc, ssn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Getting Connection

	public static Connection getConnection() throws Exception {
		Connection dbConn = null;
		try {
			// step1:
//		    Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			// step2
			String url = "jdbc:mysql://localhost:3306/test";
			// step3
			dbConn = DriverManager.getConnection(url, "root", "");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return dbConn;
	}

	public static void addPersons(String firstName, String middleName, String lastName, String gender)
			throws Exception {
		Connection dbConn = null;
		PreparedStatement pStmt = null;
		int rowsInserted = 0;

		try {
			dbConn = getConnection();
			pStmt = dbConn.prepareStatement("INSERT INTO test.person VALUES (?, ?, ?, ?, ?)");
			pStmt.setString(1, null);
			pStmt.setString(2, firstName);
			pStmt.setString(3, middleName);
			pStmt.setString(4, lastName);
			pStmt.setString(5, gender);

			rowsInserted = pStmt.executeUpdate();

			if (rowsInserted != 1) {
				throw new Exception("Error in inserting the row");

			}
		} catch (SQLException sqle) {
			System.out.println(sqle.getErrorCode());
			System.out.println(sqle.getMessage());
			sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			pStmt.close();
			dbConn.close();
		}
		return;
	}

	private  static void addBank(String bankname, String acc, String ssn) throws Exception {
		Connection dbConn = null;
		PreparedStatement pStmt = null;
		int rowsInserted = 0;

		try {
			dbConn = getConnection();
			pStmt = dbConn.prepareStatement("INSERT INTO test.bankinfo  VALUES (?, ?, ?, ?)");
			pStmt.setString(1, null);
			pStmt.setString(2, bankname);
			pStmt.setString(3, acc);
			pStmt.setString(4, ssn);

			rowsInserted = pStmt.executeUpdate();

			if (rowsInserted != 1) {
				throw new Exception("Error in inserting the row");

			}
		} catch (SQLException sqle1) {
			System.out.println(sqle1.getErrorCode());
			System.out.println(sqle1.getMessage());
			sqle1.printStackTrace();
			throw sqle1;
		} catch (Exception e1) {
			e1.printStackTrace();
			throw e1;
		} finally {
			pStmt.close();
			dbConn.close();
		}
		return;

	}

	private void addContact(String address, String city, String country, String email, String phone, String state)
	    throws Exception {
		Connection dbConn = null;
		PreparedStatement pStmt = null;
		int rowsInserted = 0;

		try {
			dbConn = getConnection();
			pStmt = dbConn.prepareStatement("INSERT INTO test.contact VALUES (?, ?, ?, ?, ?, ?, ?)");
			pStmt.setString(1, null);
			pStmt.setString(2, address);
			pStmt.setString(3, city);
			pStmt.setString(4, state);
			pStmt.setString(5, country);
			pStmt.setString(6, phone);
			pStmt.setNString(7, email);

			rowsInserted = pStmt.executeUpdate();

			if (rowsInserted != 1) {
				throw new Exception("Error in inserting the row");

			}
		} catch (SQLException sqle) {
			System.out.println(sqle.getErrorCode());
			System.out.println(sqle.getMessage());
			sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			pStmt.close();
			dbConn.close();
		}
		return;

	}

}
