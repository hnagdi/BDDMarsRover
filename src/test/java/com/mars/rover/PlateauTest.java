package com.mars.rover;

import org.junit.Assert;
import org.junit.Test;

public class PlateauTest {

  @Test
  public void testEqualsPlateauIsSame() {
    Plateau plateau1 = new Plateau(1, 2);
    Plateau plateau2 = new Plateau(1, 2);
    Assert.assertEquals(plateau1, plateau2);
  }

  @Test
  public void testNotEqualsXIsSame() {
    Assert.assertNotEquals(new Plateau(1, 2), new Plateau(1, 3));
  }

  @Test
  public void testNotEqualsYIsSame() {
    Assert.assertNotEquals(new Plateau(1, 3), new Plateau(2, 3));
  }

  @Test
  public void testNotEqualsPlateauAreDifferent() {
    Assert.assertNotEquals(new Plateau(1, 2), new Plateau(3, 4));
  }

  @Test
  public void testNotEqualsWhenOnePlateauIsNull() {
    Assert.assertNotEquals(new Plateau(1, 2), null);
  }

  @Test
  public void testWhenPositionExist() {
    Plateau plateau = new Plateau(5, 6);
    Assert.assertTrue(plateau.isPositionExists(new Position(5, 6)));
    Assert.assertTrue(plateau.isPositionExists(new Position(5, 0)));
    Assert.assertTrue(plateau.isPositionExists(new Position(0, 6)));
    Assert.assertTrue(plateau.isPositionExists(new Position(2, 2)));
  }

  @Test
  public void testWhenPositionDoNotExist() {
    Plateau plateau = new Plateau(5, 6);
    Assert.assertFalse(plateau.isPositionExists(new Position(6, 6)));
    Assert.assertFalse(plateau.isPositionExists(new Position(5, 7)));
    Assert.assertFalse(plateau.isPositionExists(new Position(-1, 6)));
    Assert.assertFalse(plateau.isPositionExists(new Position(5, -1)));
  }
}
