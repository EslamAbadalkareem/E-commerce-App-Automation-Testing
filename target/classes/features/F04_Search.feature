@smoke
Feature: F04_Search | user could be able to search using product name or sku (serial number)
  Scenario Outline: user could be able to search using product name
    When user search using product <product_name> name
    Then user should be able to find items with product name
    Examples:
      |product_name  |
      |book          |
      |laptop        |
      |nike          |


  Scenario Outline: user could be able to search using product sku
    When user search using product <product_sku> sku
    Then the product sku shown in product page should contains the sku that you are using in search
    Examples:
      |product_sku  |
      |SCI_FAITH    |
      |APPLE_CAM    |
      |SF_PRO_11    |





