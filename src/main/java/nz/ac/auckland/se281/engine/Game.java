package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.cli.MessageCli;

public class Game {
  public static String AI_NAME = "HAL-9000";

  private int numRounds;
  private int currentRound;

  public Game() {}

  public void newGame(Difficulty difficulty, int numRounds, String[] options) {
    this.numRounds = numRounds;
    this.currentRound = 0;
    String playerName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
  }

  public void play() {
    currentRound++;
    
    // display round
    MessageCli.START_ROUND.printMessage(currentRound, numRounds);

    // prompt for colors
    MessageCli.ASK_HUMAN_INPUT.printMessage();
    
  }

  public void showStats() {}
}
