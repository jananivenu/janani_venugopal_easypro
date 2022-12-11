package TestPages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Approvaltab {

    WebDriver driver;
    
    By approvals_tab=By.xpath("//span[text()='Approvals']");

    By group_btn = By.xpath("//span[@class='wj-input-group-btn']/button[contains(@aria-label,'Toggle Dropdown')]");
    
    By group_by = By.xpath("//div[@title='Resource' and @data-id='msdyn_bookableresource']");

    By filter = By.xpath("//span[text()='Filter by']");

    By filter_by_value=By.xpath("//input[@aria-label='Filter by Value']");

    By resource_name=By.xpath("//button[@aria-label='Best Candidate']");

    By apply_change=By.xpath("//span[text()='Apply']");

    By approval_no_data=By.xpath("//div[@title='No data available.']");

    By approval_row=By.xpath("//button[@title='Select All']");

    By approval_button=By.xpath("//span[text()='Approve']");

    By reject_button=By.xpath("//span[text()='Reject']");

    By reject_comments=By.xpath("//textarea[@data-id='createrejectcioncomment_id.fieldControl-text-box-text']");

    By Ok_after_approval=By.xpath("//button[@data-id='okButton']");

    By Ok_after_reject_comments=By.xpath("//button[@data-id='okButton']");

    By ok_after_reject=By.xpath("//button[@data-id='ok_id']");

    public Approvaltab(WebDriver driver)
    {
        this.driver=driver;
    }

    public void enter_approval_tab()
    {
        driver.findElement(approvals_tab).click();
    }

    public void sort_group_as_resource()
    {
        driver.findElement(group_btn).click();
        driver.findElement(group_by).click();
    }

    public void timeentry_approval()
    {
       
        driver.findElement(group_by).click();
        driver.findElement(filter).click();
        driver.findElement(filter_by_value).click();
        driver.findElement(resource_name).click();
        driver.findElement(apply_change).click();
        if(driver.findElement(approval_no_data).isDisplayed())
        {
            System.out.println("Nothing to approve");
        }
        else
        {
        driver.findElement(approval_row).click();
        driver.findElement(approval_button).click();
        driver.findElement(Ok_after_approval).click();
        }

    }

    public void timeentry_rejection()
    {
        driver.findElement(group_by).click();
        driver.findElement(filter).click();
        driver.findElement(filter_by_value).click();
        driver.findElement(resource_name).click();
        driver.findElement(apply_change).click();
        if(driver.findElement(approval_no_data).isDisplayed())
        {
            System.out.println("Nothing to reject");
        }
        else
        {
        driver.findElement(approval_row).click();
        }
        driver.findElement(reject_button).click();
        driver.findElement(ok_after_reject).click();
        driver.findElement(Ok_after_reject_comments).click();

    }
   
}
