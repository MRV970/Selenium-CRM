package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteNonSelectQuery {
	public static void main(String[] args) throws SQLException {
		
//		 step-1:load/register the database driver
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
//		step-2:connect to database
	Connection conn=	DriverManager.getConnection("JDBC:mysql://106.51.90.215:3333/projects", "root@%", "root");
		System.out.println("====Done=====");
//		step-3:create sql statement
	Statement stat=	conn.createStatement();
	//step-4 :execute non select query
	int result=stat.executeUpdate("insert into project values('TY_PROJ_2000','Deepak','04/27/2023','FB','On Going','100')");
	System.out.println(result);
	}

}
