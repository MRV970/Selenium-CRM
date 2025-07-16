package practice.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithSupportDateTest2 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
	
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
		Row row =sh.getRow(4);
		String lastName=row.getCell(2).toString()+randomInt;
	
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
		//step2: navigate to Contacts module
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...'])")).click();
		Date date=new Date();
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String startDate=sim.format(date);
		System.out.println(startDate);
		
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,30);
		String endDate=sim.format(cal.getTime());
		System.out.println(endDate);
		
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startDate);
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);
		driver.findElement(By.name("//input[@title='Save[Alt+S]']")).click();
		//verify Header msg Expected result

	//verify header orgname info expected result
String actstartdate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
if(actstartdate.equals(startDate)) {
	System.out.println(startDate+" information is verified==PASS");
}
else {
	System.out.println(startDate+" information is not verified==FAIL");
}
String actenddate=driver.findElement(By.id("dtlview_Support End Date")).getText();
if(actenddate.equals(endDate)) {
	System.out.println(endDate+" information is verified==PASS");
}
else {
	System.out.println(endDate+" information is not verified==FAIL");
}
	driver.quit();

}}
