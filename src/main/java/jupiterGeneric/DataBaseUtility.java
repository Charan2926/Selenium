package jupiterGeneric;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Driver driverRef;
	Connection con;
	
	public void connectToDatabase() throws SQLException 
	{
			driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			con =DriverManager.getConnection(IConstantPaths.dbURL ,IConstantPaths.dbUsername, IConstantPaths.dbPassword);			
	}	
	public void DisconectFromDatabase() throws SQLException {
		con.close();
	}
		
		
	}

