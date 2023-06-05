Feature: Customers

Background: Steps common for all scenarios
Given User Launch Chrome browser
  When User opens URL "http://admin-demo.nopcommerce.com/login"
  And user enters Email as "admin@yourstore.com" and password as "admin"
  And Click on Login
  Then User can view Dashboard
 
 @Sanity @regression 
Scenario: Add new Customer

  When User click on customers Menu
  And Click on customers Meni Item
  And Click on Add new button
  Then User can view add new customer page
  When User enters customer info
  And click on save button
  Then User can view confirmation message "The new customer has been added successfully."
  And close browser
  
  @regression
 Scenario: Search Customer by Email
 
  When User click on customers Menu
  And Click on customers Menu Item
  And Enter customer Email
  When Click on search button
  Then User should fpund Email in the search table
  And close browser
  
  @regression
 Scenario: Search Customer by Name
   When  User click on customers Menu
   And Click on customers Menu Item 
   And Enter customer FirstName
   And Enter customer LastName
   When Click on search button
   Then User should found Name in the Search table
   And Close browser
  
  
  
  
  
  
  