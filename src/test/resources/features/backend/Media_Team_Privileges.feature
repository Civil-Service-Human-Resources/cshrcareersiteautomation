Feature: Media

  @media
  Scenario:  Users can use media assigned only to their team(content author is assigned to team1)
    Given I am logged in as a contentauthor
    When I navigate to the media page
    Then I see media assigned to team1
    And I do not see media assigned to team2

  @media
  Scenario:  Users can see media for two teams if they are assigned to both teams(content publisher is assigned to team1 and team2)
    Given I am logged in as a contentpublisher
    When I navigate to the media page
    Then I see media assigned to team1
    And I see media assigned to team2

  #Will be enabled after this has been implemented
  # @media
  #Scenario:  Content admin can see all images irrespective of teams assigned to the user
    #Given I am logged in as a contentadmin
    #When I navigate to the media page
    #Then I see media assigned to team1
    #And I see media assigned to team2

  Scenario Outline: Only accepted file types allowed in the media centre are jpg, jpeg, png, gif, svg, mp4 and delete media
    # Jpeg and png uploads already tested in @media before hook
    Given I am logged in as a techadmin
    When I upload media of type <media_type> and <file_name>
    Then the <file_name> of type <media_type> is uploaded
    And I can delete media of type <media_type> and file name <file_name>
    Examples:
      |media_type    |file_name         |
      | mp4         | testmp4.mp4       |
      | gif         | testgif.gif       |

  Scenario Outline: Max sizes for images and videos
    Given I am logged in as a techadmin
    When I try to upload <media_type> of name <file_name> and greater than max size of <file_size> configured
    Then an error message <error> is shown
    And the <media_type> of name <file_name> is not uploaded
    Examples:
    |media_type |file_name              |file_size | error|
    |image      |testimagemax.jpg       |450 kb    | too large|
    |video      |testmp4max.mp4         |12 mb     | exceeds the maximum|