Feature: WP admin - create/amend users

  Scenario: Create new user
    Given I am logged in as a techadmin
    And I am on the create new user page
    When I create a new user with a default role and a team
    Then a user is created
    And I should be able to login with the newly created user

  Scenario: Reassign role for a user
  Scenario: Reassign group for a user
  Scenario: Delete user





