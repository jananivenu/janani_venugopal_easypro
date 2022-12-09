package TestPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TimeEntrytab {
    
    WebDriver driver;
    List<WebElement> elements;

    By time_entry_tab=By.xpath("//span[text()='Time Entries']");
    
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

    By select_entry=By.xpath("//div[@class='grid-cell-content']/button[contains (@aria-label,'Select all values in a row')]");
     
    By submit_entry=By.xpath("//button[@name='Submit']");

    public TimeEntrytab(WebDriver driver)
    {
        this.driver=driver;
    }

    public void navigateToTimeEntrytab()
    {
        driver.findElement(time_entry_tab).click();
    }
    public void create_New_timeEntry()
    {
     driver.findElement(New_timeEntry).click();
    }
     public void set_start_date()
     {
      driver.findElement(start_date).sendKeys("09-12-2022");
     }   
     public void set_start_time()
     {
      driver.findElement(start_time).sendKeys("09:00");
     }  
     public void set_end_date()
     {
      driver.findElement(end_date).sendKeys("09-12-2022");
     }   
     public void set_end_time()
     {
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
       act.keyDown(Keys.ARROW_DOWN);
       act.keyUp(Keys.ARROW_DOWN);
       act.keyDown(Keys.ENTER);
       act.keyUp(Keys.ENTER);
	   act.perform();  
     }
     public void  select_project_task()
     {
        driver.findElement(project_task)
        .sendKeys("design");
        Actions act = new Actions(driver);
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
     
     public void save_entryand_close()

     {
        driver.findElement(save_entry).click();
     }
     public void select_entry_for_submission()

     {
         elements = driver.findElements(select_entry);
         elements.get(elements.size()-1).click();
        

     }
     public void submit_entry_for_approval()

     {
        driver.findElement(submit_entry).click();
     }

}
