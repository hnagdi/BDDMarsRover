Feature: Move rover
  As a rover operator
  I want the rover to move
  So that the rover is movable

  Scenario Outline: Move rover
    Given rover is positioned at (<X>, <Y>)
    And rover is facing <CurrentDirection>
    And plateau dimension is (<length>, <width>)
    When rover moves forward
    Then rover should be positioned at (<NextX>, <NextY>)
    Examples: Rover is movable
      | CurrentDirection | X | Y | NextX | NextY | length | width |
      | N                | 1 | 2 | 1     | 3     | 5      | 5     |
      | E                | 1 | 2 | 2     | 2     | 5      | 5     |
      | W                | 1 | 2 | 0     | 2     | 5      | 5     |
      | S                | 1 | 2 | 1     | 1     | 5      | 5     |
    Examples: Rover is not movable
      | CurrentDirection | X | Y | NextX | NextY | length | width |
      | N                | 5 | 5 | 5     | 5     | 5      | 5     |
      | E                | 5 | 5 | 5     | 5     | 5      | 5     |
      | W                | 0 | 0 | 0     | 0     | 5      | 5     |
      | S                | 0 | 0 | 0     | 0     | 5      | 5     |