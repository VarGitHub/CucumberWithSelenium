Feature: Deals feature
  Deals feature in the main CRM page

  Background:
    Given user logs in using valid email and password

  Scenario: Login to main CRM page
    When user clicks on login button
    Then user should on the main CRM page

  Scenario: Add new deal
    Given user clicks on Deals
    And user clicks on New button and enters new deals data
    When user clicks on save button
    Then the new deal title should be displayed

