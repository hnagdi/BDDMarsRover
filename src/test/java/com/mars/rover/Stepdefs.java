package com.mars.rover;

import com.mars.rover.enums.CommandEnum;
import com.mars.rover.enums.DirectionEnum;
import com.mars.rover.exception.CommandExecutionException;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {

  private Rover rover;

  @Given("^rover is facing (.)$")
  public void rover_is_facing(String direction) {
    if (rover == null) {
      Plateau fakePlateau = new Plateau(5, 5);
      Position fakePosition = new Position(1, 1);
      rover = new Rover(fakePlateau, fakePosition, DirectionEnum.valueOf(direction));
    } else {
      rover.setDirection(DirectionEnum.valueOf(direction));
    }
  }

  @Given("^plateau dimension is \\((\\d+), (\\d+)\\)$")
  public void plateau_dimension_is(int length, int width) {
    Plateau plateau = new Plateau(length, width);
    if (rover == null) {
      Plateau fakePlateau = new Plateau(5, 5);
      Position fakePosition = new Position(2, 2);
      DirectionEnum fakeDirection = DirectionEnum.E;
      rover = new Rover(fakePlateau, fakePosition, fakeDirection);
    } else {
      rover.setPlateau(plateau);
    }
  }

  @When("^rover turns (.)$")
  public void rover_turns(String roverCommand) throws CommandExecutionException {
    rover.execute(CommandEnum.valueOf(roverCommand));
  }

  @Given("^rover is positioned at \\((\\d+), (\\d+)\\)$")
  public void rover_is_positioned_at(int x, int y) {
    Position position = new Position(x, y);
    if (rover == null) {
      Plateau fakePlateau = new Plateau(5, 5);
      DirectionEnum fakeDirection = DirectionEnum.E;
      rover = new Rover(fakePlateau, position, fakeDirection);
    } else {
      rover.setPosition(position);
    }
  }

  @Then("^rover should be facing (.)$")
  public void rover_should_be_facing(String direction) {
    Assert.assertEquals(DirectionEnum.valueOf(direction), rover.getDirection());
  }

  @When("^rover moves forward$")
  public void rover_moves_forward() {
    try {
      rover.execute(CommandEnum.M);
    } catch (CommandExecutionException e) {
      System.out.print(e.getMessage());
    }
  }

  @Then("^rover should be positioned at \\((\\d+), (\\d+)\\)$")
  public void rover_should_be_positioned_at(int x, int y) {
    Position expectedPosition = new Position(x, y);
    Assert.assertEquals(expectedPosition, rover.getPosition());
  }

  @When("^rover receives command (.)$")
  public void rover_receives_command(String command) throws CommandExecutionException {
    if (rover == null) {
      Position fakePosition = new Position(2, 2);
      DirectionEnum fakeDirection = DirectionEnum.E;
      Plateau fakePlateau = new Plateau(5, 5);
      rover = new Rover(fakePlateau, fakePosition, fakeDirection);
    }

    CommandEnum commandToExecute = CommandEnum.valueOf(command);
    rover.execute(commandToExecute);
  }
}
