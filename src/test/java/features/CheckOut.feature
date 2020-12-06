Feature:
  As a user of pod-login I want to be able to make different selections for my car of choice with the correct price displayed

  Scenario:
    Given I am on the checkout page
    When I select any car with different features of my choice
    Then the correct price of the selected features should be displayed at the bottom of the page
