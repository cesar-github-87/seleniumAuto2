package TestNG;

import org.testng.annotations.Test;

/*
   1)ABRIR NAVEGADOR
   2)ESCRIBIR EN BARRA DE BUSQUEDA Y DAR ENTER
   3)DAR CLIC EN UN RESULTADO
 * 
 */

// NO NECESARIAMENTE se tiene que crear un metodo por cada paso
public class TestNGTestCase1 {
	
	@Test(priority=1)
	void openNav() {
		
		System.out.println("Open Navigator");
	}
	
	@Test(priority=2)
    void writeSearch() {
		System.out.println("Search ");
	}
	
	@Test(priority=3)
	void clickOption() {
		System.out.println("Click in option");
	}
	

}
