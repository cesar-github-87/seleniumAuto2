package webDriverMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBoxAndRadioButtons {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.fender.com");
		driver.manage().window().maximize();
		
		Thread.sleep(8000); //PONGO ESTE SLEEP PORQUE EL JAVASCRIPT ESTA EJECUTANDOSE ANTES DE QUE SE DESPLIEGUE EL ELEMENTO Y DE OTRA MANERA MARCA ERROR
		JavascriptExecutor jse = (JavascriptExecutor)driver;	
		WebElement acceptCookies = (WebElement)jse.executeScript("return document.querySelector(\"#usercentrics-root\").shadowRoot.querySelector(\"#focus-lock-id > div > div > div.sc-eBMEME.dRvQzh > div > div > div.sc-jsJBEP.iXSECa > div > button:nth-child(4)\")");	
		jse.executeScript("arguments[0].click();", acceptCookies);
		
		
		//espera de un elemento
		WebDriverWait elemWait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Si la condicion de espera del elemento no se cumple durante este tiempo, se manda una excepcion.
		WebElement menuSquire = driver.findElement(By.xpath("//li[@id='header-main-flyouts-squier']//a[@class='global-header-mobile__links global-header__link']"));
		
		Actions action =  new Actions(driver);
		
		action.moveToElement(menuSquire).perform();
		
		
		WebElement waitbotonSquStrat =  elemWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://www.fender.com/en/squier-electric-guitars/stratocaster/']")));		
		waitbotonSquStrat.click();
		
		WebElement waitAffinCheckBox = elemWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='Boolean-FilterCheckbox-Affinity Series™']")));
		waitAffinCheckBox.click();
		Thread.sleep(3000);
		WebElement waitSonicChekBox = elemWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='Boolean-FilterCheckbox-Squier Sonic®']")));
		
		waitSonicChekBox.click();
		Thread.sleep(3000);
		
		System.out.println("Affinity selected= "+ driver.findElement(By.xpath("//label[@for='Boolean-FilterCheckbox-Affinity Series™']")).getCssValue("background-color"));		
		System.out.println("Sonic selected= " + driver.findElement(By.xpath("//label[@for='Boolean-FilterCheckbox-Squier Sonic®']")).isSelected());
	
	
	}
	

}
