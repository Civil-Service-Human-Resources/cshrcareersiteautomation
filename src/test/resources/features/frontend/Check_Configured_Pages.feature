Feature: Sanity check prod pages

  Scenario: Home page
    Given I am on the home page
    Then I should see all configured home page contents
    And I verify all the links on the home page work

