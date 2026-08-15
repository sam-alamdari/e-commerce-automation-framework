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

  Scenario Outline: Unsuccessful login with invalid credentials
    Given the user is on the home page
    When the user opens the login form
    And the user enters "<username>" and "<password>"
    And the user clicks the login button
    Then the login error message should be "<message>"

    Examples:
      | username            | password           | message              |
      | sam_automation_test | wrongPassword1     | Wrong password.      |
      | sam_automation_test | wrongPassword2     | Wrong password.      |
      | invalid_user_123    | invalidPassword123 | User does not exist. |