package TestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;

    
    By user_email= By.xpath("//input[@type='email']");

    By next_button= By.xpath("//input[@value='Next']");

    By user_pwd=By.xpath("//input[@id='passwordInput']");

    By signin_button=By.id("submitButton");

    By project_page=By.xpath("//div[text()='Project Operations']");

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
    public void AppSelection()
    {
       // WebDriverWait wait = new WebDriverWait(driver,30);
       // wait.until(ExpectedConditions.visibilityOfElementLocated(project_page));
       driver.switchTo().frame("AppLandingPage");
        driver.findElement(project_page).click();
        driver.switchTo().defaultContent();
    }

    public void enterpasswordclick()

    {
          
       driver.findElement(user_pwd).click();
    }

}
