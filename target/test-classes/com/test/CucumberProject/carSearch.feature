@Functional
Feature: Validation of Car search page
In order to validate car search
as a buyer
I navigate to https://www.carsguide.com.au/

@CarSearch
Scenario Outline: Searching for a new car
Given I navigate to carsSiteUrl homepage
When  I move mouse to buySell_xpath menu
Then I click on searchCars_xpath field
And I select <make> in make_xpath dropdown
And I select <model> in model_xpath dropdown
And I select <location> in location_xpath dropdown
And I select <price> in price_xpath dropdown
And I click on findCar_xpath field
Then I get list of searched cars <make>
And the page title should be pageTitleKey

Examples: 
|make|model   |location |price  |
|BMW |1 Series|ACT - All|$10,000|

@CarSearch-dynamicmenu
Scenario Outline: Searching for a new car
Given I navigate to carsSiteUrl homepage
When  I move mouse to menu
|menu			 		|
|buySell_xpath|
Then I click on searchCars_xpath field
And I select <make> in make_xpath dropdown
And I select <model> in model_xpath dropdown
And I select <location> in location_xpath dropdown
And I select <price> in price_xpath dropdown
And I click on findCar_xpath field
Then I get list of searched cars <make>
And the page title should be pageTitleKey

Examples: 
|make|model   |location |price  |
|BMW |1 Series|ACT - All|$10,000|
