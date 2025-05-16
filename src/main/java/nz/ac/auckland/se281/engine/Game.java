package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.cli.MessageCli;
import nz.ac.auckland.se281.cli.Utils;
import nz.ac.auckland.se281.model.Colour;

public class Game {
  public static String AI_NAME = "HAL-9000";

  private Player human;
  private int numRounds;
  private int currentRound;
  private Colour powerColour;

  public Game() {}

  public void newGame(Difficulty difficulty, int numRounds, String[] options) {
    this.numRounds = numRounds;
    this.currentRound = 0;
    this.human = new Player(options[0]);
    MessageCli.WELCOME_PLAYER.printMessage(human.getName());
  }

  public void play() {
    currentRound++;

    // display round
    MessageCli.START_ROUND.printMessage(currentRound, numRounds);

    // prompt for colours
    MessageCli.ASK_HUMAN_INPUT.printMessage();

    // get colour input
    getColourInput();

    // validate input
    while (human.getColour() == null || human.getGuess() == null) {
      // print error message
      MessageCli.INVALID_HUMAN_INPUT.printMessage();

      // get colour input again
      getColourInput();
    }

    // confirm action
    MessageCli.PRINT_INFO_MOVE.printMessage(human.getName(), human.getColour(), human.getGuess());

    // select power colour every 3 rounds
    if (currentRound % 3 == 0) {
      powerColour = Colour.getRandomColourForPowerColour();

      // announce the colour
      MessageCli.PRINT_POWER_COLOUR.printMessage(powerColour);
    }
  }

  public void showStats() {}

  private void getColourInput() {
    // read input
    String input = Utils.scanner.nextLine();
    String[] inputs = input.split(" ");

    // convert to Colour enum
    if (inputs.length == 2) {
      human.setColour(Colour.fromInput(inputs[0]));
      human.setGuess(Colour.fromInput(inputs[1]));
    }
  }
}
