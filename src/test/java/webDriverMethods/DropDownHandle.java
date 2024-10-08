package webDriverMethods;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandle {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com");
		driver.manage().window().maximize();
		
		
		//encontrar dropdown normal tipo SELECT
		WebElement dropPais = driver.findElement(By.xpath("//select[@id='country']"));
		
		//se crea un objeto tipo Select
		Select dropPaisOption = new Select(dropPais);
		
		List<WebElement> listaDisponible = dropPaisOption.getOptions();
		for(int i = 0; i<= listaDisponible.size();i++) {
			System.out.println(i + listaDisponible.get(i).getText());
			
		}
		
		//System.out.println("Las opciones disponibles son: " + listaDisponible);
		//dropPaisOption.g
		dropPaisOption.selectByValue("france");
		
		

	}

}
