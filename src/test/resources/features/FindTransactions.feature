@findTransactions
Feature: Find Transactions in Account Activity

  Background:
    Given the user accesses the Find Transactions Tab

  Scenario: Search date range "2012-09-01" to "2012-09-06"
    When the user enters date range from "2012-09-01" to "2012-09-06"
    And clicks find
    Then the results table should only show transactions dates between "2012-09-01" to "2012-09-06"
    And the results should be sorted by most recent date

  Scenario: Search date range "2012-09-02" to "2012-09-06"
    When the user enters date range from "2012-09-01" to "2012-09-06"
    And clicks find
    Then the results table should only show transactions dates between "2012-09-01" to "2012-09-06"
    And the results should be sorted by most recent date

  Scenario: Search description "ONLINE"
    When the user enters description "ONLINE"
    And clicks find
    Then the results table should only show descriptions containing "ONLINE"

  Scenario: Search description "OFFICE"
    When the user enters description "OFFICE"
    And clicks find
    Then the results table should only show descriptions containing "OFFICE"

  Scenario: Search description case insensitive
    When the user enters description "online"
    And clicks find
    Then the results table should only show descriptions containing "ONLINE"