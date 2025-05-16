package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.cli.MessageCli;
import nz.ac.auckland.se281.cli.Utils;
import nz.ac.auckland.se281.model.Colour;

public class Human extends Player {

  public Human(String name) {
    super(name);
  }

  public void play() {
    // prompt for colours
    MessageCli.ASK_HUMAN_INPUT.printMessage();

    // read colour input
    readColourInput();

    // validate input
    while (colour == null || guess == null) {
      // print error message
      MessageCli.INVALID_HUMAN_INPUT.printMessage();

      // read colour input again
      readColourInput();
    }
  }

  private void readColourInput() {
    // read input
    String input = Utils.scanner.nextLine();
    String[] inputs = input.split(" ");

    // convert to Colour enum
    if (inputs.length == 2) {
      colour = Colour.fromInput(inputs[0]);
      guess = Colour.fromInput(inputs[1]);
    }
  }
  
}
