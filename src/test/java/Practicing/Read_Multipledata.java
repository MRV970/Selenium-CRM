package Practicing;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Read_Multipledata {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\RAGHAVAMMA\\Desktop\\EXCEL\\testscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet2");
		int rowcount=sh.getLastRowNum();
		
		for(int i=0;i<=rowcount;i++) {
			Row row=sh.getRow(i);
			String col1=row.getCell(0).toString();
			String col2=row.getCell(1).toString();
			String col3=row.getCell(2).toString();
			String col4=row.getCell(3).toString();
			String col5=row.getCell(4).toString();
			String col6=row.getCell(5).toString();
			String col7=row.getCell(6).toString();
			//String col8=sh.getRow(i).getCell(7).toString();
		
		System.out.println(col1+"\t  "+col2+"\t   "+col3+"\t   "+col4+"\t  "+col5+"\t  "+col6+"\t   "+col7);
		
		
		
	}
		wb.close();
	}
}
