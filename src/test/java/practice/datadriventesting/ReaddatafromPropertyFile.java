package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReaddatafromPropertyFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream("C:\\Users\\RAGHAVAMMA\\Desktop\\cdata.properties");
		Properties p = new Properties();
		p.load(fis);
		System.out.println(p.getProperty("browser"));
		
	}

}
