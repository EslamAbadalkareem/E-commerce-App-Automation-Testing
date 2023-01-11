@smoke

Feature: Login | users should be able to login their accounts
  Scenario: user could login with valid email and password
  Given user go to login page
  And user login with "valid" "test@example.com" and "P@ssw0rd"
  When user press on login button
  Then user login to the system successfully

  Scenario: user could not login with invalid email and password
  Given user go to login page
  And user login with "invalid" "wrong@example.com" and "P@ssw0rd"
  When user press on login button
  Then Step 4 user could not login to the system