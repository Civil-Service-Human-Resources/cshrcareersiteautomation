Feature: Department page template
  Scenario: Content Author can create page using department page template
    Given I am logged in as a contentauthor
    And I navigate to pages menu
    #When I add a page with the department page template and assigned to team1
    When I edit the page
    And I fill in Billboard section details in the template
      |field_name|field_type    |max_characters|mandatory |
      |Logo text |input         |45            |true      |
      |Logo      |image         |              |true      |
      |Heading   |input         |70            |true      |
      |Intro text|textarea      |350           |true      |
      |Image     |image         |              |true      |
    And I fill in Main content section details in the template
      |field_name       |field_type    |max_characters|mandatory |
      |Heading          |input         |40            |true      |
      |Paragraph 1      |textarea      |400           |true      |
      |Paragraph 2      |textarea      |400           |true      |
      |Image 1          |image         |              |false     |
      |Paragraph 3      |textarea      |400           |true      |
      |Image 2          |image         |              |false     |
    And I fill in Content Block Vertical section details in the template
      |field_name       |field_type    |max_characters|mandatory |
      |Image            |image         |              |true      |
      |Quote            |textarea      |200           |true      |
      |Forename         |input         |25            |true      |
      |Surname          |input         |25            |true      |
      |Role             |input         |50            |true      |
    And I fill in Factoid section details in the template
      |field_name       |field_type    |max_characters |mandatory | repeater |
      |Fact             |input         |100            |true      | 3        |
    And I fill in Content Block Horizontal section details in the template
       |field_name       |field_type    |max_characters|mandatory |
       |Image            |image         |              |true      |
       |Quote            |textarea      |200           |true      |
       |Forename         |input         |25            |true      |
       |Surname          |input         |25            |true      |
       |Role             |input         |50            |true      |
       |Extra text       |textarea      |500           |true      |
   
    And I fill in Sub content section details in the template
       |field_name       |field_type    |max_characters|mandatory |  repeater|subsection1|
       |Heading          |input         |40            |true      |          |           |
       |Intro            |textarea      |500           |true      |          |           |
       |Image            |image         |              |true      | 2        | Driver    |
       |Headline         |input         |40            |true      | 2        | Driver    |
       |Link             |input         |              |true      | 2        | Driver    |
       |Text             |textarea      |150           |true      | 2        | Driver    |
    And I save the page
    #Then the page is saved
    #And the departments preview page has the all the elements of the department page


  Scenario: temp test object
    Given I am logged in as a contentauthor
    And I navigate to pages menu
    #When I add a page with the department page template and assigned to team1
    When I edit the page
    And I fill in the form template
    |sections_sub_sections      |field_name       |field_type    |max_characters|mandatory |   repeater |
    |Billboard                  |Logo text        |input         |45            |true      |            |
    |Billboard                  |Logo             |image         |              |true      |            |
    |Billboard                  |Heading          |input         |70            |true      |            |
    |Billboard                  |Intro text       |textarea      |350           |true      |            |
    |Billboard                  |Image            |image         |              |true      |            |
    |Main content               |Heading          |input         |40            |true      |            |
    |Main content               |Paragraph 1      |textarea      |400           |true      |            |
    |Main content               |Paragraph 2      |textarea      |400           |true      |            |
    |Main content               |Image 1          |image         |              |false     |            |
    |Main content               |Paragraph 3      |textarea      |400           |true      |            |
    |Main content               |Image 2          |image         |              |false     |            |
    |Content Block Vertical     |Image            |image         |              |true      |            |
    |Content Block Vertical     |Quote            |textarea      |200           |true      |            |
    |Content Block Vertical     |Forename         |input         |25            |true      |            |
    |Content Block Vertical     |Surname          |input         |25            |true      |            |
    |Content Block Vertical     |Role             |input         |50            |true      |            |
    |Factoid                    |Fact             |input         |100           |true      | 3          |
    |Content Block Horizontal   |Image            |image         |              |true      |            |
    |Content Block Horizontal   |Quote            |textarea      |200           |true      |            |
    |Content Block Horizontal   |Forename         |input         |25            |true      |            |
    |Content Block Horizontal   |Surname          |input         |25            |true      |            |
    |Content Block Horizontal   |Role             |input         |50            |true      |            |
    |Content Block Horizontal   |Extra text       |textarea      |500           |true      |            |
    |Sub content                |Heading          |input         |40            |true      |            |
    |Sub content                |Intro            |textarea      |500           |true      |            |
    |Sub content,Driver         |Image            |image         |              |true      | 2          |
    |Sub content,Driver         |Headline         |input         |40            |true      | 2          |
    |Sub content,Driver         |Link             |input         |              |true      | 2          |
    |Sub content,Driver         |Text             |textarea      |150           |true      | 2          |
    #And I save the page
    Then the departments preview page has the all the elements of the department page
