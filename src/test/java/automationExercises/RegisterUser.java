package automationExercises;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/*
 * 
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
 */



public class RegisterUser {
	
	WebDriver driver;
	WebDriverWait elemWait;  
	
  @BeforeClass
  public void launchBrowser() {
	  driver = new ChromeDriver();
	  driver.get("http://automationexercise.com");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	  driver.manage().window().maximize();
  }
  
  
  @Test(priority = 1)
  public void isPageVisible() {
	 
	  if (driver.findElement(By.xpath("//div[@class='header-middle']")).isDisplayed()) {
		  Assert.assertTrue(true);
	  }
	  else {
		  Assert.assertTrue(false);
	  }
  }
  
  @Test(priority=2, dependsOnMethods= {"isPageVisible"})
  public void isNewUserSignupVisible() {
	  driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	  
	  if(driver.findElement(By.xpath("//div[@class='signup-form']")).isDisplayed()) {
		  Assert.assertTrue(true);
	  }else {
		  Assert.assertTrue(false);
	  }
	  
	  driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("CesarB");
	  driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("cesar@mail.com");
	  
  }
  
 /* public void fillNewUserSignup() {
	  driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("CesarB");
	  driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("cesar@mail.com");

  }
  
  */
  
}
