@smoke
Feature: F07_wishList | Adding element to wishlist is successful

  Scenario: Element is added to wishlist
    Given  user click on a product in the webpage
    And user clicks add to wishlist
    Then green msg appears saying it was added successfully and wishcart shows the item with qt higher than zero

