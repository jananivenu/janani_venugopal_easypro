package StepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import TestPages.Approvaltab;
import TestPages.LoginPage;
import TestPages.TimeEntrytab;
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
            Assert.assertTrue("Navigating to the Project Operations app", login.project_applications_tab());      
             

    } 

    
    @And("^Clicks on the Approvals tab$")   
    public void Clicks_on_the_Approvals_tab() {
        atab = new Approvaltab(driver);
        atab.enter_approval_tab();
        Assert.assertTrue("Entered Approvals tab",atab.enter_approval_tab());
    }

    @When("^User approves the submitted Time Entry$")
    public void user_approves_the_submitted_Time_Entry(){
        atab1 = new Approvaltab(driver);
        atab1.timeentry_approval();
        atab1.sign_out();
        driver.navigate().refresh();
    }

    @Then("^User Validates the  approval in Time Entry page$")
    public void User_Validates_the_approval_in_Time_Entry_page() {
        LoginPage login1 = new LoginPage(driver);
        driver.get(prop.getProperty("URL"));
        login1.user_login_for_validation(prop.getProperty("usr_email"),prop.getProperty("usr_password"));
        login1.AppSelection();
        tab = new TimeEntrytab(driver);
        tab.navigateToTimeEntrytab();
       if (tab.validate_approval())
       {
        System.out.println("Time sheet Approval successful and reflected");
       }
       else
       {
        System.out.println("No action taken");
       }
    }

   

}
