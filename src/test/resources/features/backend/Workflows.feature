Feature: Workflows

  Scenario: Author saves to draft

  Scenario: Author submits content, content approver approves , publisher approves and publishes
    Given I am logged in as a contentauthor
    And I add a new page with the default template and submit for review
    When the content approver approves my request
    And the content publisher approves my request
    Then the page is published

  Scenario: Author submits, content approver rejects with comments
    Given I am logged in as a contentauthor
    And I add a new page with the default template and submit for review
    When the content approver rejects author's request with comments
    Then the content is sent back to the author for review

  Scenario: Author submits, content approver approves publisher rejects with comments, sends it back to author
    Given I am logged in as a contentauthor
    And I add a new page with the default template and submit for review
    And the content approver approves my request
    When the content publisher rejects my request
    Then the content is sent back to the author for review


  #Scenario: Workflows history


  Scenario: Unpublish
    Given I am logged in as a contentauthor
    And get a page published
    When I request to unpublish as content approver
    Then the page is unpublished


  #Scenario: Revise

  Scenario: Delete Pages
    Given I am logged in as a contentauthor
    And I add a page with delete action and submit the workflow
    And the content approver approves my request
    And the content publisher approves my request
    Then the page is deleted

  #Scenario: Abort workflow

  #Scenario: What should happen when two approvers are selected?

  #Scenario: E2E user, group, role test

  #Scenario: Delete Pages1
    #Given I am logged in as a contentauthor
    #And I delete all pages with team assigned


