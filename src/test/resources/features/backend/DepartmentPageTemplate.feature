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