Feature: Department landing page template

  @deletepage
  Scenario: Content Author can create page using Department landing page template
    Given I am logged in as a contentauthor
    And I navigate to pages menu
    When I add a page with the Department Landing page template and assigned to team1
    #When I edit the Department landing page
    And I fill in the form template
    |sections_sub_sections      |field_name       |field_type    |max_characters|mandatory |   repeater |
    |Billboard                  |Heading          |input         |70            |true      |            |
    |Billboard                  |Intro text       |textarea      |350           |true      |            |
    |Billboard                  |Image            |image         |              |true      |            |
    |List repeater,Items        |Logo             |Image         |              |true      |    10      |
    |List repeater,Items        |Logo text line 1 |input         | 25           |true      |    10      |
    |List repeater,Items        |Logo text line 2 |input         | 25           |false     |    10      |
    |List repeater,Items        |Logo text line 3 |input         | 25           |false     |    10      |
    |List repeater,Items        |Body             |textarea      |450           |true      |    10      |
    |List repeater,Items        |Target           |input         |              |true      |    10      |
    |List repeater,Items        |Image            |image         |              |true      |    10      |
    |Content Block Vertical     |Image            |image         |              |true      |            |
    |Content Block Vertical     |Quote            |textarea      |200           |true      |            |
    |Content Block Vertical     |Forename         |input         |25            |true      |            |
    |Content Block Vertical     |Surname          |input         |25            |true      |            |
    |Content Block Vertical     |Role             |input         |50            |true      |            |
    And I save the page
    And the Department landing preview page has all the elements as defined in the table above
    And I send the page for approval
    When the publisher publishes the page
    Then the page is published
