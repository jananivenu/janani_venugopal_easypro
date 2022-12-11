package StepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import TestPages.Approvaltab;
import TestPages.LoginPage;
import TestPages.TimeEntrytab;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BaseTest;

public class ManagerApproval extends BaseTest 

{
    BaseTest bt;
    private WebDriver driver = Hooks.driver;
    TimeEntrytab tab;
    Approvaltab atab,atab1,atab2;


    
    @Given("^User is in Project Operations App$")
    public void user_is_in_Project_Operations_App(){
        LoginPage login = new LoginPage(driver);
        System.out.println(driver);
        System.out.println("Navigating to the MSDynamics365 website");
        driver.get(prop.getProperty("URL"));
        
            System.out.println("Logging in with manager credentials");
            login.enteruseremail(prop.getProperty("mgr_email"));
            login.enterNext(); 
            login.enterpasswordclick();
            login.enterpassword(prop.getProperty("mgr_password"));
            login.submit();
            System.out.println(driver.getCurrentUrl());
            login.AppSelection();
            System.out.println("Navigating to the Project Operations app");   

    } 

    
    @And("^Clicks on the Approvals tab$")   
    public void Clicks_on_the_Approvals_tab() {
        atab = new Approvaltab(driver);
        atab.enter_approval_tab();
        System.out.println("Enter Approvals tab");
    }

    @When("^User approves the submitted Time Entry$")
    public void user_approves_the_submitted_Time_Entry(){
        atab1 = new Approvaltab(driver);
        atab1.timeentry_approval();
        driver.findElement(By.xpath("//div[@id='mectrl_headerPicture' and text()='BC']"));
        driver.findElement(By.xpath("//button[@id='mectrl_body_signOut' and text()='Sign out']");"
        //driver.quit();
    }

    @Then("^User Validates the  approval in Time Entry page$")
    public void User_Validates_the_approval_in_Time_Entry_page() {
        LoginPage login1 = new LoginPage(driver);
        driver.get(prop.getProperty("URL"));
        login1.enteruseremail(prop.getProperty("usr_email"));
            login1.enterNext(); 
            login1.enterpasswordclick();
            login1.enterpassword(prop.getProperty("usr_password"));
            login1.submit();
            login1.AppSelection();
        tab = new TimeEntrytab(driver);
        tab.navigateToTimeEntrytab();
       if (tab.validate_approval())
       {
        System.out.println("Approval successful and reflected");
       }

    }

   

}
