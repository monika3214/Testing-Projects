
Feature: Login feature of Salesforce
Checking Salesforce login with different credantials 

Background:
 Given whenI go to url "https://bravestechnology-dev-ed.develop.my.salesforce.com"

  Scenario:Checking Salesforce login with correct credantials 
   
    When I am on "LoginPage"
    When I enter value of username as "monika@braves.com" and password as "Gudda23$"
    And click on login button
    Then I should get page title as "Home Page ~ Salesforce - Developer Edition"
    
  Scenario:Checking Salesforce login errormessage with correct username and empty password 
   
    When I am on "LoginPage"
    When I enter value of username as "monika@braves.com" and password as ""
    And click on login button
    Then I should get error message  as "Please enter your password."
    
  Scenario:Checking Salesforce login  with checkme checkbox checked
    
    When I am on "LoginPage"
    When I enter value of username as "monika@braves.com" and password as "Gudda23$"
    And  I click  checkme checkbox
    And click on login button
    And I am on "HomePage"
    When I click logout button
    When I am on "LoginPage" 
    Then I should get  username textbox as "monika@braves.com"
    
  Scenario:Checking Salesforce login with incorrect credantials 
  	When I am on "LoginPage"
    When I enter value of username as "123" and password as "2232"
    And click on login button
    Then I should get error message  as1 "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
    
    
     Scenario:Checking Salesforce login  with Forgot password link
    
    When I am on "LoginPage"
    And  I click  forgot password 
    When I enter value of username as "monika@braves.com"
    When I click Continue button
    And I click Return Button
    Then I should get page title as1 "Login | Salesforce"
    