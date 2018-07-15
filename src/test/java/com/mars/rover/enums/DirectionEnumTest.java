package com.mars.rover.enums;

import com.mars.rover.Plateau;
import com.mars.rover.Position;
import com.mars.rover.exception.MoveNotPossibleException;
import org.junit.Assert;
import org.junit.Test;


public class DirectionEnumTest {

  @Test
  public void testRightDirectionWhenEast() {

    DirectionEnum direction = DirectionEnum.E;
    DirectionEnum newDirection = direction.right();
    Assert.assertEquals(DirectionEnum.S, newDirection);
  }

  @Test
  public void testRightDirectionWhenWest() {

    DirectionEnum direction = DirectionEnum.W;
    DirectionEnum newDirection = direction.right();
    Assert.assertEquals(DirectionEnum.N, newDirection);
  }

  @Test
  public void testRightDirectionWhenSouth() {

    DirectionEnum direction = DirectionEnum.S;
    DirectionEnum newDirection = direction.right();
    Assert.assertEquals(DirectionEnum.W, newDirection);
  }

  @Test
  public void testRightDirectionWhenNorth() {

    DirectionEnum direction = DirectionEnum.N;
    DirectionEnum newDirection = direction.right();
    Assert.assertEquals(DirectionEnum.E, newDirection);
  }

  @Test
  public void testLeftDirectionWhenEast() {

    DirectionEnum direction = DirectionEnum.E;
    DirectionEnum newDirection = direction.left();
    Assert.assertEquals(DirectionEnum.N, newDirection);
  }

  @Test
  public void testLeftDirectionWhenWest() {

    DirectionEnum direction = DirectionEnum.W;
    DirectionEnum newDirection = direction.left();
    Assert.assertEquals(DirectionEnum.S, newDirection);
  }

  @Test
  public void testLeftDirectionWhenSouth() {

    DirectionEnum direction = DirectionEnum.S;
    DirectionEnum newDirection = direction.left();
    Assert.assertEquals(DirectionEnum.E, newDirection);
  }

  @Test
  public void testLeftDirectionWhenNorth() {

    DirectionEnum direction = DirectionEnum.N;
    DirectionEnum newDirection = direction.left();
    Assert.assertEquals(DirectionEnum.W, newDirection);
  }

  @Test
  public void testMoveWhenEast() throws MoveNotPossibleException {
    //given
    Position position = new Position(2, 2);
    Plateau plateau = new Plateau(5, 5);
    //when
    Position actual = DirectionEnum.E.move(position, plateau);
    //then
    Assert.assertEquals(new Position(3, 2), actual);
  }

  @Test
  public void testMoveWhenWest() throws MoveNotPossibleException {
    //given
    Position position = new Position(2, 2);
    Plateau plateau = new Plateau(5, 5);
    //when
    Position actual = DirectionEnum.W.move(position, plateau);
    //then
    Assert.assertEquals(new Position(1, 2), actual);
  }

  @Test
  public void testMoveWhenNorth() throws MoveNotPossibleException {
    //given
    Position position = new Position(2, 2);
    Plateau plateau = new Plateau(5, 5);
    //when
    Position actual = DirectionEnum.N.move(position, plateau);
    //then
    Assert.assertEquals(new Position(2, 3), actual);
  }

  @Test
  public void testMoveWhenSouth() throws MoveNotPossibleException {
    //given
    Position position = new Position(2, 2);
    Plateau plateau = new Plateau(5, 5);
    //when
    Position actual = DirectionEnum.S.move(position, plateau);
    //then
    Assert.assertEquals(new Position(2, 1), actual);
  }

  @Test(expected = MoveNotPossibleException.class)
  public void testMoveWhenEastNotMovable() throws MoveNotPossibleException {
    //given
    Position position = new Position(5, 2);
    Plateau plateau = new Plateau(5, 5);
    //when
    Position actual = DirectionEnum.E.move(position, plateau);
    //then
    Assert.assertEquals(new Position(5, 2), actual);
  }

  @Test(expected = MoveNotPossibleException.class)
  public void testMoveWhenWestNotMovable() throws MoveNotPossibleException {
    //given
    Position position = new Position(0, 2);
    Plateau plateau = new Plateau(5, 5);
    //when
    Position actual = DirectionEnum.W.move(position, plateau);
    //then
    Assert.assertEquals(new Position(0, 2), actual);
  }

  @Test(expected = MoveNotPossibleException.class)
  public void testMoveWhenNorthNotMovable() throws MoveNotPossibleException {
    //given
    Position position = new Position(2, 5);
    Plateau plateau = new Plateau(5, 5);
    //when
    Position actual = DirectionEnum.N.move(position, plateau);
    //then
    Assert.assertEquals(new Position(2, 5), actual);
  }

  @Test(expected = MoveNotPossibleException.class)
  public void testMoveWhenSouthNotMovable() throws MoveNotPossibleException {
    //given
    Position position = new Position(2, 0);
    Plateau plateau = new Plateau(5, 5);
    //when
    Position actual = DirectionEnum.S.move(position, plateau);
    //then
    Assert.assertEquals(new Position(2, 0), actual);
  }
}