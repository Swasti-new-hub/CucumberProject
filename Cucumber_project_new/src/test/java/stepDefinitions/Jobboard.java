package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Jobboard {
	WebDriver driver;
    WebDriverWait wait;
    WebElement element;

    @Given("^Open the Login page backend$")
    public void backendJobsPage() {
        
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
    }
    
    @Given("^Open the Jobs page$")
    public void job_page() {
    	  driver = new FirefoxDriver();
          wait = new WebDriverWait(driver, 10);
          driver.get("https://alchemy.hguy.co/jobs");	
    }
    
    @When("User logins with {string} and {string}")
    public void user_logins_with(String string, String string2) throws Throwable {
        driver.findElement(By.id("user_login")).sendKeys(string);
        driver.findElement(By.id("user_pass")).sendKeys(string2);
        driver.findElement(By.id("wp-submit")).click();
    }

 @Then ("^Locate the left hand menu and click on Users$")
 public void clickonUsers() throws Throwable {
	 Actions action = new Actions(driver);
		WebElement menu = driver.findElement(By.cssSelector("a.menu-icon-users > div:nth-child(3)"));
		action.moveToElement(menu).build().perform();
		menu.click();
        driver.findElement(By.cssSelector(".page-title-action")).click();
	 }
 

   
   @Then ("^Enter the Jobboard details and click Add User$")
    public void enter_the_Jobboard_details_and_click_add_user() throws Throwable {
	   
	   driver.findElement(By.id("user_login")).sendKeys("CucumberTestUser231");
	   driver.findElement(By.id("email")).sendKeys("CucumberTestUser231@ibm.com");
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   driver.findElement(By.id("createusersub")).submit();
   }
    
    @Then ("^Verify that the user has been created$")
    public void verify_that_the_user_has_been_created() throws Throwable {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.id("user-search-input")).sendKeys("CucumberTestUser231@ibm.com");
	driver.findElement(By.id("search-submit")).click();
	String userDetails = driver.findElement(By.cssSelector("#user-659 > td:nth-child(4) > a:nth-child(1)")).getText();
    Assert.assertEquals(userDetails, "CucumberTestUser1@ibm.com");
    }
  
	
	@Then ("^Find the Keywords search input field and search for jobs$")
	 public void find_the_Keywords_search_input_field_and_search_for_jobs() throws Throwable {
		driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[1]/a")).click();
		 driver.findElement(By.cssSelector("#search_keywords")).sendKeys("Developer");
		 driver.findElement(By.cssSelector("#search_location")).sendKeys("Anywhere");
		 driver.findElement(By.xpath("//*[@id='post-7']/div/div/form/div[1]/div[4]/input")).submit();	
		 }
	   @Then ("^Filter job type to show only Full Time jobs$")
	   public void filter_job_type_to_show_only_Full_Time_jobs () throws Throwable {
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.findElement(By.id("job_type_freelance")).click();
		 driver.findElement(By.id("job_type_internship")).click();
		 driver.findElement(By.id("job_type_part-time")).click();
		 driver.findElement(By.id("job_type_temporary")).click();
		 driver.findElement(By.xpath("//*[@id='post-7']/div/div/form/div[1]/div[4]/input")).submit();
		 }
	  
	   @Then("^Find a job listing using XPath and it to see job details")
	   public void find_a_job_listing_using_xpath_and_it_to_see_job_details() throws Throwable {
		 List<WebElement> jobs =  driver.findElements(By.xpath("/html/body/div/div/div/div/main/article/div/div/ul/li/a/div[1]/h3"));
		 for (WebElement job: jobs) {
			 System.out.println(job.getText());
		 }
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			jobs.get(1).click();
			driver.findElement(By.cssSelector(".application_button")).click();
			String message = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/header/div/h1")).getText();
			System.out.println(message);
	   }
	   
	@Then ("^Find and Click on the Apply for job button$")
	      public void find_and_click_on_the_apply_for_job_button() throws Throwable {
	       driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/ul/li/a/div[1]/h3")).click();
		  }
	    

           @Then("^Go to Post a Job page$")
           public void postaJobpage() throws Throwable{
        	   
        	   driver = new FirefoxDriver();
               wait = new WebDriverWait(driver, 10);
               driver.get("https://alchemy.hguy.co/jobs");	
               driver.findElement(By.cssSelector("#menu-item-26 > a:nth-child(1)")).click();
               driver.findElement(By.partialLinkText("Sign in")).click();
               driver.manage().window().maximize();
               driver.findElement(By.id("user_login")).sendKeys("root");
               driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
               driver.findElement(By.id("wp-submit")).click();
               
 }

          @Then("^Enter \"(.*)\", \"(.*)\" and \"(.*)\"$")
          public void enterDetails(String jobTitle, String location, String company) throws Throwable{ 
        	  driver.findElement(By.id("job_title")).sendKeys(jobTitle);
        	  driver.findElement(By.id("job_location")).sendKeys(location);
        	 
        	  driver.findElement(By.id("company_name")).sendKeys(company);
        	  Select selection = new Select(driver.findElement(By.id("job_type")));
      		  selection.selectByValue("2");
      		  
      		 driver.switchTo().frame("job_description_ifr");
      		 driver.findElement(By.xpath("/html/body")).sendKeys("New job details");
      		 driver.switchTo().defaultContent();
      		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      	}
          
          @Then("^Submit the form$")
          public void submitDetails() {
        	 driver.findElement(By.cssSelector("input.button:nth-child(4)")).click();
         	 driver.findElement(By.id("job_preview_submit_button")).click();
         	 driver.findElement(By.cssSelector("#menu-item-24 > a:nth-child(1)")).click();
        	  
          }
          
          @Then("^Confirm \"(.*)\" listing is shown on page$")
      	    public void confirm_job_listing_is_shown_on_page(String job) throws Throwable {
      		driver.findElement(By.cssSelector("#search_keywords")).sendKeys(job);
      		driver.findElement(By.cssSelector("#post-7 > div > div > form > div.search_jobs > div.search_submit > input[type=submit]")).click();
      		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      		String jobSave = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/main/article/div/div/ul/li[1]/a/div[1]/h3")).getText();
      		junit.framework.Assert.assertEquals(job, jobSave);
      	}
          
        @And("^Close the Browser$")
  	    public void close_the_Browser() {
  	    driver.close();
  	    }
          
}