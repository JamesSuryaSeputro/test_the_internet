Feature: Login
  Scenario: Sucessful Login
    Given the user is on the login page
    When the user enters correct username
    And the user enters correct password
    Then the user should be logged in sucessfully

  Scenario Outline: Failed Login
    Given the user is on the login page
    When the user enters wrong "<username>" and "<password>"
    Then an error message should be displayed
    Examples:
    | username | password             |
    | tomsmith | 123456               |
    | 123456   | SuperSecretPassword! |