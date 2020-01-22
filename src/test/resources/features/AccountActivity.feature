@accountActivity
Feature: Account Activity Page

  Background:
    Given the user is on the Account Activity Page

  Scenario: The Account Activity page has the correct title
    Then the title should be Zero - Account Activity

  Scenario: The default drop down menu option should be Savings
    Then the default drop down menu option should be Savings

  Scenario: The drop down menu should have the following options -
            Savings, Checking, Loan, Credit Card, and Brokerage
    Then the drop down menu should have the appropriate options

  @wip
  Scenario: The transactions table should have the columns
            Date, Description, Deposit, Withdrawal
    Then the transaction table should have the appropriate options