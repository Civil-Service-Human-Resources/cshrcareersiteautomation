Feature: WP admin - create/amend groups/teams

  @groups
  Scenario: Create new team/group
    Given I am logged in as a techadmin
    And I navigate to the create new team page
    When I add a new team
    Then the team is added

  @groups
  Scenario: Edit team/group
    Given I am logged in as a techadmin
    And I create a new team
    When I edit the team
    Then the team is updated

  Scenario: Delete team/group
    Given I am logged in as a contentadmin
    And I create a new team
    When I choose to delete the just created team
    Then the team is deleted

  Scenario: Duplicate team/group
    Given I am logged in as a techadmin
    And I navigate to the create new team page
    When I try to add a team with the same name as an already existing team
    Then an error message indicating team already exists should be shown

