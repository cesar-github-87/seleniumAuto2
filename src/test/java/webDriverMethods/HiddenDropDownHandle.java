package webDriverMethods;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

public class HiddenDropDownHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
		driver.manage().window().maximize();
		
		Thread.sleep(4000);
		
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		Thread.sleep(4000);
		//driver.findElement(By.xpath("//span[normalize-space() = 'PIM'])")).click();
		
		//CUANDO LOS ELEMENTOS DE UN DROPDOWN NO SON VISIBLES PUEDO HACER USO DEL SELECTORS HUB
		/* 	1. DOY CLIC EN EL BOTON DE DEBUG DEL SELECTORSHUB
		 *  2. ANTES DE 5s TENGO QUE DAR CLIC EN EL DROPDOWN QUE NECESITO QUE SE DESPLIEGUE 
		 *  3. SE CONGELA LA NAVEGACION Y EN EL NAVEGADOR DE CODIGO ME VOY A 'ELEMENTS' Y YA PUEDO VER LAS OPCIONES ANTES OCULTAS
		 */

		//Clic en el dropdown
		
		driver.findElement(By.xpath("//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='oxd-table-filter']/div[@class='oxd-table-filter-area']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[6]/div[1]/div[2]/div[1]/div[1]")).click();
		
		//clic en el elmento antes oculto
		//driver.findElement(By.xpath("//span[normalize-space()='Chief Financial Officer']")).click();
		
		
		
		//contar numero de opciones se puede hacer usando un xpath generico
		Thread.sleep(4000);
		List<WebElement> hiddenItems = driver.findElements(By.xpath("//div[@role='listbox']//span"));
		
		System.out.println (hiddenItems.size());
		
		for(WebElement listOp:hiddenItems) {
			System.out.println(listOp.getText());
			
		}
		
	}

}
