Feature: Home page template

  Scenario: Content Author can create page using home page template
    Given I am logged in as a contentauthor
    And I navigate to pages menu
    When I add a page with the home page template and assigned to team1
    #And I edit the home page
    And I fill in the form template
    |sections_sub_sections      		|field_name       |field_type    |max_characters|mandatory |
    |Billboard                  		|Heading          |input         |70            |true      |
    |Billboard                  		|Intro text       |textarea      |350           |true      |
    |Billboard                  		|Image            |image         |              |true      |
    |Content Block Vertical     		|Image            |image         |              |true      |
    |Content Block Vertical     		|Quote            |textarea      |200           |true      |
    |Content Block Vertical     		|Forename         |input         |25            |true      |
    |Content Block Vertical     		|Surname          |input         |25            |true      |
    |Content Block Vertical     		|Role             |input         |50            |true      |
    |Content Block with CTA     		|Heading          |input         |70            |true      |
    |Content Block with CTA     		|Paragraph 1      |textarea      |450           |true      |
    |Content Block with CTA     		|Paragraph 2      |textarea      |450           |false     |
    |Content Block with CTA     		|CTA text         |input         |25            |true      |
    |Content Block with CTA     		|CTA target       |input         |              |true      |
    |Content Block with CTA + Image     |Heading          |input         |70            |true      |
    |Content Block with CTA + Image     |Paragraph 1      |textarea      |450           |true      |
    |Content Block with CTA + Image     |Paragraph 2      |textarea      |450           |false     |
    |Content Block with CTA + Image     |CTA text         |input         |25            |true      |
    |Content Block with CTA + Image     |CTA target       |input         |              |true      |
    |Content Block with CTA + Image     |Image            |image         |              |true      |
    |Content Block Image                |Heading          |input         |70            |true      |
    |Content Block Image                |Body             |textarea      |450           |true      |
    |Content Block Image         		|Image            |image         |              |true      |
    |Content Block Promo         		|Promo tag        |input         |25            |true      |
    |Content Block Promo         		|Heading          |input         |150           |true      |
    |Content Block Promo        		|Heading target   |input         |           	|true      |
    |Content Block Promo        		|Paragraph 1      |textarea      |450           |true      |
    |Content Block Promo,CTA        	|Text before      |input      	 |150           |true      |
    |Content Block Promo,CTA        	|Target text      |input      	 |150           |true      |
    |Content Block Promo,CTA        	|Target link      |input         |	            |true      |
    |Content Block Promo,CTA        	|Text after       |input      	 |150           |true      |
    And I save the page
    Then the home preview page has all the elements as defined in the table above
    And I send the page for approval
    When the publisher publishes the page
    Then the page is published