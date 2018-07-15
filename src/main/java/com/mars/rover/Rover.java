package com.mars.rover;

import com.mars.rover.enums.CommandEnum;
import com.mars.rover.enums.DirectionEnum;
import com.mars.rover.exception.CommandExecutionException;

public class Rover {

  private DirectionEnum direction;
  private Position position;
  private Plateau plateau;

  public Rover(Plateau plateau, Position position, DirectionEnum direction) {
    this.plateau = plateau;
    this.direction = direction;
    this.position = position;

  }

  public void execute(CommandEnum command) throws CommandExecutionException {
    if (CommandEnum.L.equals(command)) {
      direction = direction.left();
    } else if (CommandEnum.M.equals(command)) {
      this.position = this.direction.move(this.position, this.plateau);
    } else {
      direction = direction.right();
    }
  }

  public DirectionEnum getDirection() {
    return direction;
  }

  public Position getPosition() {
    return this.position;
  }

  public void setDirection(DirectionEnum direction) {
    this.direction = direction;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public void setPlateau(Plateau plateau) {
    this.plateau = plateau;
  }

  public Plateau getPlateau() {
    return plateau;
  }
}
