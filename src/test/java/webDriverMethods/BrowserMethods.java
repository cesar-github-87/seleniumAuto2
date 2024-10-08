package webDriverMethods;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.*;


public class BrowserMethods {

	public static void main(String[] args) throws InterruptedException {
		
	WebDriver driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	driver.manage().window().maximize();
	driver.get("http://www.fender.com");
	
	
	/*EL ELEMENTO QUE BUSCO (BOTON DE COOKIES), SE ENCUENTRA DENTRO DE UN "SHADOWDOM" POR LO TANTO NO PUEDO ACCEDER A EL DE MANERA CONVENCIONAL USANDO
	 * METODO findElement DE SELENIUM
	 * PARA SOLUCIONAR ESTO SE DEBE DE HACER USO DE JAVASCRIPT:
	 * BUSCO EL ELEMENTO EN EL DOM, ME ASEGURO QUE ESTÉ EN UN SHADOW DOM Y COPIO SU JS PATH
	 * 
	 * (LINEA 34) SE CREA UN Javascriptexecutor CASTEADO A MI DRIVER 
	 * (LINEA 35) CREO UN WEB ELEMENT QUE SEA ENCONTRADO USANDO EL JSPATH DEL ELEMENTO 
	 * (LINEA 36) AL EXECUTOR LE PASO LOS ARGUMENTOS DE JAVASCRIPT NECESARIOS, EN ESTE CASO ES UN CLICK
	 * */
	
	//This Element is inside single shadow DOM.

	SearchContext shadow = driver.findElement(By.cssSelector("#usercentrics-root")).getShadowRoot();
	Thread.sleep(15000);
	WebElement acceptCookies = shadow.findElement(By.cssSelector(" div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(4)"));
	acceptCookies.click();
	/*
	Thread.sleep(15000); //PONGO ESTE SLEEP PORQUE EL JAVASCRIPT ESTA EJECUTANDOSE ANTES DE QUE SE DESPLIEGUE EL ELEMENTO Y DE OTRA MANERA MARCA ERROR
	JavascriptExecutor jse = (JavascriptExecutor)driver;	
	WebElement acceptCookies = (WebElement)jse.executeScript("return document.querySelector(\"#usercentrics-root\").shadowRoot.querySelector(\"#focus-lock-id > div > div > div.sc-eBMEME.dRvQzh > div > div > div.sc-jsJBEP.iXSECa > div > button:nth-child(4)\")");	
	jse.executeScript("arguments[0].click();", acceptCookies);
	
	*/
	driver.findElement(By.linkText("Newsroom")).click();
	
	Set<String> windowsIDs = driver.getWindowHandles(); //OBTENER Y GUARDAR EN UN SET TODOS LOS IDS DE LOS TAS ABIERTOS
	
	//quiero saber cuales son los IDs de las pestañas abiertas convirtiendo el Set en una array LIST
	
	/********************************************************************************************************************************/
	System.out.println("**************USANDO EL METODO DE CREAR LISTAS*****************");
	List<String> windowsList = new ArrayList<String>(windowsIDs);
	
	String parentID =windowsList.get(0); //este medodo GET obtiene el ID del elemento de la lista, en este caso es el ID del tab padre.
	String childID = windowsList.get(1);
	 
	
	//EN ESTE CASO EL DRIVER SIEMPRE SE QUEDA EN EL TAB PADRE A PESAR DE QUE SE HAYA ABIERTO UN TAB NUEVO
	System.out.println("El driver permance en el tab padre aunque se haya abierto un  tab nuevo");
	System.out.println("Titulo del tab donde esta el driver: " + driver.getTitle() + "ID del padre: " + parentID);
	
	//ME MUEVO AL TAB HIJO	
	driver.switchTo().window(childID);	
	System.out.println("Titulo del tab donde esta el driver: " + driver.getTitle() + "ID del hijo: " + childID);
/************************************************************************************************************************************/	
	System.out.println("\n ********************USANDO CICLO FOR***********************");
	for(String winID:windowsIDs) {
		driver.switchTo().window(winID);
		System.out.println("Driver titulo: "+ driver.getTitle() + "ID: "+ driver.getWindowHandle());
	}
	
	
	
	
/*
 * 
 * WebElement element = driver.findElement(By.id("gbqfd"));
JavascriptExecutor executor = (JavascriptExecutor)driver;
js.executeScript("arguments[0].click();", acceptCookies);
 * 
 * 
 * */
 

	}

}
//This element is in shadowDOM - div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > button:nth-child(1)