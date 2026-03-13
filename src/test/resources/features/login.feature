Feature: login
  As a card operations user,
  I want to be able to log in to my account,
  So I can get authentication to use the card payment request management application

Scenario Outline: Successful login
  Given the "<Username>" and "<Password>" combination is in the database
  When I make a POST request with my username and password
  Then the application should generate a JWT token with claims that is valid for one hour
  Examples:
    |Username|Password|
    |admin   |password|

  Scenario: Unsuccessful login
    Given the user name and password combination given is not in the database
    Then the application should return an error informing the user that the credentials are incorrect

