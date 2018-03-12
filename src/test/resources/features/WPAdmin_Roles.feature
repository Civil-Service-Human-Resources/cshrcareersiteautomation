Feature: WP admin - create ammend roles

  Scenario: Create new role

  Scenario: Edit role

  Scenario: Duplicate role
    Given I am logged in as a techadmin
    And I am on create new role page
    When I try to add a role with the same name as an already existing role
    Then an error message indicating role already exists should be shown


  Scenario: Delete role


