package assign.samples;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class MySQLStoredProcedure {
	// Getting Connection

	public static Connection getConnection() throws Exception {
		Connection dbConn = null;
		try {
			// step1:
			Class.forName("com.mysql.jdbc.Driver");
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

	// Queries

	public static void callStroedProcedure() throws Exception {

		Connection dbConn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;

		try {

			dbConn = getConnection();
			String procedure = "{call simpleproc(?, ?)}";
			CallableStatement statement = dbConn.prepareCall(procedure);
			statement.registerOutParameter(1, Types.INTEGER);
			statement.registerOutParameter(2, Types.INTEGER);
			statement.execute();
			
			System.out.println(statement.getInt(1));
			System.out.println(statement.getInt(2));

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			// rs.close();
			// pStmt.close();
			// dbConn.close();
		}
		return;
	}

	public static void getGroup(String inGroupID) throws Exception {

		Connection dbConn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;

		try {
			dbConn = getConnection();

			pStmt = dbConn
					.prepareStatement("SELECT * FROM groups WHERE groupid = ?");
			pStmt.setString(1, inGroupID);
			rs = pStmt.executeQuery();

			if (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rs.close();
			pStmt.close();
			dbConn.close();
		}
		return;
	}
	
	public static void main(String[] args) throws Exception{
		MySQLStoredProcedure.callStroedProcedure();
	}
}
