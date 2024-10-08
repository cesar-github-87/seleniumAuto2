package webDriverMethods;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTestExcel {

	public static void main(String[] args) throws IOException {
		// FileINputStream class: reading file
		// FileOUtputStream class: writing file
		
		// Excel File --> Excel Workbook --> Sheets --> Row --> Cells
		
		FileInputStream excelFile = new FileInputStream("C:\\Users\\cesar\\eclipse-workspace\\seleniumAuto\\testdata\\datatest.xlsx");
		
		XSSFWorkbook workbook =  new XSSFWorkbook(excelFile);
		XSSFSheet sheet = workbook.getSheet("Sheet2");
		
		int totalRows = sheet.getLastRowNum();
		int totalCells = sheet.getRow(0).getLastCellNum();
		
		System.out.println("Numero de Lineas "+ totalRows);//5 comienza el conteo desde 0
		System.out.println("Numero de Celdas "+ totalCells);//4 comienz el conteo desde 1
		
		//System.out.println(sheet.getRow(4).getCell(3));
		
		for(int r=0;r<=totalRows;r++) {
			for(int c=0;c<totalCells;c++) {
				System.out.print(sheet.getRow(r).getCell(c) + "\t\t");
				
			}
			System.out.println();
		}
		workbook.close(); 
		excelFile.close();
//
		
		//VOY A CREAR UN ARCHIVO.
		

	    //fghfdhdfghdgfhdfghdfghdfghdfgh
		//VOY A CREAR UN ARCHIVO.ghyjghjkghjh
		//dfhdfghfdghdfghfdghdfghfgdhfgdhfdgh


		
		XSSFWorkbook newWorkbook =  new XSSFWorkbook();
		XSSFSheet newSheet = newWorkbook.createSheet("Guitarras");
		
		XSSFRow row = newSheet.createRow(0);
		row.createCell(0).setCellValue("Marca");
		row.createCell(1).setCellValue("Color");
		row.createCell(2).setCellValue("Precio");
		row.createCell(3).setCellValue("Disponible");
		
		
		XSSFRow row2 = newSheet.createRow(1);
		row2.createCell(0).setCellValue("Fender");
		row2.createCell(1).setCellValue("Sunburst");
		row2.createCell(2).setCellValue(2500);
		row2.createCell(3).setCellValue("In Stock");
		

		XSSFRow row3 = newSheet.createRow(2);
		row3.createCell(0).setCellValue("Gibson");
		row3.createCell(1).setCellValue("Custom Ebony");
		row3.createCell(2).setCellValue(4500);
		row3.createCell(3).setCellValue("Out of Stock");
		
		FileOutputStream createdFile = new FileOutputStream("C:\\Users\\cesar\\eclipse-workspace\\seleniumAuto\\testdata\\CreatedDatatest.xlsx");
		newWorkbook.write(createdFile);
		newWorkbook.close();
		createdFile.close();
		
	
		
	}

}
