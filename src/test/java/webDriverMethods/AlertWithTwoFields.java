package webDriverMethods;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertWithTwoFields {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		
		//se le tiene que hacer un bypass a la alerta de JS sabiendo cual es el user y pswd:
		//   http://user:pswd@url.com
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		//WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10)); //Una manera de hacer un WAIT involucrando al DRIVER
		
		driver.manage().window().maximize();
		
		 
		
		//Alert myAlert = myWait.until(ExpectedConditions.alertIsPresent()); //Otra manera de dar el foco a un Alert en lugar de usar el SwitchTO es con un wait.
		//myAlert.accept();
		
	}

}
