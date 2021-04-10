Feature: Selenium Challenge Feature

  Scenario: Verify NEJM Home Page items
    When I am on the nejm home page "https://www.nejm.org/"
    Then I verify the NEJM home page header buttons should be displayed
    And I store All the search results for the searched word "Heart"
