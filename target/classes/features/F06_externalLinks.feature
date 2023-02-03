@smoke
  Feature: F06_wishList | Clicking external link opens in a new tab and matches href

    Scenario Outline: F06_externalLinks | user is redirected to facebook/twitter/rss/youtube links
      Given user clicks on "<link>"
      And link opens in a new tab
      Then link matches
      Examples:
      |link|
      |Facebook|
      |Twitter|
      |RSS    |
      |YouTube|