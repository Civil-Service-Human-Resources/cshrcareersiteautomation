Feature: Department page template
  Scenario: Content Author can create page using department page template
    Given I am logged in as a contentauthor
    And I navigate to pages menu
    When I add a page with the department page template and assigned to team1
    And I fill in billboard section details in the template
    |field_name|field_type    |max_characters|mandatory |
    |Logo text |input         |45            |true      |
    |Logo      |image         |              |true      |
    |Heading   |input         |70            |true      |
    |Intro text|textarea      |350           |true      |
    |Image     |image         |              |true      |
    #Then the page is saved
    #And the departments preview page has the all the elements of the department page