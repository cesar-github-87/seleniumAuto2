package TestNG;

import org.testng.annotations.Test;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.*;
import java.time.Duration;

public class TestNGTestCase2 {
	
	WebDriver driver;
	WebDriverWait elemWait;  
	
    @Test(priority=1)
	void openNav() {
		
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://www.gibson.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='allCookies']")).click();
		
	}
	
	@Test(priority=2)
	void writeSearch() {
		
		
		driver.findElement(By.xpath("//a[@aria-label='Search']//*[name()='svg']")).click();
		WebElement searchBar = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchBar.sendKeys("Les Paul");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		searchBar.sendKeys(Keys.ENTER);
	
	}
	
	@Test(priority=3)
	void clickOption() {
		elemWait = new WebDriverWait(driver, Duration.ofSeconds(45));
		elemWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wps-overlay-close-button")));
		driver.findElement(By.id("wps-overlay-close-button")).click();
		WebElement header = driver.findElement(By.className("common-wrapper"));
		new Actions(driver).moveToElement(header);
		header.click();
		
		WebElement guitarra = driver.findElement(By.cssSelector("img[src=\"//images.ctfassets.net/m8onsx4mm13s/FlismlnuH62UIWkMajohC/cd7889925519a76123e4231fbdad417b/LPSU3P00EBGH1_500x500.png?fit=fill&w=250&h=500\"]"));
		guitarra.click();
	}
	
}
