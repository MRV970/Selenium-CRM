package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Create_Organization {
public static void main(String[] args) throws IOException {
	FileInputStream fis=new FileInputStream("C:\\Users\\RAGHAVAMMA\\Desktop\\cdata.properties");
	Properties p=new Properties();
	p.load(fis);
	String Browser=p.getProperty("chrome");
	String Url=p.getProperty("url");
	String Username=p.getProperty("username");
	String Password=p.getProperty("password");
	String Org=p.getProperty("organization");
	WebDriver driver=new FirefoxDriver();
	driver.get(Url);
	driver.findElement(By.name("user_name")).sendKeys(Username);
	driver.findElement(By.name("user_password")).sendKeys(Password);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys(Org);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	if(driver.findElement(By.linkText("More Information")).isDisplayed()) {
		System.out.println("Organization created successfully");
	}
	
}
}
