
Feature: Login to Rediff money
  I want to use this template for my feature file

  @Login
  Scenario: Login to Rediff money
    Given I open chrome
    And I navigate to loginUrl
    And I type paiamrutha88@gmail.com in username_xpath field
    And I click on continueUname_xpath
    And I type caps9876 in password_xpath field
    And I click on continuePass_xpath
    Then Login should be success
    
  @xyz  
  Scenario: Login to xyz
    Given I open Mozilla
    And I navigate to https://portfolio.rediff.com/portfolio-login
    And I type paiamrutha88@gmail.com in username_xpath field
    And I click on continueUname_xpath
    And I type caps9876 in password_xpath field
    And I click on continuePass_xpath field 
    
   @quickLogin
    
  Scenario Outline: Login to Rediff money
    Given I open <browser>
    And I navigate to loginUrl
    And I login inside application
    |username|paiamrutha88@gmail.com|
    |password|caps9876|
   
    Then Login should be <result>
    
    Examples:
    |browser|result|
    |chrome|success|
    |mozilla|success|