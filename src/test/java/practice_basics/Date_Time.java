package practice_basics;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.Test;

public class Date_Time {
	public static void main(String[] args) {
		Date date=new Date();
	
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String actDate=sim.format(date);
		System.out.println(actDate);
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,30);
		String dateRequires=sim.format(cal.getTime());
		System.out.println(dateRequires);
		
}
	
	
	@Test(expectedExceptions = Exception.class)
	public void exception() {
		int a=10/0;
		System.out.println(a);
		
		String s=null;
		System.out.println(s);
		
	}

}

