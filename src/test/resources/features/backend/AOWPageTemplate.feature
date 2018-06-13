Feature: AOW page template

  Scenario: Content Author can create page using AOW page template
    Given I am logged in as a contentauthor
    And I navigate to pages menu
    When I add a page with the AOW page template and assigned to team1
    And I fill in the form template
    |sections_sub_sections      |field_name       |field_type    |max_characters|mandatory |   repeater |
    |Billboard                  |Heading          |input         |70            |true      |            |
    |Billboard                  |Intro text       |textarea      |350           |true      |            |
    |Billboard                  |Image            |image         |              |true      |            |
    |Main content               |Heading          |input         |65            |true      |            |
    |Main content               |Paragraph 1      |textarea      |400           |true      |            |
    |Main content               |Paragraph 2      |textarea      |400           |true      |            |
    |Main content               |Image 1          |image         |              |false     |            |
    |Main content               |Paragraph 3      |textarea      |400           |true      |            |
    |Main content               |Paragraph 4      |tinymce        |  150        |false     |            |
    |Main content               |Image 2          |image         |              |false     |            |
    |Content Block Vertical     |Image            |image         |              |true      |            |
    |Content Block Vertical     |Quote            |textarea      |300           |true      |            |
    |Content Block Vertical     |Forename         |input         |25            |true      |            |
    |Content Block Vertical     |Surname          |input         |25            |true      |            |
    |Content Block Vertical     |Role             |input         |150           |true      |            |
    |Sub repeater,Items         |Heading          |input         |150           |true      |    3       |
    |Sub repeater,Items         |Heading target   |input         |              |true      |    3       |
    |Sub repeater,Items         |Body             |textarea      |350           |true      |    3       |
    |Sub repeater,Items         |Image            |image         |              |true      |    3       |
    |Sub Content Multiple,Content Area Content Block With 3 Paras         |Heading               |input             |50              |true      | 2           |
    |Sub Content Multiple,Content Area Content Block With 3 Paras         |Paragraph 1           |textarea         |450              |true      | 2           |
    |Sub Content Multiple,Content Area Content Block With 3 Paras         |Paragraph 2           |tinymce         |150              |true      | 2           |
    |Sub Content Multiple,Content Area Content Block With 3 Paras         |Paragraph 3           |textarea         |450              |true      | 2           |
    |Listing                    |Heading            |input      |50           |true      |            |
    |Listing,Items              |Item               |input      |50           |true      | 8           |
    And I save the page
    And I send the page for approval
    When the publisher publishes the page
    Then the page is published
    And the published AOW page has all the elements as defined in the table above
