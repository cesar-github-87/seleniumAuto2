package webDriverMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class DataDrivenPropertiesFile {

	public static void main(String[] args) throws IOException {
	
		
		
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\config.properties");
		
		Properties propobj = new Properties();
		propobj.load(file);
		String url = propobj.getProperty("appurl");
		String email = propobj.getProperty("email");
		String passw = propobj.getProperty("password");
		String orderid = propobj.getProperty("orderid");
		String customerid = propobj.getProperty("customerid");
		
		System.out.println(url + " "+email+" "+passw+" "+orderid+" "+customerid);
		
		Set<String> keys = propobj.stringPropertyNames();
		System.out.println(keys);
		
		Set<Object> keysAsObj = propobj.keySet();
		System.out.println(keysAsObj);
		
		
		Collection<Object> valuesAsObj = propobj.values(); 
		System.out.println(valuesAsObj);
		//valuesAsObj.
		
		

	}

}
