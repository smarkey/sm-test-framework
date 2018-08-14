@ui
Feature: Use the website to find restaurants
	So that I can order food
	As a hungry customer
	I want to be able to find restaurants in my area

Scenario: Search for restaurants in an area
	Given I want food in "AR51 1AA"
	When I search for restaurants
	Then I should see some restaurants in "AR51 1AA"

Scenario: Browse for restaurants in an area by cuisine
	Given I want food in "AR51 1AA"
	When I browse for "Italian" restaurants
	Then I should see some chinese restaurants in "AR51 1AA"

Scenario: Search for restaurants in an area and filter on cuisine
	Given I want food in "AR51 1AA"
	And I search for restaurants
	And I should see some restaurants in "AR51 1AA"
	When I filter on "African"
	Then I should see 1 result
	And the top result is "Eng - Luke - Orderpad - Test Restaurant"