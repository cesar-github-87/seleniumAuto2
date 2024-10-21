package webDriverMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@id='wzrk-cancel']")).click();
		
		WebElement principal = driver.findElement(By.xpath("//input[@id='principal']"));
		WebElement rate = driver.findElement(By.xpath("//input[@id='interest']"));
		WebElement periodVal = driver.findElement(By.xpath("//input[@id='tenure']"));
		WebElement period = driver.findElement(By.xpath("//select[@id='tenurePeriod']"));
		WebElement frequency = driver.findElement(By.xpath("//select[@id='frequency']"));
		WebElement calculateBtn = driver.findElement(By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']"));
		WebElement clearBtn = driver.findElement(By.xpath("//img[@class='PL5']"));
		
		String filePath = System.getProperty("user.dir")+"\\testdata\\testData.xlsx";
		
		
		
		
		

	}

}
