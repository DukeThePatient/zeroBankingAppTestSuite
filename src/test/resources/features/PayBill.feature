@payBills
Feature: Pay Bills Page

  Background:
    Given the user is on the Pay Bills page

  Scenario: The Pay Bills page should have the title Zero - Pay Bills
    Then the page title should be Zero - Pay Bills

  Scenario: The page should display "The payment was successfully submitted" with a successful
            Pay operation
    When the user completes a successful pay operation
    Then the page should display the correct confirmation message

  Scenario: The page should display an error message when user does not enter the amount
    When the user does not enter an amount into the Amount field
    Then the page should display the correct error message for the Amount field

  Scenario: The page should display an error message when user does not enter a date
    When the user does not enter a date into the Date field
    Then the page should display the correct error message for the Date field

  Scenario: The Amount field should not accept alphabetical
    When the user enters alphabetical into the Amount field
    Then the page should display the correct error message for the Amount field
@wip
  Scenario: The Date field should not accept alphabetical characters
    When the user enters alphabetical into the Date field
    Then the page should display the correct error message for the Date field

  Scenario: The Amount field should not accept special characters
    When the user enters special characters into the Amount field
    Then the page should display the correct error message for the Amount field