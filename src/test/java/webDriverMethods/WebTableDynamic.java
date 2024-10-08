package webDriverMethods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTableDynamic {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =  new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//WebDriverWait elemWait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Si la condicion de espera del elemento no se cumple durante este tiempo, se manda una excepcion.
		
		//elemWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-username']")));
		
		//driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		List<WebElement> pagina = driver.findElements(By.xpath("//ul[@class=\"pagination\"]//li//a"));
		System.out.println("existen: "+pagina.size()+" paginas en la tabla");
		
		for(int p = 1;p<=pagina.size();p++){
			
			if(p>1) {//me muevo en las paginas desde la primera porque es la default.
				WebElement current_p = driver.findElement(By.xpath("//ul[@class=\"pagination\"]//li//a[text()="+p+"]"));
				current_p.click();
				Thread.sleep(3000);
			}
			
			int rows= driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
			
			for(int r=1;r<=rows;r++) {
				String product = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[2]")).getText();
				String price = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[3]")).getText();				
				WebElement select = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[4]//input[@type='checkbox']"));				
				Thread.sleep(500);
				if(product.equals("Product 11")) {
					select.click();
				}
				//Thread.sleep(500);
				Boolean selectStat = select.isSelected();
				
				System.out.println(product +"\t" + price + "\t" + selectStat );
			}
			
			
		
		}
	
		
		
		

	}

}
