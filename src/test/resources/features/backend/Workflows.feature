Feature: Workflows

  Scenario: Author saves to draft

  Scenario: Author submits content, content approver approves , publisher approves and publishes
    Given I am logged in as a contentauthor
    And I add a new page with the default template
    When the content approver approves my request
    And the content publisher approves my request
    Then the page is published

  Scenario: Author submits, content approver rejects with comments
    Given I am logged in as a contentauthor
    And I add a new page with the default template
    When the content approver rejects author's request with comments
    Then the content is sent back to the author for review

  Scenario: Author submits, content approver approves publisher rejects with comments, sends it back to author
    Given I am logged in as a contentauthor
    And I add a new page with the default template
    And the content approver approves my request
    When the content publisher rejects my request
    Then the content is sent back to the author for review

  Scenario: Can the author edit submitted content?

  Scenario: Approver edits submitted content

  Scenario: Publisher edits submitted content before publishing

  Scenario: Workflows history

  Scenario: Unpublish

  Scenario: Revise

  Scenario: Delete Pages - Only Approver + Publisher?

  Scenario: Abort workflow

  Scenario: E2E user, group, role test

