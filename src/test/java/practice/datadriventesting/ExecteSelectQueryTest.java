package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecteSelectQueryTest {
	public static void main(String[] args) throws SQLException {

//		 step-1:load/register the database driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);

//		step-2:connect to database
		Connection conn = DriverManager.getConnection("JDBC:mysql://106.51.90.215:3333/projects", "root@%", "root");
		System.out.println("====Done=====");
//		step-3:create sql statement
		Statement stat = conn.createStatement();
//		step-4:execute select query &get result
		ResultSet resultset = stat.executeQuery("select * from project");
		while (resultset.next()) {
			System.out.println(resultset.getString(1) + "\t" + resultset.getString(2) + "\t" + resultset.getString(3)
					+ "\t" + resultset.getString(4) + "\t" + resultset.getString(5) + "\t" + resultset.getInt(6));
		}
//		step-5:close the connection
		conn.close();
	}

}
