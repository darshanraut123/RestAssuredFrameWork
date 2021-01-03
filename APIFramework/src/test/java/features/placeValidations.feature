Feature: Validation of place APIs

Scenario Outline: Verify if the place is successfully added using AddPlaceAPI
Given add place with payload as "<Name>" name "<Address>" address "<Language>" language
When user calls "AddPlaceApi" with post http request
Then the api call is success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"

Examples:
|Name	|Address		|Language	|
|darshan|Frontline house|English	|	