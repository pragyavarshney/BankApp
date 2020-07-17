package assign.samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import assign.dbaccess.Group;

 
/**
 * 
 * DBAccess
 *
 */

public class MSDBAccess {
 
	/**
	 * No Argument Constructor
	 */
	public MSDBAccess() {
		super();
	}


//Getting Connection

	public static Connection getConnection() throws Exception{
			Connection dbConn = null;
	    try{
	    //step1	
	    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    
	    //step2
		String url = "jdbc:odbc:emaildb";
		
		//step3
		dbConn  = DriverManager.getConnection(url);
		}
	     catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	return dbConn;
	}



// Queries

	public static void getAllGroups() throws Exception{

	    Connection dbConn = null;
	    Statement pStmt = null;
        ResultSet rs = null;

	     try{

		dbConn = getConnection();
		//step4

		System.out.println(dbConn);
		pStmt = dbConn.createStatement();
		//step5

		rs = pStmt.executeQuery("SELECT * FROM groups");
		
		System.out.println("11111");
		//step6
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
	    //step7
		rs.close();
		pStmt.close();
		dbConn.close();
	     }
		return;
	}

	
	public static void getGroup(String inGroupID) throws Exception{

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
	     }catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
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

	public static void addGroup(Group group)  throws Exception{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsInserted = 0;

	     try{
		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("INSERT INTO groups VALUES (?,?)");
		pStmt.setString(1, group.getgroupID());
		pStmt.setString(2, group.getgName());
		
   		rowsInserted = pStmt.executeUpdate();

		if (rowsInserted != 1) {
			throw new Exception("Error in inserting the row");

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
 
	public static void updateGroup(String groupId, String groupName)  throws Exception{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsUpdated = 0;

	     try{
		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("UPDATE groups SET  groupName=? where groupId=?");

		pStmt.setString(1, groupName);
		pStmt.setString(2, groupId);
		System.out.println("The query is" + pStmt.toString());
   		rowsUpdated = pStmt.executeUpdate();

		if (rowsUpdated != 1) {
			throw new Exception("Error in updating the row");

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
		MSDBAccess.getAllGroups();
		//.getGroup("7");
		//MSDBAccess.updateGroup("9", "Collegues");
		//Group grp1 = new Group("10", "Relatives");
		//MSDBAccess.addGroup(grp1);
		//MSDBAccess.deleteGroup("10");
	} catch (Exception e){
		e.printStackTrace();
	}
}
}
 
