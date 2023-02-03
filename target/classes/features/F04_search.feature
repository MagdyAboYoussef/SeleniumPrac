@smoke
Feature: F04_hover | User could search using product name or serial

  Scenario Outline: user could search using product name
    When user searches for "<product>"
    Then "<product>" should appear in the search results
#
    Examples:
      | product |
      | book    |
      | laptop  |
      | nike    |


  Scenario Outline:	user could search for product using sku
    Given user searches for "<sku>"
    Then user clicks on each product and checks if sku matches"<sku>"
    Examples:
      |sku|
      |SCI_FAITH|
      |APPLE_CAM|
      |SF_PRO_11|