Feature: WP admin - create/amend users

  Scenario: Create new user
    Given I am logged in as a techadmin
    And I am on the create new user page
    When I create a new user with a default role and a team
    Then a user is created
    And I should be able to login with the newly created user

  Scenario: Reassign role for a user
    Given I am logged in as a contentadmin
    #And I create a new user
    #And I login as the newly created user
    And I navigate to edit user page
    When I reassign role for the user
    Then the user role should be updated

  Scenario: Reassign group for a user
  Scenario: Delete user





