
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class CreateTable implements  Reflection {
		
	private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String protocol = "jdbc:derby:";	
	
	public static void main(String[] main) throws SQLException{
		
		try
		{
			Class.forName(driver);
			//System.out.println("Loaded the embedded driver.");
		}
		catch (Exception err)  
		{
			System.err.println("Unable to load the embedded driver.");
			err.printStackTrace(System.err);
			System.exit(0);
        }
		
		String dbName = "car";
		Connection conn = DriverManager.getConnection(protocol + dbName + ";create=true");
		Statement s = conn.createStatement();
		System.out.println("Database created");

		
		//
		//Reflection Function to get the field from Vehicle 
		//
		//
		
		 Reflection.create();
		

		for(int i =0; i<10; i++) 
		{
			 Reflection.data();
			
		}
		
		
		//
		//display the table
		//
		Vehicle v1 = new Vehicle();
		ResultSet rs = s.executeQuery("SELECT * FROM car");
		
		try {
				while(rs.next())
			{
				v1.display(rs);
			}
			
		}
		catch(SQLException err)
		{
			err.printStackTrace();
		}
		
		
		//drop the table 
		try 
		{
			System.out.println(" ");
			s.execute("DROP TABLE car");
			System.out.println("Table droped");
		}catch(SQLException err) {
			err.printStackTrace();
		} 
				
		conn.close();
				
		
		//
		//call log file
		//
		
		logFile lg = new logFile();
		lg.createlog();
		
	
	}
}
			