package practice.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithOrgTest {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\RAGHAVAMMA\\Desktop\\EXCEL\\cdata.properties");
		Properties p =new Properties();
		p.load(fis);
		String Browser=p.getProperty("browser");
		String Url=p.getProperty("url");
		String Username=p.getProperty("username");
		String Password=p.getProperty("password");
		//generate random number
		Random random=new Random();
	     int randomInt =random.nextInt(1000);
	     //read test data from excel
	     FileInputStream fis1=new FileInputStream("C:\\Users\\RAGHAVAMMA\\Desktop\\EXCEL\\testscriptdata.xlsx");
			//step-2:open workbook in read mood
			Workbook wb=WorkbookFactory.create(fis1);
			//step-3:get the control of the "org" sheet
			Sheet sh=wb.getSheet("contact");
			//step-4:get the control of 1st row
			Row row=sh.getRow(7);
			String orgName=		row.getCell(3).toString()+randomInt;
			String contactLastName =		row.getCell(4).toString();
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
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			
			driver.get(Url);
			driver.findElement(By.name("user_name")).sendKeys(Username);
			driver.findElement(By.name("user_password")).sendKeys(Password);
			driver.findElement(By.id("submitButton")).click();
			//step2: navigate to Organisation module
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@title='Create Organization'])")).click();
			
			driver.findElement(By.name("accountname")).sendKeys(orgName);
			driver.findElement(By.name("//input[@title='Save[Alt+S]']")).click();
			//verify Header msg Expected result
	String headerinfo=		driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(headerinfo.contains(orgName)) {
		System.out.println(orgName+" is created==PASS");
	}
	else {
		System.out.println(orgName+" is not created==FAIL");
	}
		//verify header orgname info expected result
	String actorgname=driver.findElement(By.id("dtlview_Organization")).getText();
	if(actorgname.equals(orgName)) {
		System.out.println(orgName+" is created==PASS");
	}
	else {
		System.out.println(orgName+" is not created==FAIL");
	}
	
	//step2: navigate to Contacts module
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.xpath("//img[@title='Create Contact...'])")).click();
			
			driver.findElement(By.name("lastname")).sendKeys(contactLastName);
			driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
			//switch to child window
		Set<String> set=	driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		while(it.hasNext()) {
			String windowID=it.next();
			driver.switchTo().window(windowID);
			String actUrl=driver.getCurrentUrl();
			if(actUrl.contains("module=Accounts")) {
				break;
			}
		}
			driver.findElement(By.name("search_text")).sendKeys(orgName);
			driver.findElement(By.name("search")).click();
			driver.findElement(By.xpath("//a[text()='"+orgName+"']")).sendKeys(contactLastName);
			
			//switch to parent window
			Set<String> set1=	driver.getWindowHandles();
			Iterator<String> it1=set1.iterator();
			while(it.hasNext()) {
				String windowID=it1.next();
				driver.switchTo().window(windowID);
				String actUrl=driver.getCurrentUrl();
				if(actUrl.contains("Contacts&action")) {
					break;
				}
			}
			driver.findElement(By.name("//input[@title='Save[Alt+S]']")).click();
			//verify Header msg Expected result

		//verify header orgname info expected result
			String actlastname=driver.findElement(By.id("mouseArea_Organization Name")).getText();
			if(actlastname.trim().equals(contactLastName)) {
				System.out.println(contactLastName+" is created==PASS");
			}
			else {
				System.out.println(contactLastName+" is not created==FAIL");
			}
		driver.quit();
	}

}
