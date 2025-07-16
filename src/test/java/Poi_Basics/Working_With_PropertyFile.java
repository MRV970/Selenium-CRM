package Poi_Basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Working_With_PropertyFile {
	@Test
	public void demo() throws IOException {
		String path="./Test_Configuration/TestConfiguration.properties.txt";
		FileInputStream fis=new FileInputStream(new File(path));
		Properties prop=new Properties();
		prop.load(fis);
		//to retrive the values from property file
      String fname=prop.getProperty("Firstname");
      
      System.out.println(fname);
      String lname=prop.getProperty("Lastname");
      System.out.println(lname);
      String company=prop.getProperty("Company");
      System.out.println(company);
		
	}

}
