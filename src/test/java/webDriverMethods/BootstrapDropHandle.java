package webDriverMethods;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;


public class BootstrapDropHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		
		driver.manage().window().maximize();
		
		WebElement bootsTrap = driver.findElement(By.xpath("//button[contains(@class,'multiselect')]"));
		
		bootsTrap.click();
		
		Thread.sleep(3000);
		//selecciono una sola opcion
		driver.findElement(By.xpath("//input[@value='Angular']")).click();

		//para seleccionar todas o varias opciones y saber cuantas son
		
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
		System.out.println("Tamano de las opciones: "+ options.size());
		
		
		/*for(int i=0;i<options.size();i++) {
			
			String sOption = options.get(i).getText();
			System.out.println("Contenido: "+ options.get(i).getText()); 
			if(sOption.equals("Java") || sOption.equals("Python")) {
				options.get(i).click();
			}
		}*/
			/****FOR MEJORADO*****/
			
		
		for (WebElement opt:options) {
			String opText = opt.getText();
			System.out.println (opText);
			if (opText.equals("MySQL") || opText.equals("Oracle")) {
				opt.click();
			}
		}
			
		
	}

}
