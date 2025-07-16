package practice_basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SampleTest {
	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		try {
//		 step-1:load/register the database driver
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
//		step-2:connect to database
	 conn=	DriverManager.getConnection("JDBC:mysql://106.51.90.215:3333/projects", "root@%", "root");
		System.out.println("====Done=====");
//		step-3:create sql statement
	Statement stat=	conn.createStatement();
//		step-4:execute select query &get result
ResultSet resultset=	stat.executeQuery("select * from project");
while(resultset.next()) {
	System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4)+"\t"+resultset.getString(5)+"\t"+resultset.getInt(6));
}
		}catch(Exception e) {
			System.out.println("handle exception");
		}
		finally {
//		step-5:close the connection
conn.close();
System.out.println("close the connection");
	}
	}
}
