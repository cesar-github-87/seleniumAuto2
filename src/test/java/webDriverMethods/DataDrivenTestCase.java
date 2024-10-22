package webDriverMethods;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DataDrivenTestCase {

	public static void main(String[] args) throws IOException {
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
		Select dropPeriod = new Select(period);
		
		WebElement frequency = driver.findElement(By.xpath("//select[@id='frequency']"));
		Select freq = new Select(frequency);
		
		WebElement calculateBtn = driver.findElement(By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']"));
		WebElement clearBtn = driver.findElement(By.xpath("//img[@class='PL5']"));
		
		String filePath = System.getProperty("user.dir")+"\\testdata\\testData.xlsx";
		
		int lineas = ExcelUtils.getRowCount(filePath, "Sheet1");
		int columnas = ExcelUtils.getCellCount(filePath, "Sheet1", lineas);
		
		System.out.println("Lineas="+ lineas);
		System.out.println("Columnas="+columnas);
		//System.out.println(ExcelUtils.getCellData(filePath, "Sheet1", 0,0 ));
		
		for(int i = 1; i<=1;i++) {
			for(int j = 0; j<=4; j++) {
				String stringData = ExcelUtils.getCellData(filePath,"Sheet1", i, j);
				if(j==0) {
					principal.sendKeys(stringData);					
				}
				if(j==1) {		
			
					rate.sendKeys(stringData);
					
				}
				if(j==2) {
					periodVal.sendKeys(stringData);
				}
				if(j==3) {												
					dropPeriod.selectByVisibleText(stringData);					
				}
				if(j==4) {
					freq.selectByVisibleText(stringData);
				}
				//if(j==5) {
					
				//}
				calculateBtn.click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
			//	WebElement result = driver.findElement(By.xpath("//strong[normalize-space()='24000.00']"));
				
				
			}
		}

	}

}
