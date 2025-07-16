package Poi_Basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DWS_LoginTest_Propertyfile {
	
	
	WebDriver driver;
	@Test
	
	
	public void TC1() throws IOException, InterruptedException{
		//propertyfile
		FileInputStream fis=new FileInputStream(new File("./Test_Configuration/TestConfiguration.properties.txt"));
		Properties prop=new Properties();
		prop.load(fis);
		
		String browsername=prop.getProperty("browser");
		String time=prop.getProperty("timeout");
		String url=prop.getProperty("URL");
		
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(prop.getProperty("Email"));
		driver.findElement(By.id("Password")).sendKeys("password");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		Thread.sleep(2000);
		driver.close();
		
	
	}
}