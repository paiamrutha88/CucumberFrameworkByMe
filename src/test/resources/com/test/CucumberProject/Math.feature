#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@sanity @dataproviders
Feature: Maths operations

  @add
  Scenario Outline: Add two numbers
    Given I have number <a>
    And I have number <b>
    When I click on add button
    And User selects age category
      | Age      |
      | below 18 |
      | Above 18 |
    And User selects state and country
      | State | Country |
      | KA    | India   |
      | AZ    | US      |
    And I get result

    Examples: 
      | a | b |
      | 2 | 3 |
      | 5 | 5 |

  @substract
  Scenario Outline: Subtract two numbers
    Given I have number <a>
    And I have number <b>
    When I click on subtract button
    And I get result

    Examples: 
      | a | b |
      | 2 | 3 |
      | 5 | 5 |

  @multiply
  Scenario: multiply two numbers
    Given I want to write a step with precondition
    And some other precondition
    When I complete action
    And some other action
    And yet another action
    Then I validate the outcomes
    And check more outcomes

  @divide
  Scenario: divide one number by another
    Given I want to write a step with precondition
    And some other precondition
    When I complete action
    And some other action
    And yet another action
    Then I validate the outcomes
    And check more outcomes
