Feature: AOW page template

  Scenario: Content Author can create page using AOW page template
    Given I am logged in as a contentauthor
    And I navigate to pages menu
    When I add a page with the AOW Landing page template and assigned to team1
    #When I edit the AOW landing page
    And I fill in the form template
    |sections_sub_sections      |field_name       |field_type    |max_characters|mandatory |   repeater |
    |Billboard                  |Heading          |input         |70            |true      |            |
    |Billboard                  |Intro text       |textarea      |350           |true      |            |
    |Billboard                  |Image            |image         |              |true      |            |
    |Main repeater,Items        |Heading          |input         |150           |true      |    10      |
    |Main repeater,Items        |Heading target   |input         |              |true      |    10      |
    |Main repeater,Items        |Body             |textarea      |450           |true      |    10      |
    |Main repeater,Items        |Image            |image         |              |true      |    10      |
    |Content Block Vertical     |Image            |image         |              |true      |            |
    |Content Block Vertical     |Quote            |textarea      |200           |true      |            |
    |Content Block Vertical     |Forename         |input         |25            |true      |            |
    |Content Block Vertical     |Surname          |input         |25            |true      |            |
    |Content Block Vertical     |Role             |input         |50            |true      |            |
    |Sub repeater,Items         |Heading          |input         |150           |true      |    3       |
    |Sub repeater,Items         |Heading target   |input         |              |true      |    3       |
    |Sub repeater,Items         |Body             |textarea      |350           |true      |    3       |
    |Sub repeater,Items         |Image            |image         |              |true      |    3       |
    And I save the page
    And the AOW landing preview page has all the elements as defined in the table above
    And I send the page for approval
    When the publisher publishes the page
    Then the page is published
