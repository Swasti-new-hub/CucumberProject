@OrangeHRM
Feature: Verify the Orange HRM application. 
  
 @ActivityHRM_1
    Scenario: Creating a job vacancy for Android Developer Engineer
    Given Open and login to the OrangeHRM Page
    Then Navigate to the Recruitments page
    And Click on the Vacancies menu item to navigate to the vacancies page 
    When Click on the Add button to navigate to the Add Job Vacancy form
    Then Fill out the necessary details
    And Verify the vacancy 
    And Close the Orange browser
 
 @ActivityHRM_2
  Scenario: Adding a candidate for recruitment
  Given Open and login to the OrangeHRM Page
  Then Navigate to the Recruitments page
  Then Click on the Candidates menu item to navigate to the candidate page 
  And Click on the Add button to add candidate information
  And On next page fill in the details of the candidate
  Then Upload a resume to the form
  And Save the application
  Then Navigate back to the Recruitments page to confirm candidate entry
  And Close the Orange browser
  
 @ActivityHRM_3 
  Scenario Outline: Add multiple employees
  Given Open and login to the OrangeHRM Page
  Then Find the PIM option in the menu and click Add
  And Enter details "<FName>", "<LName>"
  And Checkbox login Details
  Then Enter further details "<UName>", "<Status>"
  And Save the employee "<FName>", "<LName>"
  And Close the Orange browser
  
    Examples: 
    
      |FName    |LName       |Status |UName      | 
      |Testuser1|TestSurname1|Enabled|TestUser123|
      |TestUser2|TestSurname2|Enabled|TestUser456|

@ActivityHRM_3
Scenario Outline: Creating multiple vacancies
   Given Open and login to the OrangeHRM Page
   Then Navigate to the Recruitments page
   And Click on the Vacancies menu item to navigate to the vacancies page 
   When Click on the Add button to navigate to the Add Job Vacancy form
   Then Fill necessary details like "<vName>", "<hManager>", "<title>"
   And verify the vacancy with  "<vName>", "<hManager>", "<title>"
   And Close the Orange browser
   
   
   Examples: 
   |vName        |hManager               |title            |
   |SeleniumJobs |FName_18805 lName_18805|Android Developer|
	 |DeveloperJobs|FName_18806 lName_18806|DevOps Engineer  |
