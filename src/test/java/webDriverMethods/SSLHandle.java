package webDriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLHandle {

	public static void main(String[] args) {
		
		
		ChromeOptions chromeOpt = new ChromeOptions();
		chromeOpt.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver(chromeOpt);
		driver.get("https://expired.badssl.com");
		
		
		

	}

}
