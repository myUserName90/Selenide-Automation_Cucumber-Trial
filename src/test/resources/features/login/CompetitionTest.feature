Feature: Test for SportsBook Filters

  Background:
    Given I am an authenticated user

#  @Regression
  Scenario: Validation of SportsBook Filters Sports
    When I visit competitions page
    And select "Pre-match" from Live Pre-Match dropdown field
    And select "Football" from Sports dropdown field
    And select "Spain" from Region dropdown field
    And select "Primera Division" from Competition dropdown field
    And select "Android" from Source dropdown field
    And select "Both" from is Test dropdown field
    And set year from "2010" to "2019", day from "1" to "24"
    And apply filter
    Then The result should have 1 rows
    Then The End


  Scenario: Validation of SportsBook Filters short
    When I visit competitions page
    And select "Pre-Match" from Live Pre-Match dropdown field
    And select "Football" from Sports dropdown field
    And select "Both" from is Test dropdown field
    And set year from "2010" to "2019", day from "1" to "24"
    And apply filter
    Then The result should have 22 rows
    Then The End

  @Regression
  Scenario: Validation of Bets Report page
    When I visit Bets Reports page
    And choose "BetBuilder, Alphabet" from Bet Type dropdown field
    And select "Created" from Time type dropdown field
    And select "Accepted" from State dropdown field
    And type "49283475" in Bet ID field
    And type "49283475" in Player ID field
    And select "Pre-Match" from is Live dropdown field
    And set year from "2010" to "2019", day from "1" to "24"
    And select "Football" from Sports dropdown field
    And select "Germany" from Region dropdown field
    And select "Bundesliga" from Competition dropdown field
    And select "United States dollar" from Currency dropdown field
    And select "t2" from Betshop Group dropdown field
    And select "Free Spin Jackpot" from Betshop dropdown field
    And select "000" from Cashdesk dropdown field
    And type "123" in Bet Number field
    And type "009833421" in Barcode field
    And type "Username" in Username field
    And type "00101" in Match Id field
    And type "432234" in External Id field
    And select "Yes" from Players Connected to a Betshop dropdown field
    And select "t2" from Client Betshop Group dropdown field
    And select "0" from Client Cashdesk dropdown field
    And type "2" in Stake min field
    And type "2000" in Stake max field
    And type "3" in Winning min field
    And type "3000" in Winning max field
    And type "4" in Price min field
    And type "4000" in Price max field
    And type "5" in Selection Count min field
    And type "5000" in Selection Count max field
    And select "FreeBet" from Bonus Type dropdown field
    And select "Yes" from Is Cashdesk Paid dropdown field
    And select "Agent (A)" from Is Player Category dropdown field
    And select "Android" from Source dropdown field
    And select "No" from Is Recalculated dropdown field
    And select "Not Test" from Is Test dropdown field
    And select "Yes" from Is Super Bet dropdown field
    And select "0" from Cashdesk Info dropdown field
    And type "169.254.0.0" in IP Address max field
    And apply filter
    Then The result should have 1 rows
    Then The End