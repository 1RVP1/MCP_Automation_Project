Feature: Amazon Search

  Background:
    Given user opens Amazon website

  Scenario: Validate Search Results UI
    When user searches for a product
    Then search results should be displayed

  Scenario: Validate Product Count
    When user searches for a product
    Then results count should be greater than zero