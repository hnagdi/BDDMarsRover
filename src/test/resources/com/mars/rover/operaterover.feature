Feature: Operate rover over plateau
  As a rover operator
  I want the rover to accept a series of commands
  So that the rover can arrive at the desired location

  Scenario Outline: Operate rover
    Given rover is positioned at (<X>, <Y>)
    And rover is facing <CurrentDirection>
    And plateau dimension is (<length>, <width>)
    When rover receives command <Command>
    Then rover should be positioned at (<NextX>, <NextY>)
    And rover should be facing <NextDirection>
    Examples: Rover is movable
      | Command | CurrentDirection | X | Y | NextDirection | NextX | NextY | length | width |
      | L       | N                | 1 | 2 | W             | 1     | 2     | 5      | 5     |
      | M       | W                | 1 | 2 | W             | 0     | 2     | 5      | 5     |
      | L       | W                | 0 | 2 | S             | 0     | 2     | 5      | 5     |
      | M       | S                | 0 | 2 | S             | 0     | 1     | 5      | 5     |
      | L       | S                | 0 | 1 | E             | 0     | 1     | 5      | 5     |
      | M       | E                | 0 | 1 | E             | 1     | 1     | 5      | 5     |
      | L       | E                | 1 | 1 | N             | 1     | 1     | 5      | 5     |
      | M       | N                | 1 | 1 | N             | 1     | 2     | 5      | 5     |
      | M       | N                | 1 | 2 | N             | 1     | 3     | 5      | 5     |