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

  Scenario: Team can see specific pages if assigned to them
    Given I am logged in as a contentpublisher
    And I add a new page with the default template and assigned to team2
    And I publish the page
    When I create a new user assigned to team2
    And I login as the newly created user
    Then I should be able to see the published page

  Scenario: Team cannot see pages if not assigned to them
    Given I am logged in as a contentpublisher
    And I add a new page with the default template and assigned to team1
    And I publish the page
    When I create a new user assigned to team1
    And I login as the newly created user
    Then I should not be able to see the published page

  Scenario: Two teams can see the same page if assigned to both of them
    Given I am logged in as a contentpublisher
    And I add a new page with the default template and assigned to team1 and team2
    And I publish the page
    When I create a new user assigned to team1
    And I login as the newly created user
    Then I should not be able to see the published page
