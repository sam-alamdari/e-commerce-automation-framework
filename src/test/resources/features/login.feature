Feature: User Login

  As a registered user
  I want to log in to the e-commerce application
  So that I can access my account

  Scenario: Successful login with valid credentials
    Given the user is on the home page
    When the user opens the login form
    And the user enters valid login credentials
    And the user clicks the login button
    Then the user should be logged in successfully