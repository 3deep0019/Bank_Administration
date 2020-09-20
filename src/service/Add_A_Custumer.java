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

import model.User; 

public class Add_A_Custumer {
	public void Add_Customer(User user) {
		FileOutputStream fileout;
		try {

			FileInputStream in=new FileInputStream("D:\\\\New folder\\\\Bank_administration\\\\excel\\\\Customer.xlsx");
			XSSFWorkbook workbook1 =new XSSFWorkbook(in);
			XSSFSheet sheet =workbook1.getSheetAt(0);
			int row=sheet.getLastRowNum()+1;
			XSSFRow row1=sheet.createRow(row);
			row1.createCell(0).setCellValue(user.getId());
			row1.createCell(1).setCellValue(user.getName());
			row1.createCell(2).setCellValue(user.getEmail());
			row1.createCell(3).setCellValue(user.getAddress());
			row1.createCell(4).setCellValue(user.getPhone_no());
			
			fileout=new FileOutputStream(new File("D:\\\\New folder\\\\Bank_administration\\\\excel\\\\Customer.xlsx"));
			workbook1.write(fileout);
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
