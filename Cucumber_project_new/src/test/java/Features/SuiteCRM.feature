@crmActivity
Feature: Counting dashlets and Create leads using parameterization
 
  
Background: User is Logged In
    Given User navigate to the login page
    When User enters username "admin" and password "pa$$w0rd"
    Then User should be logged in
@ActivityCRM_1
Scenario: Counting dashlets
    When User count the number of Dashlets on the homepage
    Then User print the number and title of each Dashlet into the console
    Then Close the Browser 

@ActivityCRM_2
Scenario: Create leads using parameterization
    When User navigate to Create Lead
    Then User enters "firstName1","lastName1","cucumbertest@test.com","06666789987" to create lead accounts
    Then user navigate to the View Leads page to see result "firstName1 lastName1"
    Then Close the Browser
    
@ActivityCRM_3
Scenario Outline: Schedule a meeting and invite members
    Given User logs in to website using username "<userName>" and password "<password>"
    When User navigates to Schedule a Meeting
    Then User enters details "<Subject>" of the meeting
    Then User search for members and add them to the meeting
    Then User confirms creation of the meeting with subject "<Subject>"    
    Then Close the Browser
    
Examples:
      | userName| password  | Subject              |
      | admin   | pa$$w0rd  | CucumberDiscussion   | 
      
@ActivityCRM_4   
Scenario Outline: To use an Examples table to add products
    Given User logs into CRM website using username "<userName>" and password "<password>" and validate
    When User navigates to All -> Products-> Create Product
    Then User enters details "<productName>" product name and price "<price>"
    Then User to the View Products page to see the product listed "<productName>"
    Then Close the Browser
Examples:
       | userName| password  | productName       | price |
       | admin   | pa$$w0rd  | testproduct2020   | 500   |