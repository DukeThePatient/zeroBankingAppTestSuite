@accountSummary
Feature: Account Summary Page

  Background:
    Given the user is on the Account Summary page

  Scenario: The Account Summary page should have the correct title
    Then the title should be Zero - Account Summary

  Scenario: The Account Summary page should have the following account types -
            Cash Accounts, Investment Accounts, Credit Accounts, and Loan Accounts
    Then the Account Summary page should display the correct account types

  Scenario: The Credit Accounts table should have Account, Credit Card, and Balance columns
    Then the Credit Accounts table should display the correct account columns