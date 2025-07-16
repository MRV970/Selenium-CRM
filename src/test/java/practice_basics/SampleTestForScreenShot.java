package practice_basics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class SampleTestForScreenShot {
	@Test
	public void amazonTest() throws IOException {
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
//		1.create an object to EventFiring WebDriver
//	      EventFiringWebDriver edriver=new EventFiringwebDriver(driver);
//		
//		2.use getScreenShotAs() to get file type of screenshot
//        File srcFile	=	edriver.getScreenshotAs(OutputType.FILE);
		//1.create an object for Takes screenshot
				TakesScreenshot ts=(TakesScreenshot)driver;
				//2.use getScreenshot()
				File srcFile =ts.getScreenshotAs(OutputType.FILE);
				//3.store screen shot on local driver
				FileUtils.copyFile(srcFile, new File("./screenshot/test.png"));
				
		
		driver.close();
	}

}
