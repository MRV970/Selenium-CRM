package Poi_Basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Working_With_Excelfile {
	@Test
	public void Demo() throws EncryptedDocumentException, IOException {
		String path="./Test_Data/DWS_TestData.xlsx";
		FileInputStream fis=new FileInputStream(new File(path));
		//create workbook
		 Workbook  workbook = WorkbookFactory.create(fis);
		 //Access the data
		 Sheet sheet=workbook.getSheet("Names");
		 //fetch the values
		 String row_value=sheet.getRow(3).getCell(0).toString();
		 System.out.println(row_value);
		 //count no .of rows and columns
		 int rowcount=sheet.getPhysicalNumberOfRows();
		 int colcount=sheet.getRow(0).getPhysicalNumberOfCells();
		 System.out.println(rowcount);
		 System.out.println(colcount);
		 
		 for(int i=0;i<=rowcount-1;i++) {
			 //System.out.println(sheet.getRow(i).getCell(0).toString());
			 for(int j=0;j<=colcount-1;j++) {
				 System.out.print(sheet.getRow(i).getCell(j).toString()+" ");
			 }
			 System.out.println();
			 
			 
		 }
		
	}
}
