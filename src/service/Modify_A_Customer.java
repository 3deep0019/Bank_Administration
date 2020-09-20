package service;

import java.io.File;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Modify_A_Customer {
	public void Modify_Customer(int id,String value,int index ){
		FileInputStream fis;
		try {
			fis = new FileInputStream(new File("D:\\\\New folder\\\\Bank_administration\\\\excel\\\\Customer.xlsx"));
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		
		for(Row row:sheet) {
			if(row.getRowNum()>0) {
			if(row.getCell(0).getNumericCellValue()==id)
			{
			for(Cell cell:row) 
				{
				if(cell.getColumnIndex()==index) {
					cell.setCellValue(value);
				}
				  
				}
			 }
		}
		}
	fis.close();
	FileOutputStream fileout = new FileOutputStream(new File("D:\\\\New folder\\\\Bank_administration\\\\excel\\\\Customer.xlsx"));
	wb.write(fileout);
	fileout.close();
} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

	
}
