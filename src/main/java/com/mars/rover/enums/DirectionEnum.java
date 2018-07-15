package com.mars.rover.enums;

import com.mars.rover.Plateau;
import com.mars.rover.Position;
import com.mars.rover.exception.MoveNotPossibleException;

public enum DirectionEnum {
  S {
    @Override
    public DirectionEnum right() {
      return W;
    }

    @Override
    public DirectionEnum left() {
      return E;
    }

    @Override
    public Position move(Position position, Plateau plateau) throws MoveNotPossibleException {
      Position newPosition = position.getBelowNeighbour();
      if (plateau.isPositionExists(newPosition)) {
        return newPosition;
      }
      throw new MoveNotPossibleException(position, this);
    }
  }, N {
    @Override
    public DirectionEnum right() {
      return E;
    }

    @Override
    public DirectionEnum left() {
      return W;
    }

    @Override
    public Position move(Position position, Plateau plateau) throws MoveNotPossibleException {
      Position newPosition = position.getTopNeighbour();
      if (plateau.isPositionExists(newPosition)) {
        return newPosition;
      }
      throw new MoveNotPossibleException(position, this);
    }
  }, W {
    @Override
    public DirectionEnum right() {
      return N;
    }

    @Override
    public DirectionEnum left() {
      return S;
    }

    @Override
    public Position move(Position position, Plateau plateau) throws MoveNotPossibleException {
      Position newPosition = position.getLeftNeighbour();
      if (plateau.isPositionExists(newPosition)) {
        return newPosition;
      }
      throw new MoveNotPossibleException(position, this);
    }
  }, E {
    @Override
    public DirectionEnum right() {
      return S;
    }

    @Override
    public DirectionEnum left() {
      return N;
    }

    @Override
    public Position move(Position position, Plateau plateau) throws MoveNotPossibleException {
      Position newPosition = position.getRightNeighbour();
      if (plateau.isPositionExists(newPosition)) {
        return newPosition;
      }
      throw new MoveNotPossibleException(position, this);
    }
  };


  abstract public DirectionEnum right();


  abstract public DirectionEnum left();

  public abstract Position move(Position position, Plateau plateau) throws MoveNotPossibleException;
}
