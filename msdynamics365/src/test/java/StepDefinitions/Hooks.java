package StepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import utils.BaseTest;

public class Hooks extends BaseTest {

    public static WebDriver driver;
    BaseTest bt;
    
    String email;
    String password;
    String URL;
    String usr_email;
    String usr_password;
    String usr_URL;
    @Before
    public void setup() throws IOException
    {
        System.out.println(System.getProperty("user.dir")+"\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.manage().window().maximize();
        /*bt = new BaseTest();
         email=prop.getProperty("mgr_email");
        password=prop.getProperty("mgr_password");
        URL=prop.getProperty(URL);
        usr_email=prop.getProperty("usr_email");
        usr_password=prop.getProperty("usr_password");
        usr_URL=prop.getProperty(URL); */
    }
    
}
