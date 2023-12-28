Feature: Login to Sauce Demo Mobile App
	Scenario: Login with valid credentials
		Given I am on the Sauce Demo Mobile App
		When I go to the login page
		And I enter username as "bob@example.com" and the passsword as "10203040"
		And I click on the login button
		Then I should see the inventory page display
		
	Scenario: Login with invalid credentials
		Given I am on the Sauce Demo Mobile App
		When I go to the login page
		And I enter username as "invalid@example.com" and the passsword as "123"
		And I click on the login button
		Then I should see the login page with incorrect credentials error is display
		 
	Scenario Outline: Testing login with valid/invalid credentials
		Given I am on the Sauce Demo Mobile App
		When I go to the login page
		And I enter username as "<username>" and the passsword as "<password>"
		And I click on the login button
		Then I should see "<expected result>"
		
		Examples: 
		| username 						| password 			| expected result
		| bob@example.com			| 10203040			| the inventory page display
		|	invalid@example.com	|	123						| the login page with incorrect credentials error is display
