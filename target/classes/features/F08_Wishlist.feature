@smoke
Feature: F08_Wishlist | Success message appears when clicking on wishlist button
  Scenario: success message appears in green background when user add item to wishlist
    When user click on wishlist icon
    Then success message is displayed
    And background color is green

  Scenario: items should be added to wishlist page and Qty should be bigger than 0
    When user click on wishlist icon
    And user wait until this success message with green color to disappear
    When click on Wishlist Tab
    Then Verify qty value bigger than 0