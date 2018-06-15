Feature: Cleanup test data wherever possible

  Scenario: Cleanup users
    Given I am logged in as a techadmin
    When I delete all test users
    Then the all test users are deleted

  Scenario: Cleanup roles
    Given I am logged in as a techadmin
    When I delete all test roles
    Then the all test roles are deleted

  Scenario: Cleanup teams
    Given I am logged in as a techadmin
    When I delete all test teams
    Then the all test teams are deleted