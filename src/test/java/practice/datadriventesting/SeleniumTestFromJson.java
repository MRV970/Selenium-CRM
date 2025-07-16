package practice.datadriventesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumTestFromJson {
	@Test
	public void demo() {}}
//		
//		//read data from json
//		JSONParser parser =new JSONParser();
//		Object obj=		parser.parse(new FileReader("C:\\Users\\RAGHAVAMMA\\Desktop\\EXCEL\\appCommonData.json"));
//		//step2 :Convert java Object in to JsonObjext using downcasting
//		JSONObject map=(JSONObject)obj;
//		//step3:get the value from json
//		String Url= map.get("url").toString();
//		String Browser= map.get("browser").toString();
//		
//		String Username= map.get("username").toString();
//		String Password= map.get("password").toString();
//		//generate the random number
//		Random random=new Random();
//		int randomInt=random.nextInt(1000);
//		//read testscripot data from Excel file
//		FileInputStream fis=new FileInputStream("");
//		Workbook wb=WorkbookFactory.create(fis);
//		Sheet sh=wb.getSheet("org");
//		Row row=sh.getRow(1);
//		String orgName=row.getCell(2).toString()+randomInt;
//		wb.close();
//		WebDriver driver =null;
//		if(Browser.equals("chrome")) {
//			driver=new ChromeDriver();
//		}
//		else if(Browser.equals("firefox")) {
//			driver=new FirefoxDriver();
//			
//		}
//		else if(Browser.equals("edge")) {
//			driver=new EdgeDriver();
//		}
//		else {
//			driver=new ChromeDriver();
//		}
//		
//		driver.get(Url);
//		driver.findElement(By.name("user_name")).sendKeys(Username);
//		driver.findElement(By.name("user_password")).sendKeys(Password);
//		driver.findElement(By.id("submitButton")).click();
//		driver.findElement(By.linkText("Organizations")).click();
//		driver.findElement(By.xpath("")).click();
//		driver.findElement(By.name("")).sendKeys(orgName);
//		driver.findElement(By.xpath("")).click();
//		//logout
//		
//	}
//
//}
