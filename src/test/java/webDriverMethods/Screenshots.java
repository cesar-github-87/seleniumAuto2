package webDriverMethods;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Screenshots {

	public static void main(String[] args) {
		
		
		//HEADLESS TESTING PERMITE CORRER TEST CASES SIN NECESIDAD DE TENER EL NAVEGADOR ABIERTO
		//SE CORREN EN EL BACKGRORUND
		//SE TIENE QUE USAR CLASE ChromeOptions ANTES DE CREAR EL DRIVER
		
		ChromeOptions chromeOpt = new ChromeOptions();	
		//chromeOpt.addArguments("--headless=new"); //
		chromeOpt.addArguments("--incognito");
		
		
		WebDriver driver = new ChromeDriver(chromeOpt);
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		// 1) Full page screenshot
		
		TakesScreenshot scr = (TakesScreenshot)driver;
		/*
		File sourceFile = scr.getScreenshotAs(OutputType.FILE); //se guarda el screenshot en algun lugar en memoria
		File file = new File ("C:\\Users\\cesar\\OneDrive\\Documentos\\Selenium Course\\Screenshots\\fullpage.png"); //aqui estamos creando un archivo imagen aun sin nada en el path
		sourceFile.renameTo(file); //mi archivo en memoria se asigna al archivo en mi path
		
		*/
		
		
		
		
		//2) Screenshot de un elemento en particular USANDO la interface DESDE EL WEBELEMENT 		
		//NO SE USA LA INTERFACE TakesScreenshot!!!!!!!!.
		
		driver.get("https://guitargear.com.mx");
		
		System.out.println(driver.getTitle());
		
		WebElement banner = driver.findElement(By.xpath("//div[@class='ath_extb__item__text_and_bg__cover']"));
		
		File source2 = banner.getScreenshotAs(OutputType.FILE);
		File file2 = new File ("C:\\Users\\cesar\\OneDrive\\Documentos\\Selenium Course\\Screenshots\\element.png");
		source2.renameTo(file2);
		
	}

}
