package com.mars.rover;

import org.junit.Assert;
import org.junit.Test;

public class PositionTest {

  @Test
  public void testEqualsPositionIsSame() {
    Position Position1 = new Position(1, 2);
    Position Position2 = new Position(1, 2);
    Assert.assertEquals(Position1, Position2);
  }

  @Test
  public void testNotEqualsRoverXPositionIsSame() {
    Assert.assertNotEquals(new Position(1, 2), new Position(1, 3));
  }

  @Test
  public void testNotEqualsRoverYPositionIsSame() {
    Assert.assertNotEquals(new Position(1, 3), new Position(2, 3));
  }

  @Test
  public void testNotEqualsPositionAreDifferent() {
    Assert.assertNotEquals(new Position(1, 2), new Position(3, 4));
  }

  @Test
  public void testNotEqualsWhenOnePositionIsNull() {
    Assert.assertNotEquals(new Position(1, 2), null);
  }

  @Test
  public void testGetRightNeighbour() {
    Position actual = new Position(1, 2);
    Position expected = new Position(2, 2);
    Assert.assertEquals(expected, actual.getRightNeighbour());
  }

  @Test
  public void testGetLeftNeighbour() {
    Position actual = new Position(1, 2);
    Position expected = new Position(0, 2);
    Assert.assertEquals(expected, actual.getLeftNeighbour());
  }

  @Test
  public void testGetTopNeighbour() {
    Position actual = new Position(1, 2);
    Position expected = new Position(1, 3);
    Assert.assertEquals(expected, actual.getTopNeighbour());
  }

  @Test
  public void testGetBelowNeighbour() {
    Position actual = new Position(1, 2);
    Position expected = new Position(1, 1);
    Assert.assertEquals(expected, actual.getBelowNeighbour());
  }
}
