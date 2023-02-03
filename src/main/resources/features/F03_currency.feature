@smoke
Feature: F03_Currency | Currency display correctly according to selection

  Scenario: Currency display correctly according to selection
    Given  user press on currency button and selects euro
    Then € should be displayed for product currency
