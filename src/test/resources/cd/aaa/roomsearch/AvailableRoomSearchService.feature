Feature: Room search service

  Scenario: Basic Room Search With Valid Inputs
    Given A Guest Trying to Find Rooms
    When They Enter bangalore as the destination
    And 1-jan-2016 , 5-Jan-2016 as from and to Dates
    Then We should Return some results

  Scenario: Basic Room Search With Invalid Dates
    Given A Guest Trying to Find Rooms
    When They Enter bangalore as the destination
    And 1-jan-2014 , 5-Jan-2014 as from and to Dates
    Then We should Return an error message
