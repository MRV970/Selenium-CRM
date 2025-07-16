package Practicing;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Multipledata_condition {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String ExpectedName="ALLEN";
		String data="";
		String data1="";
		String data2="";
		String data3="";
		
		String data4="";
	boolean	flag =false;
		FileInputStream fis=new FileInputStream("C:\\Users\\RAGHAVAMMA\\Desktop\\EXCEL\\testscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet2");
		int rowcount=sh.getLastRowNum();
		for(int i=0;i<=rowcount;i++) {
			data=sh.getRow(i).getCell(1).toString();
			if(data.equals(ExpectedName)) {
				flag=true;
				data1=sh.getRow(i).getCell(0).toString();
				data2=sh.getRow(i).getCell(2).toString();
				data3=sh.getRow(i).getCell(1).toString();
				data4=sh.getRow(i).getCell(6).toString();
				
			}
		}
		
		if(flag==true) {
			System.out.println(data1+"\t"+data2+"\t"+data3+"\t"+data4);
			
		}
			else {
				System.out.println(ExpectedName+" data is not available");
			}
		
	}

}
