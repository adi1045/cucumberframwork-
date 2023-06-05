Feature: Login

@Sanity @regression
Scenario: Successful Login with valid credentials
  Given User Launch Chrome browser
  When User opens URL "http://admin-demo.nopcommerce.com/login"
  And user enters Email as "admin@yourstore.com" and password as "admin"
  And Click on Login
   Then page Title should be "Dashboard / nopCommerce administration"
   When User click on logout link
   Then page Title should be "Your store. Login"
   And close browser
 
 @regression
 Scenario Outline: Successful Login with valid credentials
   Given User launch the chrome browser
   When User opens URL "http://admin-demo.nopcommerce.com/login"
   And user enter Email as "<email>" and password as "<password>"
   And click on login
   Then page Title should be "Dashboard / nopCommerce administration"
   When User click on logout link
   Then page Title should be "Your store. Login"
   And close browser
   
Examples:
|email|password|
|admin@yourstore.com|admin|
|test@ourstore.com|admin|
  
 