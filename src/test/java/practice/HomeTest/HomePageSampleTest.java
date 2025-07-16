package practice.HomeTest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleTest {
	
	
     @Test
      public void homePageTest(Method mtd) {
    	 System.out.println(mtd.getName()+" ===TEST STARTS===");
    	 
    	 SoftAssert sa=new SoftAssert();
    	  System.out.println("step-1");
    	 System.out.println("step-2");
    	 sa.assertEquals("Home", "Home-Page");
    	 System.out.println("step-3");
    	 sa.assertEquals("Home-CRM", "Home-CRM");
    	 System.out.println("step-4");
        sa.assertAll();
    	 System.out.println(mtd.getName()+" ==TEST END==");
     }
     @Test
     public void verifyLogoHomePageTest(Method mtd) {
    	 System.out.println(mtd.getName()+" ===TEST STARTS===");
    	 SoftAssert sa=new SoftAssert();
    	 System.out.println("step-1");
    	 System.out.println("step-2");
    	 sa.assertTrue(true);
    	 System.out.println("step-3");
    	 
    	 System.out.println("step-4");
    sa.assertAll();
    	 
   System.out.println(mtd.getName()+" ====TEST END====");
     }
}
