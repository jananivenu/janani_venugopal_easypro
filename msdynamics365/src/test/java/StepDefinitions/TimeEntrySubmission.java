package StepDefinitions;

//import java.time.Duration;
import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;

import TestPages.LoginPage;
import TestPages.TimeEntrytab;
//import io.cucumber.java.Before;
//import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class TimeEntrySubmission {
    WebDriver driver  = null;
    
    TimeEntrytab tab,tab1,tab2;

     
    @Given("^User is in Project Operations tab$")
    public void user_is_in_Project_Operations_tab(){
        System.out.println("Starting the Application");
        System.out.println(System.getProperty("user.dir")+"\\chromedriver.exe");
    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe")
    driver = new ChromeDriver();
    LoginPage login = new LoginPage(driver);
    System.out.println(driver);
    System.out.println("Navigating to the MSDynamics365 website");
    driver.get("https://poqa.crm4.dynamics.com");
    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    System.out.println("Logging in with user credentials");
        login.enteruseremail("best.candidate@promx.net");
        login.enterNext(); 
        login.enterpasswordclick();
        login.enterpassword("gwp@W0ER");
        login.submit();
        System.out.println(driver.getCurrentUrl());
        login.AppSelection();
        System.out.println("Navigating to the Project Operations app");      
    }
 
    @Given("Clicks on the Time Entry tab")
    public void Clicks_on_the_Time_Entry_tab() {
       
        
        tab1 = new TimeEntrytab(driver);
        tab1.navigateToTimeEntrytab();
        System.out.println("Inside time entry tab");
    }
    
    @When("^User creates new Time Entry$")
     public void user_creates_new_Time_Entry()
     {
        System.out.println("Creating a new Time entry");
        tab = new TimeEntrytab(driver);
        tab.create_New_timeEntry();
        tab.set_start_date();
        tab.set_start_time();
        tab.set_end_date();
        tab.set_end_time();
        tab.set_duration();
        tab.set_type();
        tab.click_project_lookup();
        tab.select_project_task();
        tab.enter_description();
        tab.save_entryand_close();
        System.out.println("Createdand saved the new Time entry");
     }

     @Then("^Submits the entry for approval$")
     public void submits_the_entry_for_approval()
     {
        
        tab2= new TimeEntrytab(driver);
        tab2.select_entry_for_submission();
        tab2.submit_entry_for_approval();
        System.out.println("Submitted the entry for approval");

     }

 

   
}