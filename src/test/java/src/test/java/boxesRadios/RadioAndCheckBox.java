
package boxesRadios;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class RadioAndCheckBox {

	public static void main(String[] args) {
		
	WebDriver driver = new EdgeDriver();
	driver.get("http://www.gibson.com");
	driver.manage().window().maximize();
	
	
	
	//new Actions(driver).moveToElement(header);
	
	WebDriverWait elemWait = new WebDriverWait(driver, Duration.ofSeconds(45)); // Si la condicion de espera del elemento no se cumple durante este tiempo, se manda una excepcion.
	//La condición tiene prioridad sobre este tiempo.
	
	driver.findElement(By.xpath("//button[@id='allCookies']")).click();
	driver.findElement(By.xpath("//a[@aria-label='Search']//*[name()='svg']")).click();
	driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Les Paul");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	
	driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(Keys.RETURN);
	
	//System.out.println("Antes de esperar" + driver.findElement(By.xpath("//input[@id='chk-brand-Epiphone']")).isDisplayed());
	
	
	//espero a que un elemento de lso que correspondan a un chkbox de filtro por xpath sea desplegado
	WebElement waitForFilters = elemWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='chk-brand-Epiphone']")));
	//
	
	//aqui me espero hasta que aparezca el pop up que me estorba
	//cierro el popup web que me estorba
	// como di clic me esta dejando el cursor en un menu que se despliega en hover. necesito cerrarlo
	elemWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wps-overlay-close-button")));
	driver.findElement(By.id("wps-overlay-close-button")).click(); 
	WebElement header = driver.findElement(By.className("common-wrapper"));
	new Actions(driver).moveToElement(header);
	header.click();
	
	
	driver.switchTo().alert().dismiss();
	
	//driver.findElement(By.className("common-wrapper d-flex align-items-center"))
	
	
	//encuentra todos los checkboxes que sean para filtro
	List<WebElement> filterBoxes = driver.findElements(By.className("chk-product-filter")); 
    System.out.println("Despues de esperar: " + waitForFilters.isDisplayed());
    
    driver.findElement(By.id("chk-brand-Gibson")).click();
    System.out.println("Existen " + filterBoxes.size() + " que son para filtros");
    //Le va a dar clic a todos los testBoxes de filtro. Se deseleciona el de Gibson porque previamente estaba ya seleccionado.
   
  /*  for (int i = 0; i<= filterBoxes.size();i++) {
    	System.out.println("ID del "+filterBoxes.get(i).getAttribute("id"));
    	filterBoxes.get(i).click();
    	
    }*/
    //MODO OPTIMIZADO PARA UN FOR Y HACER CLICK EN TODOS LOS ELEMENTOS
    for (WebElement chkbx: filterBoxes) { // se crea una variable del mismo tipo del tipo de elemento que quiero recorrer.
    	chkbx.click();
    }
    
    
    
	}
	
}
