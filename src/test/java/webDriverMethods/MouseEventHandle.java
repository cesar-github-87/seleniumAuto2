package webDriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;


public class MouseEventHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		//CREAR UNA ACTION
		Actions mouse = new Actions(driver);
		
		
		WebElement dragable = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement droppable = driver.findElement(By.xpath("//div[@id='droppable']"));//div[@id='droppable']
		WebElement dragBar = driver.findElement(By.xpath("//div[@id='slider']//span"));
		
		System.out.println("Posicion de la barra: "+ dragBar.getLocation());
		Thread.sleep(2000);
		
		mouse.dragAndDropBy(dragBar, 157, 0).perform(); //157 ~ 50% 
		
		System.out.println("NUEVA Posicion de la barra: "+ dragBar.getLocation());
		System.out.println("Porcentaje actualizado: "+ dragBar.getAttribute("style"));
		
		Thread.sleep(2000);
		
		mouse.dragAndDropBy(dragBar, 79, 0).perform(); //157 ~ 50% 
		
		System.out.println("FINAL Posicion de la barra: "+ dragBar.getLocation());
		System.out.println("Porcentaje FINAL: "+ dragBar.getAttribute("style"));

		mouse.dragAndDrop(dragable, droppable).perform();
		
		WebElement box1 = driver.findElement(By.id("field1"));
		WebElement box2 = driver.findElement(By.id("field2"));
		WebElement copyButtom = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		
		box1.clear();
		box1.sendKeys("Cosa nueva");
		
		System.out.println("Primer texto: " + box1.getText());
		System.out.println("Primer value: " + box1.getAttribute("value"));
		
		mouse.doubleClick(copyButtom).perform();
		
	/*	if(box1.getText().equals(box2.getText())) {
			System.out.println("COPIADO CORRECTAMENTE");
		
		}*/
		
		System.out.println("Segundo texto: " + box2.getText());
		System.out.println("Segundo value: " + box2.getAttribute("value"));
		
	}
		
	
	}


