package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class SeleniumTestfromXml {
	@Test
	public void demo(XmlTest test) throws EncryptedDocumentException, IOException {
		
		String Url=test.getParameter("url");
		String Browser=test.getParameter("browser");
		String Username=test.getParameter("username");
		String Password=test.getParameter("password");
		
		
		
		//generate random number
		Random random= new Random();
		int randomInt=random.nextInt(1000);
		//read testscript data from Excel sheet
		FileInputStream fis=new FileInputStream("C:\\Users\\RAGHAVAMMA\\Desktop\\EXCEL\\testscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh =wb.getSheet("org");
		Row row=sh.getRow(1);
		String orgName=row.getCell(2).toString()+randomInt;
		wb.close();
		WebDriver driver =null;
		if(Browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(Browser.equals("firefox")) {
			driver=new FirefoxDriver();
			
		}
		else if(Browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		
		driver.get(Url); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//logout
		 WebElement ad=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
			Actions act=new Actions(driver);
			act.moveToElement(ad).perform();
			driver.findElement(By.linkText("Sign Out")).click();
		
	}

}
