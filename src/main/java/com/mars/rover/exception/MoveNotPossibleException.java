package com.mars.rover.exception;

import com.mars.rover.Position;
import com.mars.rover.enums.DirectionEnum;

public class MoveNotPossibleException extends CommandExecutionException {

  public MoveNotPossibleException(Position position, DirectionEnum direction) {
    super("Can't move from position " + position + " into direction " + direction);
  }
}
