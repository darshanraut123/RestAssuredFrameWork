Feature: Validation of place APIs

Scenario: Verify if the place is successfully added using AddPlaceAPI
Given add place payload
When user calls "AddPlaceApi" with post http request
Then the api call is success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"

