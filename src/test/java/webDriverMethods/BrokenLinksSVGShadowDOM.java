package webDriverMethods;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrokenLinksSVGShadowDOM {

	public static void main(String[] args) throws IOException {
		
		//CUALQUIER CODIGO DE RESPUESTA MAYOR A 400 ES UN BROKEN LINK
		
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://deadlinkcity.com/");
		driver.manage().window().maximize();
		
		/*necesitamos capturar el atributo href de los links que queremos analizar*/
		/*en este caso analizamos todos los links de la pagina en cuestion*/
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Links Totales: " + links.size());
		
		int noOfBroken = 0;
		int noOfNotBroken = 0;
		
		
		for(WebElement listLink:links) {
			
			String hrefValue = listLink.getAttribute("href");
			
			if (hrefValue ==null ||hrefValue.isEmpty()) {
				System.out.println("href Attribute is null or Empty");
				continue;
			}
			
			//IMPORTANTE!!!!!!
			try {				
				URL linkURL = new URL(hrefValue); //el atributo esta en formato String, lo tenemos que cambiar a tipo URL para poder mandarlo al server
				HttpURLConnection connLinkURL =  (HttpURLConnection) (linkURL).openConnection(); //ABRE CONECCION AL SERVIDOR
				connLinkURL.connect(); //manda el request al servidor
				
				if(connLinkURL.getResponseCode()>=400) {
					System.out.println (hrefValue + " ======>Broken Link =====> " + connLinkURL.getResponseCode());
					noOfBroken++;
					
				}
				else {
					System.out.println(hrefValue + " ======>Not Broken Link =====> "+ connLinkURL.getResponseCode());
					noOfNotBroken++;
				}
			}
				catch(Exception e) {}
			
		}
		System.out.println("Links Rotos: "+noOfBroken);
		System.out.println("Links NO Rotos: "+noOfNotBroken);

	}

}
