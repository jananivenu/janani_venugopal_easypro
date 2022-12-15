package TestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    
    By user_email= By.xpath("//input[@type='email']");

    By another_acc=By.xpath("//div[text()='Use another account']");

    By next_button= By.xpath("//input[@value='Next']");

    By user_pwd=By.xpath("//input[@id='passwordInput']");

    By signin_button=By.id("submitButton");

    By project_page=By.xpath("//div[text()='Project Operations']");

    By iframe_app=By.xpath("//iframe[@id='AppLandingPage']");
    
    By project_app=By.xpath("//a[@aria-label='Project Operations']");

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void enteruseremail(String email)
    {
        driver.findElement(user_email).sendKeys(email);
        
    }
    public void enterNext()
    {
        driver.findElement(next_button).click();;
    }
    public void enterpassword(String password)
    {
        driver.findElement(user_pwd).sendKeys(password);
    }
    public void submit()
    {
        driver.findElement(signin_button).click();
    }
    public boolean AppSelection()
    {
        Wait wait  = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.presenceOfElementLocated(iframe_app));
       
       driver.switchTo().frame("AppLandingPage");
        if((driver.findElement(project_page).isEnabled()))
        {
        driver.findElement(project_page).click();
        driver.switchTo().defaultContent();
        return true;
        }
        else return false;
    }

    public void enterpasswordclick()

    {
          
       driver.findElement(user_pwd).click();
    }

    public boolean project_applications_tab()

    {
       return driver.findElement(project_app).isDisplayed();
    }
    public void user_login_for_validation(String email,String password)
    {
       driver.findElement(another_acc).click();
       driver.findElement(user_email).sendKeys(email);
       driver.findElement(next_button).click();
       driver.findElement(user_pwd).sendKeys(password);
       driver.findElement(signin_button).click();
    }

}
