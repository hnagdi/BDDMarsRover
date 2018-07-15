package com.mars.rover.exception;

import com.mars.rover.enums.DirectionEnum;
import com.mars.rover.Position;

public class MoveNotPossibleException extends CommandExecutionException {

  public MoveNotPossibleException(Position position, DirectionEnum direction) {
    super("Can't move from position " + position + " into direction " + direction);
  }
}
