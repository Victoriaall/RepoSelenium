Feature: Hotel Star Rating

Scenario Outline: Verify hotel shows up as star rating selected by user
Given I am on hotels landing page
And I typed in New York into the search bar
And I select New York, New York, United States of America from auto-suggestions
And I press the search button
Then I am on default locations search result screen
When I click on <star> star
And I verify hotels are <star> star rating
Examples:
| star |
| 5    |
| 4    |
| 3    |
| 2    |
| 1    |