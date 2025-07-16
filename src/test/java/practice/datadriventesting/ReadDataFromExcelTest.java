package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//step-1:get the Excel path location &java Object of the physical Excelfile
		FileInputStream fis=new FileInputStream("C:\\Users\\RAGHAVAMMA\\Desktop\\EXCEL\\testscriptdata.xlsx");
		//step-2:open workbook in read mood
		Workbook wb=WorkbookFactory.create(fis);
		//step-3:get the control of the "org" sheet
		Sheet sh=wb.getSheet("org");
		//step-4:get the control of 1st row
		String data=sh.getRow(1).getCell(3).getStringCellValue();
		//step-5:get the control of 2 nd cell&read the string data
		//Cell cell=row.getCell(3);
	//	String data=cell.getStringCellValue();
		System.out.println(data);
		//step-6:close the workbook
		
		System.out.println(sh.getRow(0).getLastCellNum());
		System.out.println(sh.getRow(0).getPhysicalNumberOfCells());
		wb.close();
	}

}
