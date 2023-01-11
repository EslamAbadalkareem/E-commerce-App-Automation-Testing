@smoke
Feature: Register | users should be able to register with new accounts
  Scenario: user could register with valid data successfully
    Given user go to register page
    And user select gender type
    And user enter first name "automation" and last name "tester"
    And user enter date of birth
    And user enter email "test@example.com" field
    And user fills Password fields "P@ssw0rd" "P@ssw0rd"
    When user clicks on register button
    Then success message should be displayed