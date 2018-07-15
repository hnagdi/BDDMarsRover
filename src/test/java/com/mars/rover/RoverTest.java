package com.mars.rover;

import com.mars.rover.enums.CommandEnum;
import com.mars.rover.enums.DirectionEnum;
import com.mars.rover.exception.CommandExecutionException;
import com.mars.rover.exception.MoveNotPossibleException;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RoverTest {

  @Test
  public void testLeftTurnCommandWhenFacingEast() throws CommandExecutionException {
    Rover rover = new Rover(null, null, DirectionEnum.E);
    rover.execute(CommandEnum.L);
    Assert.assertEquals(DirectionEnum.N, rover.getDirection());
  }


  @Test
  public void testLeftTurnCommandWhenFacingSouth() throws CommandExecutionException {
    Rover rover = new Rover(null, null, DirectionEnum.S);
    rover.execute(CommandEnum.L);
    Assert.assertEquals(DirectionEnum.E, rover.getDirection());
  }


  @Test
  public void testLeftTurnCommandWhenFacingWest() throws CommandExecutionException {

    Rover rover = new Rover(null, null, DirectionEnum.W);
    rover.execute(CommandEnum.L);
    Assert.assertEquals(DirectionEnum.S, rover.getDirection());
  }

  @Test
  public void testLeftTurnCommandWhenFacingNorth() throws CommandExecutionException {
    Rover rover = new Rover(null, null, DirectionEnum.N);
    rover.execute(CommandEnum.L);
    Assert.assertEquals(DirectionEnum.W, rover.getDirection());
  }

  @Test
  public void testRightTurnCommandWhenFacingEast() throws CommandExecutionException {
    Rover rover = new Rover(null, null, DirectionEnum.E);
    rover.execute(CommandEnum.R);
    Assert.assertEquals(DirectionEnum.S, rover.getDirection());
  }


  @Test
  public void testRightTurnCommandWhenFacingSouth() throws CommandExecutionException {
    Rover rover = new Rover(null, null, DirectionEnum.S);
    rover.execute(CommandEnum.R);
    Assert.assertEquals(DirectionEnum.W, rover.getDirection());
  }


  @Test
  public void testRightTurnCommandWhenFacingWest() throws CommandExecutionException {

    Rover rover = new Rover(null, null, DirectionEnum.W);
    rover.execute(CommandEnum.R);
    Assert.assertEquals(DirectionEnum.N, rover.getDirection());
  }

  @Test
  public void testRightTurnCommandWhenFacingNorth() throws CommandExecutionException {
    Rover rover = new Rover(null, null, DirectionEnum.N);
    rover.execute(CommandEnum.R);
    Assert.assertEquals(DirectionEnum.E, rover.getDirection());
  }

  @Test
  public void testGetWestDirection() throws CommandExecutionException {
    Rover rover = new Rover(null, null, DirectionEnum.W);

    Assert.assertEquals(DirectionEnum.W, rover.getDirection());
  }

  @Test
  public void testGetEastDirection() {
    Rover rover = new Rover(null, null, DirectionEnum.E);

    Assert.assertEquals(DirectionEnum.E, rover.getDirection());
  }

  @Test
  public void testSetEastDirection() {
    Rover rover = new Rover(null, null, DirectionEnum.W);
    rover.setDirection(DirectionEnum.E);
    Assert.assertEquals(DirectionEnum.E, rover.getDirection());
  }

  @Test
  public void testSetPosition() {
    Position Position = new Position(1, 3);
    Position newPosition = new Position(2, 4);
    Rover rover = new Rover(null, Position, DirectionEnum.W);
    rover.setPosition(newPosition);
    Assert.assertEquals(newPosition, rover.getPosition());
  }

  @Test
  public void testSetPlateau() {
    Plateau plateau = new Plateau(1, 3);
    Plateau newPlateau = new Plateau(3, 3);
    Rover rover = new Rover(plateau, null, DirectionEnum.W);
    rover.setPlateau(newPlateau);
    Assert.assertEquals(newPlateau, rover.getPlateau());
  }

  @Test
  public void testMoveRoverWhenFacingEast() throws CommandExecutionException {
    //given
    Plateau plateau = new Plateau(5, 5);
    Position Position = new Position(1, 3);
    Position expectedPosition = new Position(2, 3);
    Rover rover = new Rover(plateau, Position, DirectionEnum.E);
    //when
    rover.execute(CommandEnum.M);
    //then
    assertThat(expectedPosition, equalTo(rover.getPosition()));
  }

  @Test
  public void testMoveRoverWhenFacingWest() throws CommandExecutionException {
    //given
    Plateau plateau = new Plateau(5, 5);
    Position Position = new Position(1, 3);
    Position expectedPosition = new Position(0, 3);
    Rover rover = new Rover(plateau, Position, DirectionEnum.W);
    //when
    rover.execute(CommandEnum.M);
    //then
    assertThat(expectedPosition, equalTo(rover.getPosition()));
  }

  @Test
  public void testMoveRoverWhenFacingNorth() throws CommandExecutionException {
    //given
    Plateau plateau = new Plateau(5, 5);
    Position Position = new Position(1, 3);
    Position expectedPosition = new Position(1, 4);
    Rover rover = new Rover(plateau, Position, DirectionEnum.N);
    //when
    rover.execute(CommandEnum.M);
    //then
    assertThat(expectedPosition, equalTo(rover.getPosition()));
  }

  @Test
  public void testMoveRoverWhenFacingSouth() throws CommandExecutionException {
    //given
    Plateau plateau = new Plateau(5, 5);
    Position Position = new Position(1, 3);
    Position expectedPosition = new Position(1, 2);
    Rover rover = new Rover(plateau, Position, DirectionEnum.S);
    //when
    rover.execute(CommandEnum.M);
    //then
    assertThat(expectedPosition, equalTo(rover.getPosition()));
  }

  @Test(expected = MoveNotPossibleException.class)
  public void testMoveRoverWhenFacingEastNotMovable() throws CommandExecutionException {
    //given
    Plateau plateau = new Plateau(5, 5);
    Position Position = new Position(5, 3);
    Position expectedPosition = new Position(5, 3);
    Rover rover = new Rover(plateau, Position, DirectionEnum.E);
    //when
    rover.execute(CommandEnum.M);
    //then
    assertThat(expectedPosition, equalTo(rover.getPosition()));
  }

  @Test(expected = MoveNotPossibleException.class)
  public void testMoveRoverWhenFacingWestNotMovable() throws CommandExecutionException {
    //given
    Plateau plateau = new Plateau(5, 5);
    Position Position = new Position(0, 3);
    Position expectedPosition = new Position(0, 3);
    Rover rover = new Rover(plateau, Position, DirectionEnum.W);
    //when
    rover.execute(CommandEnum.M);
    //then
    assertThat(expectedPosition, equalTo(rover.getPosition()));
  }

  @Test(expected = MoveNotPossibleException.class)
  public void testMoveRoverWhenFacingNorthNotMovable() throws CommandExecutionException {
    //given
    Plateau plateau = new Plateau(5, 5);
    Position Position = new Position(1, 5);
    Position expectedPosition = new Position(1, 5);
    Rover rover = new Rover(plateau, Position, DirectionEnum.N);
    //when
    rover.execute(CommandEnum.M);
    //then
    assertThat(expectedPosition, equalTo(rover.getPosition()));
  }

  @Test(expected = MoveNotPossibleException.class)
  public void testMoveRoverWhenFacingSouthNotMovable() throws CommandExecutionException {
    //given
    Plateau plateau = new Plateau(5, 5);
    Position Position = new Position(1, 0);
    Position expectedPosition = new Position(1, 0);
    Rover rover = new Rover(plateau, Position, DirectionEnum.S);
    //when
    rover.execute(CommandEnum.M);
    //then
    assertThat(expectedPosition, equalTo(rover.getPosition()));
  }
}
