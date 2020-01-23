@accountActivityNavigation
Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given the user is logged in

   Scenario: Savings account redirect
     When the user clicks on the Savings link on the Account Summary page
     Then the Account Activity page should be displayed
     And the Account drop down should have Savings selected

  Scenario: Brokerage account redirect
     When the user clicks on the Brokerage link on the Account Summary page
     Then the Account Activity page should be displayed
     And the Account drop down should have Brokerage selected

  Scenario: Checking account redirect
     When the user clicks on the Checking link on the Account Summary page
     Then the Account Activity page should be displayed
     And the account Drop down should have Checking selected

  Scenario: Credit Card account redirect
     When the user clicks on the Credit Card link on the Account Summary page
     Then the Account Activity page should be displayed
     And the Account drop down should have Credit Card selected

  Scenario: Loan account redirect
     When the user clicks on the Loan link on the Account Summary page
     Then the Account Activity page should be displayed
     And the Account drop down should have Loan selected