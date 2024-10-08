package webDriverMethods;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
public class WebTables {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//numero de lineas de la tabla, buscamos la cantidad de tr dentro de la tabla
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("Numero de lineas en la tabla: "+rows);
		
		//numero de columnas
		int columns =  driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("numero de Columnas: "+columns);
		
		//Encontrar el elemento que este en la Segunda Linea y Tercera columna
		System.out.println (driver.findElement(By.xpath("//table[@name='BookTable']//tr[2]//td[3]")).getText());
	
		//leer todos los datos de todas las columnas y filas
		for(int f=2; f<=rows;f++){
			for(int c=2; c<=columns; c++) {
				System.out.println("Elemento en fila ["+f+"],columna ["+c+"]:"+ driver.findElement(By.xpath("//table[@name='BookTable']//tr["+f+"]//td["+c+"]")).getText());
			}
		}
		
		//Libros escritos por un autor en particular
		for(int f=2; f<=rows;f++){
			String autor = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+f+"]//td[2]")).getText();
			if(autor.equals("Mukesh")) {							
					System.out.println("Libro: "+ driver.findElement(By.xpath("//table[@name='BookTable']//tr["+f+"]//td[1]")).getText());				
				
			}
		}
		
		
		//Todos los precios
		for(int f=2; f<=rows;f++){
				List<WebElement>precios = driver.findElements(By.xpath("//table[@name='BookTable']//tr["+f+"]//td[4]"));
				for(WebElement pre:precios) {
					System.out.println(pre.getText());
				}
		}
		

	}

}
