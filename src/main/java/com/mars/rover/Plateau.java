package com.mars.rover;

import java.util.Objects;

public class Plateau {

  private final int length;
  private final int width;

  public Plateau(int length, int width) {
    this.length = length;
    this.width = width;
  }

  public boolean isPositionExists(Position position) {
    int x = position.getX();
    int y = position.getY();
    return (x >= 0 && x <= this.length) && (y >= 0 && y <= this.width);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Plateau plateau = (Plateau) o;
    return length == plateau.length &&
      width == plateau.width;
  }

  @Override
  public int hashCode() {
    return Objects.hash(length, width);
  }
}
