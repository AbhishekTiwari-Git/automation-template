Feature: NEJM Home Page Validation Feature

  Scenario: Verify NEJM Home Page items
    When I am on the nejm home page
    Then I verify the NEJM home page header buttons should be displayed
    And I store All the search results for the searched word "Heart" and search relevancy should be greater than 70.0
