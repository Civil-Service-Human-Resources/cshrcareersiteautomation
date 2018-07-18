Feature: Department page template

  Scenario: Content Author can create page using department page template
    Given I am logged in as a contentauthor
    And I navigate to pages menu
    When I add a page with the department page template and assigned to team1
    And I fill in the form template
    |sections_sub_sections      |field_name       |field_type    |max_characters|mandatory |   repeater |
    |Billboard                  |Heading          |input         |75            |true      |            |
    |Billboard                  |Intro text       |textarea      |350           |true      |            |
    |Billboard                  |Image            |image         |              |true      |            |
    |Main content               |Heading          |input         |50            |true      |            |
    |Main content               |Paragraph 1      |textarea      |400           |true      |            |
    |Main content               |Paragraph 2      |textarea      |400           |true      |            |
    |Main content               |Image 1          |image         |              |false     |            |
    |Main content               |Paragraph 3      |textarea      |400           |true      |            |
    |Main content               |Image 2          |image         |              |false     |            |
    |Main content               |Paragraph 4      |tinymce       |              |false     |            |
    |Content Block Vertical     |Image            |image         |              |true      |            |
    |Content Block Vertical     |Quote            |textarea      |300           |true      |            |
    |Content Block Vertical     |Forename         |input         |25            |true      |            |
    |Content Block Vertical     |Surname          |input         |25            |true      |            |
    |Content Block Vertical     |Role             |input         |150           |true      |            |
    |Factoid                    |Fact             |input         |100           |true      | 3          |
    |Content Block Horizontal   |Image            |image         |              |true      |            |
    |Content Block Horizontal   |Quote            |textarea      |300           |true      |            |
    |Content Block Horizontal   |Forename         |input         |25            |true      |            |
    |Content Block Horizontal   |Surname          |input         |25            |true      |            |
    |Content Block Horizontal   |Role             |input         |150            |true     |            |
    |Content Block Horizontal   |Extra text       |tinymce       |150           |true      |            |
    |Sub content                |Heading          |input         |50            |true      |            |
    |Sub content                |Intro            |textarea      |500           |true      |            |
    |Sub content,Driver         |Image            |image         |              |true      | 2          |
    |Sub content,Driver         |Headline         |input         |75            |true      | 2          |
    |Sub content,Driver         |Link             |input         |              |true      | 2          |
    |Sub content,Driver         |Text             |textarea      |175          |true       | 2          |
    And I save the page
    And I send the page for approval
    When the publisher publishes the page
    Then the page is published
    And the published departments page has all the elements as defined in the table above
