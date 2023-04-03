@fasdfas
Feature: An example
  @RestAssured
  Scenario: Sending a GET request with query parameter and header
    Given the base URI is "https://jsonplaceholder.typicode.com"
    And the query parameter "postId" is set to "1"
    And the header "Authorization" is set to "Bearer token"
    When a GET request is sent to "/comments"
    Then the response status code should be 200
    And the response body should not be empty

  Scenario: Sending a POST request with a request body
    Given the base URI is "https://jsonplaceholder.typicode.com"
    And the request body is:
      """
      {
        "title": "foo",
        "body": "bar",
        "userId": 1
      }
      """
    When a POST request is sent to "/posts"
    Then the response status code should be 201
    And the response body should contain the field "id"