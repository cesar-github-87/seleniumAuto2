package webDriverMethods;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertHandle {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver ();
		WebDriver driver2 = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");		
		driver.manage().window().maximize();
		
		
		//Doy click al primer boton de alerta con un accept (OK)
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();	
		
		//ALERTA CON UN BOTON ACCEPT
		Alert myAlert = driver.switchTo().alert();
		Thread.sleep(3000);
		myAlert.accept();
		
		
		
		//Doy click al boton de alerta con confirmacion (OK/CANCEL)
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		
		
		//Doy click al boton de alerta con campo de TEXTO (OK/CANCEL)
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(3000);
		System.out.println("El texto es: " + driver.switchTo().alert().getText());
		driver.switchTo().alert().sendKeys("Es mi ejemplo");
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
	//	driver.switchTo().alert().
		
		
//add this comment just to check on git 
	}

}
