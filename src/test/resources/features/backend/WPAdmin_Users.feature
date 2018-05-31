Feature: WP admin - create/amend users

  Scenario: Create new user
    Given I am logged in as a techadmin
    And I am on the create new user page
    When I create a new user with a default role and a team
    Then a user is created
    And I should be able to login with the newly created user

  Scenario: Cannot create user without a default group assigned
    Given I am logged in as a techadmin
    And I am on the create new user page
    When I try to create a new user without a default team
    Then the user is not created

  Scenario: Admin should not be able to remove the default team
    Given I am logged in as a techadmin
    And I create a new user
    And I navigate to edit user page
    When I try to remove the default team associated with the user
    Then the user is not updated

  Scenario: Reassign role for a user
    Given I am logged in as a contentadmin
    And I create a new user
    And I navigate to edit user page
    When I reassign role for the user
    Then the user role should be updated

  Scenario: Reassign group for a user
    Given I am logged in as a techadmin
    And I create a new user
    And I navigate to edit user page
    When I assign a new group for the user
    Then the user groups should be updated

  Scenario: Delete user
    Given I am logged in as a contentadmin
    And I create a new user
    When I choose to delete the just created user
    Then the user is deleted
