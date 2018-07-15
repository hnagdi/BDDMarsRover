Feature: Turn rover over plateau
  As a rover operator
  I want rover to make turns
  So that the rover is turn able

  Scenario Outline: Turn rover
    Given rover is facing <CurrentDirection>
    When rover turns <TurnCommand>
    Then rover should be facing <NextDirection>
    Examples: turn left
      | TurnCommand | CurrentDirection | NextDirection |
      | L           | N                | W             |
      | L           | S                | E             |
      | L           | E                | N             |
      | L           | W                | S             |
    Examples: turn right
      | TurnCommand | CurrentDirection | NextDirection |
      | R           | N                | E             |
      | R           | S                | W             |
      | R           | E                | S             |
      | R           | W                | N             |