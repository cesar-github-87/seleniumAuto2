package webDriverMethods;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
	public static int getRowCount (String xlsFile, String xlsSheet) throws IOException {
		
		 fi = new FileInputStream(xlsFile);
		 wb = new XSSFWorkbook(fi);
		 sh = wb.getSheet(xlsSheet);
		 
		 int rowCount = sh.getLastRowNum();
		 
		 wb.close();
		 fi.close();
		
		return rowCount;
		
	}
	
	public static int getCellCount (String xlsFile, String xlsSheet, int rowNumber) throws IOException {
		
		 fi = new FileInputStream(xlsFile);
		 wb = new XSSFWorkbook(fi);
		 sh = wb.getSheet(xlsSheet);
		 row = sh.getRow(rowNumber);
		 
		 int cellCount = row.getLastCellNum();
		 
		 wb.close();
		 fi.close();
		
		return cellCount;
		
	}
	
	public static String getCellData (String xlsFile, String xlsSheet, int rowNum, int cellNum) throws IOException {
		
		 fi = new FileInputStream(xlsFile);
		 wb = new XSSFWorkbook(fi);
		 sh = wb.getSheet(xlsSheet);
		 row = sh.getRow(rowNum);
		 cell = row.getCell(cellNum);
		 
		 
		 String cellData;
		 
		 try {
			//cellData = cell.toString();
			 DataFormatter formatter = new DataFormatter();
			 cellData = formatter.formatCellValue(cell);//Regresa el valor convertido a string SIN IMPORTAR EL FORMATO DE LA CELDA
			 
			 
		 }
		 catch (Exception e){
			 cellData = "";
		 }
		 
		 wb.close();
		 fi.close();
		
		return cellData;
		
	}
	
	public static void setCellData (String xlsFile, String xlsSheet, int rowNum, int cellNum, String data) throws IOException {
		
		 fi = new FileInputStream(xlsFile);
		 wb = new XSSFWorkbook(fi);
		 sh = wb.getSheet(xlsSheet);
		 row = sh.getRow(rowNum);
		 
		 cell = row.createCell(cellNum);
		 cell.setCellValue(data);
		 
		 fo = new FileOutputStream(xlsFile);
		 wb.write(fo);
		 
		 wb.close();
		 fi.close();
		 fo.close();
		 
		 
	}


}
