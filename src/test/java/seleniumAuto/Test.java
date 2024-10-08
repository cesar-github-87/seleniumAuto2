package seleniumAuto;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Test {

	public static void main(String[] args) {
		//ChromeDriver driver = new ChromeDriver();
		WebDriver driver = new EdgeDriver();
		driver.get ("https://www.mercadolibre.com.mx/");
		
		driver.manage().window().maximize(); //MAXIMIZAR LA VENTANA
		
		String titulo = driver.getTitle(); //Es el titulo del TAB del navegador
		
		
		WebElement searchBar = driver.findElement(By.id("cb1-edit"));
		WebElement searchButton = driver.findElement(By.className("nav-search-btn"));
		
		//SABER SI UN ELEMENTO PARTICULAR ESTA SIENDO DESPLEGADO POR EJEMPLO UNA IMAGEN
		List<WebElement> imagen = driver.findElements(By.ByTagName.name("img"));
		System.out.println("Esta es la cantidad de iamgenes en la pagina: "+ imagen.size());
		
		
	   // searchBar.sendKeys("PRS SE"); //Escribe en el campo WebElement searchBar
	   
	    String idBoton =  searchButton.getAttribute("type");
	    System.out.println("Este es el atributo type del boton: "+ idBoton);
	    
	    //Voy a dar click en un texto con link (LINKTEXT)
	    
	  //  driver.findElement(By.linkText("Ofertas")).click();
	    
	    //buscar elementos que sean de un mismo tipo
	    List<WebElement> headerLinks = driver.findElements(By.className("nav-menu-item"));
	    System.out.println("Cantidad de links de header: "+headerLinks.size());
	    System.out.println("Links de header listados:");
	    for(int i=0; i<headerLinks.size() ; i++) {
	    	System.out.println(i+1 + ". "+ headerLinks.get(i).getText());
	    }
	    
	    
	    //------------------------------------LOCATORS CON CSS------------------------------
	    //En paginas complejas, es posible que  
	    System.out.println("-------------LOCATORS CON CSS-------------------------------");
	    System.out.println("tag id:   tag#id"); 
	   
	   	   
	    System.out.println("Este es el atributo name del componente id=cb1-edit usando css locator (tag#id): " + driver.findElement(By.cssSelector("input#cb1-edit")).getClass());
	   
	    System.out.println("mismo atributo name del mismo componente, pero sin usar tag (--#id): "  + driver.findElement(By.cssSelector("#cb1-edit")).getClass());
	    System.out.println("_________________");
	    System.out.println("tag class:   tag.classname"); 
	    System.out.println("Este es el atributo ID del componente id=cb1-edit usando css locator (tag.classname): " + driver.findElement(By.cssSelector("input.nav-search-input")).getDomAttribute("id"));		   
	    System.out.println("mismo atributo ID del mismo componente, pero sin usar tag (--.id): "  + driver.findElement(By.cssSelector(".nav-search-input")).getDomAttribute("id"));
	    System.out.println("_________________");
	    System.out.println("tag attribute:   tag.[attribute='value']"); 
	    System.out.println("Este es el atributo ID del componente id=cb1-edit usando css locator (tag.[attribute='value']): " + driver.findElement(By.cssSelector("input[aria-controls='cb1-list']")).getDomAttribute("id"));		   
	    System.out.println("mismo atributo ID del mismo componente, pero sin usar tag (--[attribute='value']): "  + driver.findElement(By.cssSelector("[aria-controls='cb1-list']")).getDomAttribute("id"));

		//System.out.println(titulo);
		/*
		if(titulo.equals("Mercado Libre México - Envíos Gratis en el día")) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}*/
		//driver.close();
	    
	    
	    System.out.println("-------------XPATH-------------------------------");
	    
	    //XPATH es una direccion del elemento
	    // DOM Document Object Model
	    
	    //DOS TIPOS DE XPATH: FULL Y PARTIAL
	    
	    System.out.println("Escribir en barra usando XPATH con atributo sencillo: //tagname[@attribute = 'value']  //input[@id='cb1-edit'] "  );
	    driver.findElement(By.xpath("//input[@id='cb1-edit']")).sendKeys("PRS SE");
	    
	    System.out.println("Localizar usando XPATH con varios atributos: //tagname[@attribute = 'value'][@attribute = 'value']  //input[@id='cb1-edit'] "  );
	    System.out.println("Localizar usando XPATH con AND/OR en atributos: //tagname[@attribute = 'value and @attribute = 'value']  //input[@id='cb1-edit'] "  );
	    System.out.println("Localizar usando XPATH con linked text: //tag[text() = 'TEXTO']  //tag[@text()='Top Descuentos'] "  );
	    
	   boolean desplegado = driver.findElement(By.xpath("//h3[text()='Top descuentos']")).isDisplayed();
	   System.out.println(desplegado);
	   System.out.println (driver.findElement(By.xpath("//h3[text()='Top descuentos']")).getText());
	//   driver.findElement(By.xpath("//h3[text()='Top descuentos']")).click();
	   

	}

}
