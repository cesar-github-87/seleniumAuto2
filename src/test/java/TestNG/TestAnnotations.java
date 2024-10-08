package TestNG;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestAnnotations {
	WebDriver driver;
	
  @Test
  public void openPage() {
	  driver = new EdgeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://fender.com");
	  
  }
}
