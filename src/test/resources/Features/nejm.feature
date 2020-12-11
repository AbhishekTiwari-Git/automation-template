Feature: NEJM Home Page Validation Feature

  #Scenario: Verify NEJM Home Page items
    #When I am on the nejm home page
    #Then I verify the NEJM home page and header buttons should be displayed
    #And I store All the search results for the searched word "Heart" and search relevancy should be greater than 70.0
	
	Scenario: Verify My Account User information using web auth API
		Given I am on My Account NEJM Catalyst page
		When I Register user with the following details
			| Email  | Password | First Name  | Last Name | Name of Organization | 
			| TestQA | Test@1234| TestQA_fn   | TestQA_ln | MMS                  |
		And I sign out of the application
		And I navigate to the Auth token url
		Then I verify that user is logged in automatically
		And I verify My Account Saved section displayed with a message
		And I verify My Account Alert Section displays the following checkboxes "Connect" "Editors' Picks" "General Information"	
		And I verify that My account summary section displayed with a message
		