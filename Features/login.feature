Feature: all login scenarios


  Background: open browser
    Given i open browser
    And I maximize

  @login @valid
  Scenario: to test the functionality of login button for valid input
    Given I am on login page
  #  When I enter username and password
    When I enter "admin" and "admin" as username & password
    And I click on login button
    Then I should be redirected to home page

  @login @invalid
  Scenario: to test the functionality of login button for invalid input
    Given I am on login page
    #When I enter invalid username and password
    When I enter "dsdsd" and "dsds" as username & password
    And I click on login button
    Then I should get an error

  @login @invalid @blank
  Scenario: to test the functionality of login button for blank input
    Given I am on login page
  #  When I enter blank username and password
    When I enter "" and "" as username & password
    And I click on login button
    Then I should get an error


  @addCustomer
  Scenario: to test the functionality of login button for blank input
    Given I am on login page
    When I enter "admin" and "admin" as username & password
    And I click on login button
    And I click on add customer link
    And I enter below Data
      | mangesh124 | xyz | 787878878 | 78787878 |
    And I click on submit


  @addCustomerMultipleData
  Scenario Outline: to test the functionality of login button for blank input
    Given I am on login page
    When I enter "admin" and "admin" as username & password
    And I click on login button
    And I click on add customer link
    And I enter the Data <name> , <address> , <contact1> , <contact2>
    And I click on submit
    Examples:
      | name        | address            | contact1 | contact2 |
      | John Smith  | 1234 Elm St, NY    | 555-1234 | 555-5678 |
      | Jane Doe    | 5678 Oak St, CA    | 555-8765 | 555-4321 |
      | Alice Brown | 9101 Maple Ave, TX | 555-3456 | 555-7890 |
      | Bob Johnson | 1122 Pine Dr, FL   | 555-6543 | 555-0987 |