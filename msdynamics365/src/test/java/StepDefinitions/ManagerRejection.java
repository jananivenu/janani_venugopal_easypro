package StepDefinitions;

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

public class ManagerRejection extends BaseTest
{

    BaseTest bt;
    private WebDriver driver = Hooks.driver;
    TimeEntrytab tabreject;
    Approvaltab rtab,rtab1,rtab2;


    @Given("^Manager is in Project Operations App$")
    public void manager_is_in_Project_Operations_App() {
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
    
    @And("^Clicks on the Approvals tab to reject the entry$")
    public void clicks_on_the_Approvals_tab_to_reject_the_entry() {
        rtab = new Approvaltab(driver);
        rtab.enter_approval_tab();
        System.out.println("Enter Approvals tab");
    }
    @When("^Manager rejects the submitted Time Entry$")
    public void manager_rejects_the_submitted_Time_Entry() {
        rtab1 = new Approvaltab(driver);
        rtab1.timeentry_rejection();
        rtab.sign_out();
        driver.navigate().refresh();
    }
    @Then("^User Validates the  rejection in Time Entry page$")
    public void user_Validates_the_rejection_in_Time_Entry_page() {
        LoginPage login1 = new LoginPage(driver);
        driver.get(prop.getProperty("URL"));
        login1.user_login_for_validation(prop.getProperty("usr_email"),prop.getProperty("usr_password"));
            login1.AppSelection();
            tabreject = new TimeEntrytab (driver);
        tabreject.navigateToTimeEntrytab();
       
       if (tabreject.validate_rejection())
       {
        System.out.println("Time sheet Rejected and reflected");
       }
       else
       {
        System.out.println("No action taken");
       }
    }
    
}
