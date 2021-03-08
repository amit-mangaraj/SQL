package configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class Myconfiguration {
	public static Connection getConnection() throws Exception
	{
		
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/SQLActivity3","root","admin");
		return c;
		
	}
}
