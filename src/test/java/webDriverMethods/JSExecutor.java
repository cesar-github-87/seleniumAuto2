package webDriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSExecutor {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement nombre = driver.findElement(By.xpath("//input[@id='name']"));
		
		nombre.sendKeys("Cesar barragan");
		
		//Se hace un casting para que la interface pueda ser usada
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		js.executeScript("arguments[0].setAttribute('value','cesar.bhg87@gmail.com')", email);
		
		//PARA HACER SCROLL ESPECIFICANDO LA POSICION
		
		js.executeScript("window.scrollBy(0,300)", "");
		System.out.println ("Width: " + js.executeScript("return window.innerWidth;") +" Height: " + js.executeScript("return window.innerHeight;"));
		System.out.println("El scroll esta en: " + js.executeScript("return window.pageYOffset;"));
		
		
		//PARA HACER SCROLL TOMANDO LA REFERENCIA DE POSICION DE UN ELEMENTO
		Thread.sleep(4000);
		WebElement paginator = driver.findElement(By.xpath("//select[@id='country']"));
		js.executeScript("arguments[0].scrollIntoView();", paginator);
		System.out.println("El scroll esta en: " + js.executeScript("return window.pageYOffset;"));
		
		
		
		//PARA HACER SCROLL HASTA EL FINAL DE LA PAGINA
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println("El scroll esta en: " + js.executeScript("return window.pageYOffset;"));
		
		
		//PARA HACER SCROLL HASTA EL INICIO DE LA PAGINA USANDO EL WINDOW.SCROLLBY
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println("El scroll esta en: " + js.executeScript("return window.pageYOffset;"));
		
		
		//PARA HACER ZOOM
		js.executeScript("document.body.style.zoom='50%'");
	}

}
