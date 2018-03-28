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

  # No longer valid
  #Scenario: Author edits submitted content
    #Given I am logged in as a contentauthor
    #And I add a new page with the default template and submit for review
    #When I edit the page and save
    #Then the content approver should see my changes
    #And I should see the content author changes in the revision history

  #Scenario: Approver edits submitted content
    #Given I am logged in as a contentauthor
    #And I add a new page with the default template and submit for review
    #When I am logged in as a contentapprover
    #Then I should be able to edit the page and save
    #And I should see the content approver changes in the revision history

  #Scenario: Publisher edits submitted content before publishing
    #Given I am logged in as a contentauthor
    #And I add a new page with the default template and submit for review
    #And the content approver approves my request
    #When I am logged in as a contentpublisher
    #And I should be able to edit the page and publish
    #Then the edited page is published
    #And I should see the content publisher changes in the revision history


  Scenario: Workflows history

  #Blocked - Defect 866
  #Scenario: Unpublish
    #Given I am logged in as a contentauthor
    #And get a page published
    #When I request to unpublish as content approver
    #Then the page is unpublished


  Scenario: Revise

  Scenario: Delete Pages
    Given I am logged in as a contentauthor
    And I add a page with delete action and submit the workflow
    And the content approver approves my request
    And the content publisher approves my request
    Then the page is deleted

  Scenario: Abort workflow

  Scenario: What should happen when two approvers are selected?

  Scenario: E2E user, group, role test

