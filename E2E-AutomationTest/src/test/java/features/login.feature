Feature: Login into Application

@Selenium-Test
Scenario Outline: Negative test validating login
Given Initialize the browser with chrome
And   Navigate to "https://www.salesforce.com/uk/" Site
And   Click on Login link home page to land on secure sign in Page
When  User enters <username> and <password> and logs in
Then  Verify that user is not successfully logged in
And   User close browsers

Examples: 
|username                                |password         |
|restricteduser@salesforce.com           |heartbeat1       |
|non-restricteduser@salesforce.com       |412345           |



