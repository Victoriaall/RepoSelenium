#
Feature: Login
  # feature and scenario work sap. Given , then are mostly used.

  Background:
    Given I entered '<email>' as email
    And I entered '<password>' as password
    And I press signin button

  Scenario: Entered correct credentials
    Then I clicked on my profile

  Scenario: Entered correct credentials
    Then I clicked on my settings

  Scenario Outline: Entered correct credentials
    Given I entered '<email>' as email
    And I entered '<password>' as password
    And I press signin button

    Examples:
      | email          | password    |
      | test@gmail.com | password123 |
      | blah@z.come    | passs0000   |


  Scenario: Entered correct credentials
    Given I entered the correct credentials
    And I press signin button
    Then I verify correct login message


  Scenario: Entered incorrect credentials
    Given I entered the incorrect credentials
    And I press signin button
    Then I verify incorrect login message
