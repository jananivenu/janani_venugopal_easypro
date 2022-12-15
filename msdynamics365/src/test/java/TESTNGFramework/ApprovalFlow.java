package TESTNGFramework;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import TestPages.Approvaltab;
import TestPages.LoginPage;
import TestPages.TimeEntrytab;
import org.junit.Assert;
import utils.BaseTest;
import utils.BaseTestTask2;

public class ApprovalFlow extends BaseTestTask2
{
    
    BaseTest bt;
    
    
    TimeEntrytab tab,tab1,tab2; 
    Approvaltab atab,atab1;

    @Test
    public void TimeEntrySubmission()
	{

    LoginPage login = new LoginPage(driver);
    System.out.println(driver);
    System.out.println("Navigating to the MSDynamics365 website");
    driver.get(prop.getProperty("URL"));

    System.out.println("Logging in with user credentials");
        login.enteruseremail(prop.getProperty("usr_email"));
        login.enterNext(); 
        login.enterpasswordclick();
        login.enterpassword(prop.getProperty("usr_password"));
        login.submit();
        System.out.println(driver.getCurrentUrl());
        login.AppSelection();
        Assert.assertTrue("Navigating to the Project Operations app", login.project_applications_tab());       
        tab = new TimeEntrytab(driver);
        tab.navigateToTimeEntrytab();
        //Assert.assertTrue("Inside time entry tab", tab1.navigateToTimeEntrytab());
        System.out.println("Creating a new Time entry");
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
        Assert.assertTrue("Created and saved the new Time entry",tab.save_entryand_close());
        tab.select_entry_for_submission();
        tab.submit_entry_for_approval();
		Assert.assertTrue("Submitted the entry for approval",tab2.submit_entry_for_approval());
		atab1.sign_out();
        driver.navigate().refresh();   
     }

     @Test(dependsOnMethods={"TimeEntrySubmission"})
     public void Manager_Approval()
	 {
	 
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
            atab = new Approvaltab(driver);
        atab.enter_approval_tab();
        Assert.assertTrue("Entered Approvals tab",atab.enter_approval_tab()); 
        atab.timeentry_approval();
        atab.sign_out();
        driver.navigate().refresh();
	 }
     
	 @Test(dependsOnMethods={"Manager_Approval"})
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
	   
	   @AfterClass
        public void endSession()
        
        {
           System.out.println("Closing the browser ");
           driver.quit();

        }
   
}

     