package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipledataFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\RAGHAVAMMA\\Desktop\\EXCEL/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rowcount = sh.getLastRowNum();
		for (int i = 0; i <= rowcount; i++) {
			Row row = sh.getRow(i);
			String col1Data = row.getCell(0).toString();
			String col2Data = row.getCell(1).toString();
			System.out.println(col1Data + "\t" + col2Data);
		}
		wb.close();
	}
}
