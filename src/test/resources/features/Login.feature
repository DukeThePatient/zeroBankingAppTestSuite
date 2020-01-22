@login @smoke
Feature: Login Page

  Background:
    Given The user is on the login page

  Scenario: User should be able to login with valid credentials
    When The user enters valid credentials
    Then The user should be able to log in

  Scenario: User should not be able to login with invalid credentials
    When the user enters invalid credentials
    Then the user should get an error message

  Scenario: User should not be able to login with no credentials
    When the user enters no credentials
    Then the user should get an error message