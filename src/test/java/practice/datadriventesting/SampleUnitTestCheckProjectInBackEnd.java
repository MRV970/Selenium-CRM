package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class SampleUnitTestCheckProjectInBackEnd {
	@Test
	public void  projectCheckTest() throws SQLException {
		Connection conn=null;
		String expectedProjectName="FB";
		boolean flag=false;
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
	String project=resultset.getString(4);
	if(expectedProjectName.equals(project)) {
		flag=true;
		System.out.println(expectedProjectName+" is available==Pass");
		
	}
	
}
if(flag==false) {
	System.out.println(expectedProjectName+" is  not available==Fail");
	Assert.fail();
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
