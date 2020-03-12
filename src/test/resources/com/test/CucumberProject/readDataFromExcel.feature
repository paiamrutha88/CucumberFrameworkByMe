@readFromExcel
Feature: This is a sample feature file

  Scenario Outline: This is a scenario to test datadriven test on Cucumber JVM.
    Given scenario data
    When executed from Runner Class
    Then UserName and Password shows on console form given <RowsNumber>.

    Examples:
      | RowsNumber |
      |     1      |
      |     2      |