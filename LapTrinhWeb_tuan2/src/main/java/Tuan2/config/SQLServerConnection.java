package Tuan2.config;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
public class SQLServerConnection 
{
	private final String serverName = "localhost";
	private final String dbName = "laptrinhwebtuan2";
	private final String portNumber = "1433";
	private final String instance = "";
	private final String userID = "sa";
	private final String password = "123456";
	
	
	public Connection getConnection()  
	{
		Connection conn = null;
		try 
		{
			String url = "jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber + ";databaseName=" + dbName;
			if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://"+serverName+":"+portNumber +";databaseName="+dbName;
			conn = DriverManager.getConnection(url , userID , password);
			
			if (conn !=  null)
			{
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
				return conn;
			}
		} 
		
		catch(SQLException ex) 
		{
			ex.printStackTrace();
		}
		return null;	
			
	}
		
	


	public static void main( String[] args)
	{
		try {
			System.out.println("Succes:" + new  SQLServerConnection().getConnection());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}	
}
