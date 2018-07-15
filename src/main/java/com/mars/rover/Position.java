package com.mars.rover;

import java.util.Objects;

public class Position {

  private int x;
  private int y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Position getRightNeighbour() {
    return new Position(this.x + 1, y);
  }

  public Position getLeftNeighbour() {
    return new Position(this.x - 1, y);
  }

  public Position getTopNeighbour() {
    return new Position(this.x, y + 1);
  }

  public Position getBelowNeighbour() {
    return new Position(this.x, y - 1);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Position position = (Position) o;
    return x == position.x &&
      y == position.y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  @Override
  public String toString() {
    return "Position{" + "x=" + x +
      ", y=" + y +
      '}';
  }
}
