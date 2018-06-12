Feature: GDPR privacy notice template
  Scenario: Add new privacy notice page
    Given I am logged in as a techadmin
    When I add a GDPR privacy notice page from the settings menu
    Then the GDPR page should be available via a new left hand menu item
    And the the GDPR link in the footer should also link to the just created GDPR page