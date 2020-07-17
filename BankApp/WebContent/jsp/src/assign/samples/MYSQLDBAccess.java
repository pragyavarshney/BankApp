package assign.samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * DBAccess
 *
 */

public class MYSQLDBAccess {
 
	/**
	 * No Argument Constructor
	 */
	public MYSQLDBAccess() {
		super();
	}

//Getting Connection

	public static Connection getConnection() throws Exception{
			Connection dbConn = null;
	    try{
	    //step1:
	    Class.forName("com.mysql.jdbc.Driver");
		//step2
	    String url = "jdbc:mysql://localhost:3306/test";
		//step3
		dbConn = DriverManager.getConnection(url, "root", "root");
		}
	     catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	return dbConn;
	}



// Queries

	public static void getAllGroups() throws Exception{

	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
            ResultSet rs = null;

	     try{

		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("SELECT * FROM groups");
		rs = pStmt.executeQuery();
		while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
   		}
	     }catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	     finally {
		rs.close();
		pStmt.close();
		dbConn.close();
	    }
		return;
	}

	
	public static void getGroup(String inGroupID) throws SQLException, Exception{

	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
            ResultSet rs = null;

       try{
		dbConn = getConnection();
		
		pStmt = dbConn.prepareStatement("SELECT * FROM groups WHERE groupid = ?");
		pStmt.setString(1, inGroupID);
   		rs = pStmt.executeQuery();
   		
   		
		if (rs.next()) {
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
   		}
       }catch(SQLException sqe){
    	   //log the error
    	   sqe.printStackTrace();
    	   //throw the exception
    	   throw sqe;
       } finally{
    	   rs.close();
    	   pStmt.close();
    	   dbConn.close();
       }

		return;
	}

	public static void addGroup(String groupid, String groupName)  throws Exception{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsInserted = 0;

	     try{
		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("INSERT INTO groups VALUES (?, ?)");
		pStmt.setString(1, groupid);
		pStmt.setString(2, groupName);
		
   		rowsInserted = pStmt.executeUpdate();

		if (rowsInserted != 1) {
			throw new Exception("Error in inserting the row");

   		}
	     }catch (SQLException sqle) {
		     System.out.println(sqle.getErrorCode());
		     System.out.println(sqle.getMessage());
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	     finally {
		pStmt.close();
		dbConn.close();
	     }
		return;
	}
 
	public static void updateGroup(String groupid, String groupName)  throws Exception{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsUpdated = 0;

	     try{
		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("UPDATE groups SET groupname=? where groupid = ?");

		pStmt.setString(1, groupName);
		pStmt.setString(2, groupid);
		
   		rowsUpdated = pStmt.executeUpdate();

   		System.out.println(rowsUpdated);
//		if (rowsUpdated != 1) {
//			throw new Exception("Error in updating the row");
//
//   		}
	     }catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	     finally {
		pStmt.close();
		dbConn.close();
	     }
		return;
	}

	public static void deleteGroup(String inGroupID) throws Exception{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsDeleted = 0;

	     try{
		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("DELETE FROM groups WHERE groupid = ?");
		pStmt.setString(1, inGroupID);
		
   		rowsDeleted = pStmt.executeUpdate();

		if (rowsDeleted != 1) {
			throw new Exception("Error in delete the row");

   		}
	     }catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	     finally {
		pStmt.close();
		dbConn.close();
	     }
		return;
	}


public static void main(String[] arg){
	try{
		MYSQLDBAccess.getAllGroups();
		//MYSQLDBAccess.getGroup("10");
		//MYSQLDBAccess.addGroup("15", "neighbours");
		//MYSQLDBAccess.updateGroup("15", "ClassMates");
		//MYSQLDBAccess.deleteGroup("15");
	} catch (Exception e){
		e.printStackTrace();
	}
}
}
 
