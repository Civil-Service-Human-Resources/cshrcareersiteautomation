Feature: Cookie banner

  Scenario: Cookie banner present first time and not present for future visits
    Given I am on the career site for the first time
    Then I see the cookie banner
    When I refresh the page
    Then the cookie banner is not shown
