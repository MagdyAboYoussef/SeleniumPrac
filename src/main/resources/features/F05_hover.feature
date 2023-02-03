@smoke
Feature: F05_hover | Hovering over element and asserting its href value is equal to hover value

  Scenario: title display correctly
    Given  user selects random category and selects random subcategory if exists
    Then sub category title is equal to title
