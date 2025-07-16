package Poi_Basics;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DWS_RegisterTest {
	@DataProvider(name="RegisterTestdata")
	public Object[][] getTestdata() throws  IOException{
		String path="./Test_Data/DWS_TestData.xlsx";
		FileInputStream fis=new FileInputStream(new File(path));
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet =workbook.getSheet("RegisterTC");
		 int rowcount=sheet.getPhysicalNumberOfRows();
		 int colcount=sheet.getRow(0).getPhysicalNumberOfCells();
		 Object[][] data=new Object[rowcount-1][colcount];
		 for(int i=1;i<rowcount;i++) {
			 for(int j=0;j<=colcount-1;j++) {
				 data[i-1][j]=sheet.getRow(i).getCell(j).toString();
				 }
		 }
		return data;
		
	}
		@Test(dataProvider = "RegisterTestdata")
		public void registerTC(String firstname,String lastname,String email,String password,String cpassword) {
			WebDriver driver =new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.get("https://demowebshop.tricentis.com/");
			driver.findElement(By.linkText("Register")).click();
			driver.findElement(By.id("gender-female")).click();
			driver.findElement(By.id("FirstName")).sendKeys(firstname);
			driver.findElement(By.id("LastName")).sendKeys(lastname);
			driver.findElement(By.id("Email")).sendKeys(email);
			driver.findElement(By.id("Password")).sendKeys(password);
			driver.findElement(By.id("ConfirmPassword")).sendKeys(cpassword);
			driver.findElement(By.id("register-button")).click();
			
			
		}
		
	
}

