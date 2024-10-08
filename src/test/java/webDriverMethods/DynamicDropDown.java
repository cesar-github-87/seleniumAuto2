package webDriverMethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown {

	public static void main(String[] args) throws InterruptedException {
	     WebDriver driver = new ChromeDriver();
	     driver.get("http://google.com");
	     driver.manage().window().maximize();
	     
	     
	     
	     driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Gibson");
	     Thread.sleep(3000);	     
	     
	     List <WebElement> listOp = driver.findElements(By.xpath("//ul[@role='listbox']//div[@role='option']"));
	     
	     for(WebElement lista:listOp) {
	    	 System.out.println("Mi lista tiene:" + lista.getText());
	     }
	     

	}

}
