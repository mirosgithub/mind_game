package nz.ac.auckland.se281.engine;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.cli.MessageCli;
import nz.ac.auckland.se281.cli.Utils;
import nz.ac.auckland.se281.model.Colour;

public class Human extends Player {

  private List<Colour> colourHistory;

  public Human(String name) {
    super(name);
    colourHistory = new ArrayList<>();
  }

  public void play() {
    // prompt for colours
    MessageCli.ASK_HUMAN_INPUT.printMessage();
    readColourInput();

    // validate input
    while (colour == null || guess == null) {
      // print error message
      MessageCli.INVALID_HUMAN_INPUT.printMessage();
      readColourInput();
    }

    // store colour history
    colourHistory.add(colour);
  }

  private void readColourInput() {
    // read input
    String input = Utils.scanner.nextLine().trim();
    String[] inputs = input.split("\\s+");

    // convert to Colour enum
    if (inputs.length == 2) {
      colour = Colour.fromInput(inputs[0]);
      guess = Colour.fromInput(inputs[1]);
    }
  }

  public int getColourCount(Colour colour) {
    int count = 0;

    for (Colour history : colourHistory) {
      if (history == colour) {
        count++;
      }
    }

    return count;
  }
}
