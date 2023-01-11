@smoke
Feature: F01_Register | users could register with new accounts
  Scenario: guest user could register with valid data successfully
    Given Step 1 user go to register page
    And Step 2 user select gender type
    And Step 3 user enter first name "automation" and last name "tester"
    And Step 4 user enter date of birth
    And Step 5 user enter email "test@example.com" field
    And Step 6 user fills Password fields "P@ssw0rd" "P@ssw0rd"
    When Step 7 user clicks on register button
    Then Step 8 success message is displayed