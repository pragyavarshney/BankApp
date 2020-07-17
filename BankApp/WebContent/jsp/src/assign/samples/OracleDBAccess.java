package assign.samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import assign.dbaccess.Group;

 
/**
 * 
 * DBAccess
 *
 */

public class OracleDBAccess {
 
	/**
	 * No Argument Constructor
	 */
	public OracleDBAccess() {
		super();
	}


//Getting Connection

	public static Connection getConnection() throws Exception{
			Connection dbConn = null;
	    try{
	    	try{
	    		Class.forName("oracle.jdbc.driver.OracleDriver");
	    	} catch(ClassNotFoundException e)
	    	{
	    		System.out.println("Couldn't load up driver!");
	    		}
		String url = "jdbc:oracle:thin:@servername:1521:DBName)";
		dbConn = DriverManager.getConnection(url, "","");
		}
	     catch (SQLException sqle) {
	    	System.out.println( + sqle.getErrorCode());
	    	System.out.println(sqle.getMessage());
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
	    	 System.out.println(sqle.getErrorCode());
	    	 System.out.println(sqle.getMessage());
	    	 System.out.println(sqle.getSQLState());
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

	
	public static Group getGroup(String inGroupID) throws Exception{

	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
        ResultSet rs = null;
        Group grp = null;

	     try{
		dbConn = getConnection();
		
		pStmt = dbConn.prepareStatement("SELECT * FROM groups WHERE groupid = ?");
		pStmt.setString(1, inGroupID);
   		rs = pStmt.executeQuery();
   		
   		grp = new Group();
		if (rs.next()) {
			grp.setgroupID(rs.getString(1));
			grp.setgName(rs.getString(2));
   		}
	     }catch (SQLException sqle) {
	    	 sqle.getErrorCode();
	    	 sqle.getMessage();
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
		return grp;
	}

	public static void addGroup(Group grp)  throws Exception{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsInserted = 0;
	    System.out.println("1000000000");
	     try{
	    	 System.out.println("22222222222222");
		dbConn = getConnection();
		System.out.println("333333333");
		pStmt = dbConn.prepareStatement("INSERT INTO groups VALUES (?,?)");
		pStmt.setString(1, grp.getgroupID());
		pStmt.setString(2, grp.getgName());
		
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
 
	public static void updateGroup()  throws Exception{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsUpdated = 0;

	     try{
		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("UPDATE groups SET  groupname=? where groupid = ?");

		pStmt.setString(1, "Managers");
		pStmt.setString(2, "10");
		
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
		OracleDBAccess.getAllGroups();
		//OracleDBAccess.addGroup();
	} catch (Exception e){
		e.printStackTrace();
	}
}
}
 
