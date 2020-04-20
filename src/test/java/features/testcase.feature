Feature: Validating API End Point
Scenario: Verify if the API response is matched
	Given GetPost API with id is "1"
	When user calls GetPost API with GET http request
	Then "id" in response body is "1"
	And "title" in response body is "Post1"