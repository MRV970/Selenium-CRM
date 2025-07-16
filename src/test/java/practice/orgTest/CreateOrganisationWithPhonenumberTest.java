package practice.orgTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrganisationWithPhonenumberTest {
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
			Sheet sh=wb.getSheet("org");
			//step-4:get the control of 1st row
			Row row =sh.getRow(7);
			String orgName=row.getCell(2).toString()+randomInt;
			String phone=row.getCell(3).toString();
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
			driver.findElement(By.id("phone")).sendKeys(phone);
			driver.findElement(By.name("//input[@title='Save[Alt+S]']")).click();
			//verify Header phone number Expected result
	String phonenum=		driver.findElement(By.name("dtlview_Organization Name")).getText();
	if(phonenum.contains(phone)) {
		System.out.println(phone+"  information is created==PASS");
	}
	else {
		System.out.println(phone+"  information is not created==FAIL");
	}
//		//verify header orgname info expected result
//	String actorgname=driver.findElement(By.id("dtlview_Organization")).getText();
//	if(actorgname.equals(orgName)) {
//		System.out.println(orgName+" is created==PASS");
//	}
//	else {
//		System.out.println(orgName+" is not created==FAIL");
//	}
//			
	}

}
