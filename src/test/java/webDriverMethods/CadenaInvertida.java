package webDriverMethods;

public class CadenaInvertida {

	public static void main(String[] args) {
		String cadena = "hola mundo";
        String cadenaInvertida = "";
        
        System.out.println(cadena.length());
        
        // Recorre la cadena de atrás hacia adelante
        for (int i = cadena.length() - 1; i >= 0; i--) {
        	
        	System.out.println("Valor de i " +i +" char es "+cadena.charAt(i));
            cadenaInvertida += cadena.charAt(i);
        }

        // Imprime la cadena invertida
        System.out.println(cadenaInvertida);
    }

	

}


/*
 * 
 * import java.util.*;
import java.io.*;

class Main {

  public static String Foo(String param) {
    return param;
  }
 
  public static void main (String[] args) {
    Integer n = 0;
    while(n>0){
    String startRange  = "0";
    String endRange = "9";
  
    String newStart = "1"+startRange.repeat(n-1);
    String newEnd = endRange.repeat(n);

    Integer sRange = Integer.valueOf(newStart);
    Integer eRange = Integer.valueOf(newEnd);

    for(Integer i=sRange; i<=eRange; i++){
   //   String range = i.toString();
     // if(range.length() == n){
        if(i%7==0){
          System.out.println(i);
        }
    //  }
    }
}

  }

}

// calculate range
// n = 1
// range = [1, 9]
// n = 2
// range = [10, 99]
// n = 3
// range = [100, 999]
// n = 4
// range = [1000, 9999]
 */
*/