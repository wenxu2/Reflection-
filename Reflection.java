import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public interface Reflection {
	
	//get field from vehicle class
	public static void create() throws SQLException
	{
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";
		String protocol = "jdbc:derby:";	
		String dbName = "car";
		Connection conn = DriverManager.getConnection(protocol + dbName + ";create=true");
		Statement s = conn.createStatement();
		Class c = Vehicle.class;
		ArrayList al1 = new ArrayList();
	
		Field field[] = c.getDeclaredFields();
		
		for(int i = 2; i <field.length; i++ )
		{
			al1.add(field[i].getName());
				
		}
		
		Object a0 = al1.get(0);
		Object a1 = al1.get(1);
		Object a2 = al1.get(2);
		Object a3 = al1.get(3);
		Object a4 = al1.get(4);
		Object a5 = al1.get(5);
		
		
		try {
		
		s.execute("CREATE TABLE CAR"
			  +"("
			  + a0 + " varchar(10),"
			  + a1 + " varchar(20),"
			  + a2 + " int,"
			  + a3 + " int,"
			  + a4 + " int,"
			  + a5 + " varchar(10)"
			  +")");
		}
		catch(SQLException err)
		{
			System.err.println("SQL error.");
 			err.printStackTrace(System.err);
 			System.exit(0);
		}
		
		System.out.println(a0 + "\t\t" + a1+ "\t\t\t" + a2+ "\t\t" + a3+ "\t" + a4+ "\t\t" + a5);
		System.out.println(" ");
		
	}
	
	
	//get variables from variable class
	
	public static void data() throws SQLException {	
		
	String m1;
	String model[]= {"Chevy  ", "Ford   ","Toyota ","Nissan ","Hyundai"};
	String m2;
	String make[] = {"compact   ","Intermedia","fullSized ","van       ","suv       ","pickup    "};
	int w = 0;
	int es;
	int d;
	boolean I;
	boolean Import[] = {true,false};
	


	Random rand = new Random();
	int i = rand.nextInt(model.length);	
	m1 = model[i];
	
	int a = rand.nextInt(make.length);
	m2 = make[a];
	
	
	
	if("compact".equals(m2))
	{
		int l = 1500;
		int h = 2000;
		w= rand.nextInt(h-l) + l;
		es = w - 800;
		d = 2;
				
	}
	else if("Intermedia".equals(m2))
	{
		int l = 2000;
		int h = 2500;
	    w =rand.nextInt(h-l)+l;
		es =  w - 800;
		d = 4;
		
	}
	else
	{
		int l = 2500;
		int h = 4000;
		w =rand.nextInt(h-l)+l;
		es =  w - 800;
		d = 4;
		
	}
	

	int e = rand.nextInt(Import.length);
	I = Import[e];
	

	ArrayList q = new ArrayList();
	
	q.add(m1);
	q.add(m2);
	q.add(w);
	q.add(es);
	q.add(d);
	q.add(I);	
	
	Vehicle v = new Vehicle(q.get(0),q.get(1),q.get(2),q.get(3),q.get(4),q.get(5));
	
	
	try 
	{
		ArrayList we = new ArrayList();
		
		Method m11 = v.getClass().getDeclaredMethod("setModel",String.class);
		Method m22 = v.getClass().getDeclaredMethod("setMake",String.class);
		Method m3 = v.getClass().getDeclaredMethod("setWeight",double.class);
		Method m4 = v.getClass().getDeclaredMethod("setEngineSize",double.class);
		Method m5 = v.getClass().getDeclaredMethod("setDoors",int.class);
		Method m6 = v.getClass().getDeclaredMethod("setImport",boolean.class);
		

			m11.invoke(v, q.get(0));
			m22.invoke(v,q.get(1));
			m3.invoke(v,q.get(2));
			m4.invoke(v,q.get(3));
			m5.invoke(v, q.get(4));
			m6.invoke(v,q.get(5));
		
		we.add(v.getModel());	
		we.add(v.getMake());
		we.add(v.getWeight());
		we.add(v.getEngineSize());
		we.add(v.getDoors());
		we.add(v.isImport());
		
		
		v.addInfo(v.getModel(), v.getMake(), v.getWeight(), v.getEngineSize(), v.getDoors(), v.isImport());
		
		
	}
	catch(Exception ee)
	{
		ee.printStackTrace();
	}
		
			
	}
	
	
	
}
