package webDriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandle {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		//FRAME1		
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));		
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Puse mi texto");
		
		//FRAME 2
		//NO PUEDO SIMPLEMENTE MOVERME CON EL SWITCHTO A OTRO FRAME, TENGO QUE SALIRME AL CONTENEDOR PRINCIPAL
		driver.switchTo().defaultContent();
		
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("el texto del 3");
		
		WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://docs.google.com/forms/d/1yfUq-GO9BEssafd6TvHhf0D6QLDVG3q5InwNE2FFFFQ/viewform?embedded=true']"));
		driver.switchTo().frame(iframe);
 
		driver.findElement(By.xpath("//div[@id='i8']//div[@class='AB7Lab Id5V1']")).click();
	}

}
