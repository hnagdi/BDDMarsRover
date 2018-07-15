package com.mars.rover.exception;

import com.mars.rover.Position;
import com.mars.rover.enums.DirectionEnum;
import org.junit.Assert;
import org.junit.Test;

public class MoveNotPossibleExceptionTest {

  @Test
  public void testMessage() {
    Position position = new Position(5, 5);
    DirectionEnum direction = DirectionEnum.E;
    MoveNotPossibleException exception = new MoveNotPossibleException(position, direction);
    String expected = "Can't move from position " + position + " into direction " + direction;
    Assert.assertEquals(expected, exception.getMessage());
  }
}
