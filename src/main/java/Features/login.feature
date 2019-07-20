@feature1

Feature:UKVirgin Money application

Scenario Outline: Sanity Test Scenario

Given user is already on Login Page
When title of login page is Free CRM
Then Do what I say jaffa
Then user clicks on login button
Then Close the browser

Examples:
	| username | password |
	| vaasu  | manasa |	