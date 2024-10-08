package webDriverMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMS {

	public static void main(String[] args) throws InterruptedException {
		
		
		//SHADOW HOST CONTIENE AL SHADOW ROOT QUE CONTIENE AL SHADOW ELEMENT
		//XPATH NO PUEDE ENCONTRAR LOS SHADOW ELEMENTS
		//SE PUEDE USAR CSS LOCATOR
		//SelectorHubs nos da el CSS correspondiente
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));		
		driver.manage().window().maximize();
		driver.get("http://www.fender.com");	
	
		
		//This Element is inside single shadow DOM.

		SearchContext shadow = driver.findElement(By.cssSelector("#usercentrics-root")).getShadowRoot();
		Thread.sleep(15000);
		WebElement acceptCookies = shadow.findElement(By.cssSelector(" div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(4)"));
		acceptCookies.click();
		
		driver.findElement(By.xpath("//span[@class='main-menu-title'][normalize-space()='Beginners']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.xpath("//div[@class='left-menu']//a[@title='Fender Home']//*[name()='svg']")).click();
		
		
		//Los SVGs no se pueden acceder de manera convensional.
		//name() es un atributo 
		
		//div[@class='left-menu']//a[@title='Fender Home']//*[name()='svg']
		//div[@class='NewHomeHeader-styled__MobileLeftWrapper-sc-1wyoeaj-6 fMTfeQ']//*[name()='svg']
		
		
		
		
	}

}
