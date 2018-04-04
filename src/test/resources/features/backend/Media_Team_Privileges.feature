Feature: Media

  @media
  Scenario:  Users can use media assigned only to their team(content author is assigned to team1)
    Given I am logged in as a contentauthor
    When I navigate to the media page
    Then I see media assigned to team1
    And I do not see media assigned to team2

  @media
  Scenario:  Users can see media for two teams if they are assigned to two teams(content publisher is assigned to team1 and team2)
    Given I am logged in as a contentpublisher
    When I navigate to the media page
    Then I see media assigned to team1
    And I see media assigned to team2

