Feature: Preview link for non authenticated users
  Scenario: Preview link for non-authenticated users expires in configured time
  #on prod the expire time is set to 48hrs and on test it is set to 1 min
  Given I am logged in as a contentauthor
  And I add a new page with the default template and save as draft
  And I logout
  When I view the preview link as a non-authentiated user
  Then I can see the preview for 1 min before the link expires
