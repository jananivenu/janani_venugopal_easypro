package TestPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.DateUtil;

public class TimeEntrytab {
    
    WebDriver driver;
    
    DateUtil du =new DateUtil();

    By time_entry_tab=By.xpath("//span/img[@title='Time Entries']");
    
    By New_timeEntry= By.xpath("//span[text()='New']");


    By timentry_section= By.xpath("//section[@data-lp-id='quick-create|quickCreateRoot|msdyn_timeentry']");

    By start_date=By.xpath("//input[contains(@aria-label,'Date of Start')]");
    
    By start_time=By.xpath("//input[contains(@aria-label,'Time of Start')]");

    By end_date=By.xpath("//input[contains(@aria-label,'Date of End')]");
    
    By end_time=By.xpath("//input[contains(@aria-label,'Time of End')]");


    By duration_inputbox=By.xpath("//input[contains(@aria-label,'Duration')]");
    
    By type = By.xpath("//select[contains(@aria-label,'Type')]");

    By project_lookup=By.xpath("//input[contains(@aria-label,'Project, Lookup')]");

    By project_task=By.xpath("//input[contains(@aria-label,'Project Task, Lookup')]");

    By project_role= By.xpath("//span[text()='Team Member']");

    By description=By.xpath("//input[@data-id='msdyn_description.fieldControl-text-box-text']");

    By external_comments=By.xpath("//input[contains(@aria-label,'External Comments')]");

    By save_entry= By.xpath("//span[text()='Save and Close']");

    By select_entry=By.xpath("//button[contains(@aria-label,'Select All']");
     
    By submit_entry=By.xpath("//button[@name='Submit']");

    By approval_status=By.xpath("//div[contains(@aria-label,'Entry Status Entry Status Returned')]");

    By rejection_status=By.xpath("//div[contains(@aria-label,'Entry Status Approved')]");

    public TimeEntrytab(WebDriver driver)
    {
        this.driver=driver;
    }

    public boolean navigateToTimeEntrytab()
    {
      if(driver.findElement(time_entry_tab).isEnabled())
      {
         driver.findElement(time_entry_tab).click();
         return true;
      }
      else return false;
        
    }
    public void create_New_timeEntry()
    {
      driver.switchTo().frame(driver.findElement(By.xpath(" //iframe[@aria-label='Time Entry Grid']")));

      driver.findElement(New_timeEntry).click();
      driver.switchTo().defaultContent();
    }
     public void set_start_date()
     {
      driver.findElement(start_date).clear();
      driver.findElement(start_date).sendKeys(du.formatDate());
      //driver.findElement(start_date).sendKeys(Keys.ENTER);
     }   
     public void set_start_time()
     {
      driver.findElement(start_time).clear();
      driver.findElement(start_time).sendKeys("09:00");
     }  
     public void set_end_date()
     {
      driver.findElement(end_date).clear();
      driver.findElement(end_date).sendKeys(du.formatDate());
      //driver.findElement(start_date).sendKeys(Keys.ENTER);
     }   
       
     public void set_end_time()
     {
      driver.findElement(end_time).clear();
      driver.findElement(end_time).sendKeys("10:00");
     } 
     public void set_duration()
     {
      driver.findElement(duration_inputbox).clear();
      driver.findElement(duration_inputbox).sendKeys("1 hour");
     } 
     public void set_type()
     {
      driver.findElement(type).sendKeys("Work");
     }
     public void click_project_lookup()
     {
      driver.findElement(project_lookup).click();
       driver.findElement(project_lookup).sendKeys("sail inc");
       Actions act = new Actions(driver);
       act.keyDown(Keys.ENTER);
       act.keyUp(Keys.ENTER);
       act.keyDown(Keys.ARROW_DOWN);
       act.keyUp(Keys.ARROW_DOWN);
       act.keyDown(Keys.ENTER);
       act.keyUp(Keys.ENTER);
	   act.perform();  
     }
     public void  select_project_task()
     {
      driver.findElement(project_task).click();
        driver.findElement(project_task)
        .sendKeys("Design Development");
        Actions act = new Actions(driver);
        act.keyDown(Keys.ENTER);
        act.keyUp(Keys.ENTER);
        act.keyDown(Keys.ARROW_DOWN);
        act.keyUp(Keys.ARROW_DOWN);
        act.keyDown(Keys.ENTER);
        act.keyUp(Keys.ENTER);
        act.perform(); 
     }
     public void enter_description()
     {
        driver.findElement(description).sendKeys("kindly approve");
     }
     
     public boolean save_entryand_close()

     {
      if(driver.findElement(save_entry).isEnabled())
        {
         driver.findElement(save_entry).click();
        return true;
        }
        else return false;
     }
     public void select_entry_for_submission()

     {
         driver.switchTo().frame(driver.findElement(By.xpath(" //iframe[@aria-label='Time Entry Grid']")));
         driver.findElement(select_entry).click();
         driver.switchTo().defaultContent();


      
     }
     public boolean submit_entry_for_approval()

     {
      driver.switchTo().frame(driver.findElement(By.xpath(" //iframe[@aria-label='Time Entry Grid']")));
      if(driver.findElement(submit_entry).isEnabled())
      {
        driver.findElement(submit_entry).click();
        driver.switchTo().defaultContent();

        return true;
      }
      else return false;
     }

     public boolean validate_approval()
     {
         return driver.findElement(approval_status).isDisplayed();
     }
     public boolean validate_rejection()
     {
         return driver.findElement(approval_status).isDisplayed();
     }

}
