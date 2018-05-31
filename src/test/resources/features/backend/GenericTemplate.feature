Feature: Generic template

  Scenario: Content Author can create page using generic page template
    Given I am logged in as a contentauthor
    And I navigate to pages menu
    When I add a page with the generic page template and assigned to team1
    And I add content to generic page
    And I save the page
    And I send the page for approval
    When the publisher publishes the page
    Then the page is published
    And the published Generic page has all the elements as defined in the table above
