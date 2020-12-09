Feature: NEJM Home Page Validation Feature

  #Scenario: Verify NEJM Home Page items
    #When I am on the nejm home page
    #Then I verify the NEJM home page and header buttons should be displayed
    #And I store All the search results for the searched word "Heart" and search relevancy should be greater than 70.0
	
	Scenario: Verify My Account User information using web auth API
		Given I am on My Account NEJM Catalyst page
		And I Register user with the following details
		| Email  | Password | First Name  | Last Name | Name of Organization | 
		| TestQA | Test@1234| TestQA_fn   | TestQA_ln | MMS                  | 