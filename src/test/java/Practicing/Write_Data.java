package Practicing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Write_Data {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\RAGHAVAMMA\\Desktop\\EXCEL\\testscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet2");
       Row row=sh.getRow(4);
       Cell cel=row.createCell(7);
       cel.setCellType(CellType.STRING);
       cel.setCellValue("November");
       Row  row1=sh.getRow(3);
       Cell cel1=row1.createCell(7);
       
       cel1.setCellType(CellType.STRING);
       cel1.setCellValue("12-jan-2020");
       FileOutputStream fos=new FileOutputStream("C:\\Users\\RAGHAVAMMA\\Desktop\\EXCEL\\testscriptdata.xlsx");
      wb.write(fos);
      wb.close();
      System.out.println("Executed");
		
	}

}
