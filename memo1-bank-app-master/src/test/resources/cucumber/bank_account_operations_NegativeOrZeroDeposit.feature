Feature: Bank account operations
  Checking bank account operations

  Scenario: Cannot deposit money when sum is negative
    Given Account with a balance of 200
    When Trying to deposit -100
    Then Operation should be denied due to negative sum
    And Account balance should remain 200


  Scenario: Cannot deposit money when sum is negative with small values
    Given Account with a balance of 2
    When Trying to deposit -1
    Then Operation should be denied due to negative sum
    And Account balance should remain 2

  Scenario: Cannot deposit money when sum is negative with big values
    Given Account with a balance of 2000
    When Trying to deposit -10000
    Then Operation should be denied due to negative sum
    And Account balance should remain 2000

  Scenario: Cannot deposit money when sum is zero
    Given Account with a balance of 2000
    When Trying to deposit 0
    Then Operation should be denied due to negative sum
    And Account balance should remain 2000
