@smoke
Feature: currencies | customer can choose currency type that he would like to deal with
  Scenario: customer can deal with Euro
    When user select Euro currency from the dropdown list
    Then Euro Symbol € is shown on the 4 products displayed in Home page



