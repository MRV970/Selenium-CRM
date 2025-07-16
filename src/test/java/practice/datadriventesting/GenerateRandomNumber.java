package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GenerateRandomNumber {
	public static void main(String[] args) throws IOException {
		FileInputStream fis =new FileInputStream("path of the file");
		Properties p=new Properties();
		p.load(fis);
		String Browser=p.getProperty("browser");
		//generate random number
		Random random =new Random();
		int randomInt=random.nextInt(1000);
		FileInputStream fs=new FileInputStream("path of the file");
		Workbook wb=WorkbookFactory.create(fs);
		Sheet sh=wb.getSheet("fg");
		Row row =sh.getRow(0);
		String data=row.getCell(1).toString()+randomInt;
		wb.close();
		
		}

         }
