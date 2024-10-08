package webDriverMethods;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeyboardTabsWindowsHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://text-compare.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("el texto del area");
		
		Actions act = new Actions(driver);
		
		//CNTRL +  A PRESS AND RELEASE         
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		
	
		
		//CNTRL +  C PRESS AND RELEASE     
		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();		
		
		//WebElement txtarea2 = driver.findElement(By.xpath("//textarea[@id='inputText2']"));	
		//txtarea2.click();
		
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();		
		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();	
		
		Thread.sleep(4000);
		
		
		//HACER QUE AL DAR CLIC ALGO QUE COMUNMENTE SE ABRE EN LA MISMA PESTANA, SE ABRA EN UNA NUEVA
		driver.get("https://gibson.com");	
		Thread.sleep(4000);
	
		
	
		driver.findElement(By.xpath("//button[@id='allCookies']")).click();
		Thread.sleep(4000);
		
		
		WebElement login = driver.findElement(By.xpath("//a[@class='nav-text']"));
		act.keyDown(Keys.CONTROL).click(login).keyUp(Keys.CONTROL).perform();
		
		
		
		Set<String> tabs = driver.getWindowHandles();
		
		List<String> tabIds = new ArrayList<String>(tabs);
		String parentId = tabIds.get(0);
		String childId = tabIds.get(1);
		
		Thread.sleep(3000);
		driver.switchTo().window(childId);
		
		driver.switchTo().newWindow(WindowType.TAB);//Me abre una nueva tab vacia y se mueve automaticamente a ella.
		driver.get("https://testautomationpractice.blogspot.com/");
		
		List<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		
		for(String ids:tabs2) {
			
			driver.switchTo().window(ids);
			System.out.println(driver.getTitle());		
		}
		
	 }

}
