@ui
Feature: Some basic coverage of a generic app

  Scenario: When I navigate to Google there is a search button
    When I navigate to Google
    Then there is a 'Google Search' button
