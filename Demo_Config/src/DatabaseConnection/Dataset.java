package DatabaseConnection;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import org.junit.Before;
import org.testng.annotations.Test;

public class Dataset {
	
	private String conURL="jdbc:oracle:thin:@lnxdb-dev-vm-233.cisco.com:1522:OPSRDEV";
	
	
	private String uname="QACAUTOUSR";
	private String pwd="1s8O12e";
	private String dURL="oracle.jdbc.driver.OracleDriver";
	private Connection con = null;
	 
     	public Dataset(String connectionURL, String driverURL, String username, String password){
		this.conURL=connectionURL;
		this.dURL=driverURL;
		this.uname=username;
		this.pwd=password;
	}
	
       
	 @Before 
	 public HashMap<Integer, String> ExecQuery(String Query,int colIndex) throws Exception{
			HashMap<Integer, String> columnVal=new HashMap<Integer, String>();
			int i=0;
		    Connection conn = getDatabaseConnection();
		    if(con!= null){
			    Statement smt = conn.createStatement();
			    ResultSet rslt =
			         smt.executeQuery(Query);
			    while (rslt.next()) {
			    	columnVal.put(i, rslt.getString(colIndex));
			    	i++;
			    }
			    smt.close();

		    }else{
			    System.out.println("Could not Get Connection");
		    }
			
			
			return columnVal;
		}
		
	 @Test
		private Connection getDatabaseConnection(){

			try {
				Class.forName(dURL);	

			} catch(java.lang.ClassNotFoundException e) {
				System.err.print("ClassNotFoundException: ");
				System.err.println(e.getMessage());
			}

			try {
			   this.con = DriverManager.getConnection(conURL, uname, pwd);
			} catch(SQLException ex) {
				System.err.println("SQLException: " + ex.getMessage());
			}

			return con;
		}
	 
	 public static void main(String[] args) {
		System.out.println("Hello");
	}
     }