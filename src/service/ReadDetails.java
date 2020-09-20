	package service;
	import java.io.File;  
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Iterator;  
	import org.apache.poi.ss.usermodel.Cell;  
	import org.apache.poi.ss.usermodel.Row;  
	import org.apache.poi.xssf.usermodel.XSSFSheet;  
	import org.apache.poi.xssf.usermodel.XSSFWorkbook; 

public class ReadDetails {
		//readRecord method is used to read the value from the file
	   public void readRecord(){
		  try {
			FileInputStream fis=new FileInputStream(new File("D:\\\\New folder\\\\Bank_administration\\\\excel\\\\Customer.xlsx"));
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet=wb.getSheetAt(0);
			
			Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
			while (itr.hasNext())                 
			{  
				
			Row row = itr.next();  
			Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
			while (cellIterator.hasNext())   
			{  
			Cell cell =(Cell) cellIterator.next();
			
			switch (cell.getCellType())               
			{  
			case STRING:    //field that represents string cell type  
			System.out.print(cell.getStringCellValue() + "\t");  
			break;  
			case NUMERIC:    //field that represents number cell type  
			System.out.print(String.format("%.0f", cell.getNumericCellValue()) + "\t");  
			break;  
			default:  
			}  
			}  
			System.out.println("\t\t");  
			}  
		  }catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
	  }
	 
	   public void readRecord(int id) {
		   
		// to return to the called method to know whether result is fetched or not
				
			
				 try {
						FileInputStream fis=new FileInputStream(new File("D:\\\\New folder\\\\Bank_administration\\\\excel\\\\Customer.xlsx"));
						XSSFWorkbook wb=new XSSFWorkbook(fis);
						XSSFSheet sheet=wb.getSheetAt(0);
						
						
						for(Row row:sheet) {
							if(row.getRowNum()>0) {
							if(row.getCell(0).getNumericCellValue()==id)
							{
								
								
								Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
								while (cellIterator.hasNext())   
								{  
								Cell cell =(Cell) cellIterator.next();
								
								switch (cell.getCellType())               
								{  
								case STRING:    //field that represents string cell type  
								System.out.print(cell.getStringCellValue() + "\t");  
								break;  
								case NUMERIC:    //field that represents number cell type  
								System.out.print(String.format("%.0f", cell.getNumericCellValue()) + "\t");  
								break;  
								default:  
								}  
								}  
								System.out.println("\t\t");  
								}  
				
					  }}}catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
		  
				  }
		 
	
}


