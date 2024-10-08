package webDriverMethods;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class DatePickersHandle {

	public static void main(String[] args) throws InterruptedException {
		
		String month = "January";
		
		WebDriver driver = new ChromeDriver();
		Thread.sleep(5000);

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//me muevo al frame en el que esta el calendario
		
		WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://fs24.formsite.com/res/showFormEmbed?EParam=m_OmK8apOTDpwCqUlfXbL2rYe2Y6sJfY&796456169&EmbedId=796456169']"));
		driver.switchTo().frame(iframe);//frame-one796456169
		Thread.sleep(3000);
		
		//Hago clic en el icono para desplegar el calendario. Lo hago DOS VECES porque si nomas lo hago una, poralguna razon no lo despliega.
		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();
		System.out.println("Esta desplegado el icono "+driver.findElement(By.xpath("//span[@class='icon_calendar']")).isDisplayed() + " "+ 	driver.findElement(By.xpath("//span[@class='icon_calendar']")).getAttribute("role"));
		
		Thread.sleep(1000);
		
		WebElement dropAnio = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));	
		Select anio = new Select(dropAnio);	
		anio.selectByVisibleText("1987");
		
		
		
		//SELECCIONAR MES.
		 
		while(true) {
			String currentMonth =  driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			Month cMonth = convertMonth(currentMonth); //Mes Desplegado
			Month rMonth = convertMonth(month);//Mes Requerido
			
			int compareMonth = rMonth.compareTo(cMonth); //Compara ambos meses si el requerido es Menor al Current, regresa negativo, si es Mayor regresa positivo, si es igual regresa 0
			
			if (compareMonth<0) {
				driver.findElement(By.xpath("//a[@title='Prev']")).click();
			}
			else if(compareMonth>0) {
				driver.findElement(By.xpath("//a[@title='Next']")).click();
			}
			else {
				break;
			}
		
		}
		
		
		//SELECCIONAR DIAS
		driver.findElement(By.xpath("//a[@data-date='17']")).click();
		
		//driver.findElement(By.xpath("//div[@class = 'form_table']//div[@id='q4']//input[@id='RESULT_TextField-2']")).sendKeys("01/17/1987");
	}
	
	
	/*-----------------------------------------*/
	
	static Month convertMonth(String month) {
		
		HashMap<String, Month> monthMap = new HashMap<String, Month>();
		
		monthMap.put("January", Month.JANUARY);
		monthMap.put("February",Month.FEBRUARY);
		monthMap.put("March", Month.MARCH);
		monthMap.put("April", Month.APRIL);
		monthMap.put("May", Month.MAY);
		monthMap.put("June", Month.JUNE);
		monthMap.put("July", Month.JULY);
		monthMap.put("August", Month.AUGUST);
		monthMap.put("September", Month.SEPTEMBER);
		monthMap.put("October", Month.OCTOBER);
		monthMap.put("November", Month.NOVEMBER);
		monthMap.put("December", Month.DECEMBER);
		
		Month vMonth = monthMap.get(month);
		
		if(vMonth == null) {
			System.out.println("Mes invalido...");
		}
		
		return vMonth;
		
	}
}
