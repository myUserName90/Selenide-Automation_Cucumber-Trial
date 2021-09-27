Feature: Test for Bets Report Page

  Background:
    Given I am an authenticated user


  @Regression
  Scenario: Validation of filter by Time Type option
    When I visit Bets Reports page
    And set "Vbet" as a partner
    And select "Calculation" from Time type dropdown field
    And set year from "2010" to "2021", day from "1" to "1"
    And apply filter
    Then The result should have 1255 rows
    Then The End

  @Regression
  Scenario: Validation of resetting filter fields
    When I visit Bets Reports page
    And set year from "2010" to "2021", day from "01" to "01"
    And choose "Select All" from Bet Type dropdown field
    And select "Accepted" from State dropdown field
    And type "123456" in Bet ID field
    And type "123456" in Client Id field
    And select "Pre-Match" from is Live dropdown field
    And select "Football" from Sports dropdown field
    And select "World" from Region dropdown field
    And select "International Champions Cup" from Competition dropdown field
    And select "Real Madrid CF - AS Roma" from Match dropdown field
    And select "No" from Is Bonus dropdown field
    And type "123456" in Player ID field
    And
    And apply filter
    Then
    Then all other fields should be empty

  @Regression
    Scenario: Valid
    And select "Calculation" from Time type dropdown field



