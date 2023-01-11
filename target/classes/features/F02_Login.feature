@smoke
Feature: F02_Login | users could use login functionality to use their accounts
  Scenario: user could login with valid email and password
  Given Step 1 user go to login page
  And Step 2 user login with "valid" "test@example.com" and "P@ssw0rd"
  When Step 3 user press on login button
  Then Step 4 user login to the system successfully

  Scenario: user could not login with invalid email and password
  Given Step 1 user go to login page
  And Step 2 user login with "invalid" "wrong@example.com" and "P@ssw0rd"
  When Step 3 user press on login button
  Then Step 4 user could not login to the system