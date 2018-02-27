/*
 * 
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class Vehicle {
	
	private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String protocol = "jdbc:derby:";
    
    
	
	//private static String make[]= {"Chevy", "Ford","Toyota","Nissan","Hyundai"};
	//private static String model[] = {"compact","Intermedia","fullSized","van","suv","pickup"};
	private static String make;
	private static String model;
	private static double weight;
	private static double engineSize;
	private static int doors;
	//private static boolean Import[] = {true,false};
	private static boolean Import;
	
	
	
	public Vehicle(Object object, Object object2, Object object3, Object object4, Object object5, Object object6){
		
		object = "";
		object2 = "";
		object3 = weight;
		object4 = engineSize;
		object5 = doors;
		object6 = false;
		
	}
	

	public Vehicle()
	{
		make = "";
		model = "";
		weight = 0;
		engineSize = 0;
		doors = 0;
		Import = false;
		
	}
	
	
	
	public static String getMake() {
		return make;
	}



	public static void setMake(String make) {
		Vehicle.make = make;
	}



	public static String getModel() {
		return model;
	}



	public static void setModel(String model) {
		Vehicle.model = model;
	}



	public static double getWeight() {
		return weight;
	}



	public static void setWeight(double weight) {
		Vehicle.weight = weight;
	}

	public static double getEngineSize() {
		return engineSize;
	}



	public static void setEngineSize(double engineSize) {
		Vehicle.engineSize = engineSize;
	}



	public static int getDoors() {
		return doors;
	}



	public static void setDoors(int doors) {
		Vehicle.doors = doors;
	}



	public static boolean isImport() {
		return Import;
	}



	public static void setImport(boolean Import) {
		Vehicle.Import = Import;
	}
	
	
	
	//Connection 
	private Connection connect()
			{
				String dbName = "car";
				Connection conn = null;
				
				
				
			 try {
				conn = DriverManager.getConnection(protocol + dbName);
				Statement s = conn.createStatement();
				
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				return conn;
			}
			
	//String a, String b, double c, double d, int e, boolean f
	public void addInfo(String w0, String w1, double w2, double w3, int w4, boolean w5)throws SQLException
			{
				String sql = "INSERT INTO car(make,Model,Weight,EngineSize,Doors,Import) VALUES(?,?,?,?,?,?)";
				try(Connection conn = this.connect();
						PreparedStatement ps = conn.prepareStatement(sql))
				{
					ps.setString(1,w0);
					ps.setString(2, w1);
					ps.setDouble(3, w2);
					ps.setDouble(4,w3);
					ps.setInt(5, w4);
					ps.setBoolean(6, w5);
					ps.executeUpdate();
					
					conn.close();
					ps.close();
					
				}catch(SQLException e1)
				{
					System.out.println(e1.getMessage());
				}
					
		}

 public static void display(ResultSet rs) throws SQLException
		{
			
			make = rs.getString("make");
			model = rs.getString("model");
			weight = rs.getDouble("weight");
			engineSize = rs.getDouble("EngineSize");
			doors = rs.getInt("doors");
			Import = rs.getBoolean("Import");
			
			System.out.println(make+"\t\t"+model+"\t\t"+weight+"\t\t"+engineSize+"\t\t"+doors+"\t\t"+Import);
			
			
		}	  
		
			
	
	
	
	
}