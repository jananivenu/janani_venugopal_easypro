package utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class BaseTest 
{
	public static WebDriver driver;
	
	
	
	public int RESPONSE_STATUS_CODE_200 = 200;
	public int RESPONSE_STATUS_CODE_500 = 500;
	public int RESPONSE_STATUS_CODE_400 = 400;
	public int RESPONSE_STATUS_CODE_401 = 401;
	public int RESPONSE_STATUS_CODE_201 = 201;
    
	
	public Properties prop;
	public Properties idprop;
	
	public BaseTest(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/config.properties");
			prop.load(ip);
		}
			/* idprop  = new Properties();
		    try (OutputStream file = new FileOutputStream((System.getProperty("user.dir")+"/src/main/java/org/com/data/id.properties"))) {
        }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} */ catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
	
	
	
	
