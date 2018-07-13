Feature: Community page template

  Scenario: Content Author can create page using community page template
    Given I am logged in as a contentauthor
    And I navigate to pages menu
    When I add a page with the community page template and assigned to team1
    And I fill in the form template
    |sections_sub_sections      |field_name       |field_type    |max_characters|mandatory |   repeater |
    |Billboard                  |Logo text        |input         |60            |true      |            |
    |Billboard                  |Logo             |image         |              |true      |            |
    |Billboard                  |Heading          |input         |75            |true      |            |
    |Billboard                  |Paragraph 1      |textarea      |200           |true      |            |
    |Billboard                  |Paragraph 2      |textarea      |200           |true      |            |
    |Billboard                  |Paragraph 3      |textarea      |200           |true      |            |
    |Billboard                  |Paragraph 4      |textarea      |200           |false     |            |
    |Billboard                  |Image            |image         |              |true      |            |
    |Main content repeater      |Heading          |input         |65            |true      |    6       |
    |Main content repeater      |Image            |image         |              |false     |    6       |
    |Main content repeater      |Body             |tinymce       |              |true      |    6       |
    |Media embed                |Media link       |link          |              |true      |            |
    |Media embed                |Quote            |textarea      |300           |true      |            |
    |Media embed                |CTA text         |input         |150           |true      |            |
    |Media embed                |CTA target       |link          |              |true      |            |
    |Content Block Vertical     |Image            |image         |              |true      |            |
    |Content Block Vertical     |Quote            |textarea      |300           |true      |            |
    |Content Block Vertical     |Forename         |input         |25            |true      |            |
    |Content Block Vertical     |Surname          |input         |25            |true      |            |
    |Content Block Vertical     |Role             |input         |150           |true      |            |
    |Content Block Vertical     |Heading          |input         |80            |false     |            |
    |Content Block Vertical     |Body             |tinymce       |              |false     |            |
    |Content Block Vertical     |Link text        |input         |150           |false     |            |
    |Content Block Vertical     |Link             |link          |              |false     |            |
    |Sub content with Image     |Heading          |input         |50            |true      |            |
    |Sub content with Image     |Body             |textarea      |              |true      |            |
    |Sub content with Image     |Image1           |image         |              |true      |            |
    |Sub content with Image     |Image2           |image         |              |true      |            |
    |Content Block with CTAs    |1Heading         |input         |70            |true      |            |
    |Content Block with CTAs    |1Paragraph 1     |textarea      |350           |true      |            |
    |Content Block with CTAs    |1Paragraph 2     |textarea      |350           |true      |            |
    |Content Block with CTAs    |1CTA text        |input         |25            |true      |            |
    |Content Block with CTAs    |1CTA target      |link          |              |true      |            |
    |Content Block with CTAs    |2Heading         |input         |70            |true      |            |
    |Content Block with CTAs    |2Paragraph 1     |textarea      |350           |true      |            |
    |Content Block with CTAs    |2Paragraph 2     |textarea      |350           |true      |            |
    |Content Block with CTAs    |2CTA text        |input         |25            |true      |            |
    |Content Block with CTAs    |2CTA target      |link          |              |true      |            |
    And I save the page
    And I send the page for approval
    When the publisher publishes the page
    Then the page is published
    #And the published AOW landing page has all the elements as defined in the table above
