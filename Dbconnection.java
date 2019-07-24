package pollingsystem;

import java.sql.*;
import java.util.*;

public class Dbconnection {
	
	public static Connection con;
	
public Connection connectDb() {
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/student1","root","10decoders");
	}catch(Exception e) {
		System.out.println("error");
}
	return con;
}
Dbconnection get=new Dbconnection();
/*public static void main(String args[]) {
	Dbconnection get=new Dbconnection();
	connectDb();
}*/
}
