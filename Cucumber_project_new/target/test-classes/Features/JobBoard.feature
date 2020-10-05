@jobBoard
Feature: Data driven test without Example

 @ActivityJB_1
Scenario: Create a New User
    Given Open the Login page backend
    When User logins with "root" and "pa$$w0rd"
    Then Locate the left hand menu and click on Users
    Then Enter the Jobboard details and click Add User
    Then Verify that the user has been created
    And Close the Browser
   
 @ActivityJB_2
Scenario: Searching for jobs using XPath
    Given Open the Jobs page
    Then Find the Keywords search input field and search for jobs
    Then Filter job type to show only Full Time jobs 
    Then Find and Click on the Apply for job button
    And Close the Browser
    
 @ActivityJB_3
 Scenario: Posting a job using parameterization
   Given Open the Jobs page
  Then Go to Post a Job page
  Then Enter "Selenium Test Engineer", "Hyderabad" and "IBM"
  Then Submit the form
  Then Confirm "Selenium Test Engineer" listing is shown on page
  And  Close the Browser

 @ActivityJB_4
Scenario Outline: Using Examples table to post a job
    Given Open the Jobs page
    Then Go to Post a Job page
    And Enter details "<Email>", "<Job>", "<Location>" and "<Company>"
    And Submit the form
    And  Confirm "<Job>" listing is shown on page
    And  Close the Browser
    
  Examples:
  | Email                 | Job                    | Location| Company |
  |TestEngineer1@gmail.com|Selenium Test Engineer 1|Hyderabad|IBM      |
  |TestEngineer2@gmail.com|Selenium Test Engineer 1|Pune     |IBM      |
  
