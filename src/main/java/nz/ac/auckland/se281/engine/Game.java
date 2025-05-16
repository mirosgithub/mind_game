package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.cli.MessageCli;
import nz.ac.auckland.se281.model.Colour;

public class Game {
  public static String AI_NAME = "HAL-9000";

  private Ai ai;
  private Human human;
  private Difficulty difficulty;
  private int numRounds;
  private int currentRound;
  private Colour powerColour;

  public Game() {}

  public void newGame(Difficulty difficulty, int numRounds, String[] options) {
    // configure game settings
    this.difficulty = difficulty;
    this.numRounds = numRounds;
    this.currentRound = 0;

    // initialise players
    ai = AiFactory.createAi(AI_NAME, this.difficulty);
    this.human = new Human(options[0]);

    // greet human player
    MessageCli.WELCOME_PLAYER.printMessage(human.getName());
  }

  public void play() {
    currentRound++;

    // display round
    MessageCli.START_ROUND.printMessage(currentRound, numRounds);

    // let each player play
    ai.play();
    human.play();

    // confirm actions
    MessageCli.PRINT_INFO_MOVE.printMessage(ai.getName(), ai.getColour(), ai.getGuess());
    MessageCli.PRINT_INFO_MOVE.printMessage(human.getName(), human.getColour(), human.getGuess());

    // set power colour every 3 rounds
    if (currentRound % 3 == 0) {
      powerColour = Colour.getRandomColourForPowerColour();
      MessageCli.PRINT_POWER_COLOUR.printMessage(powerColour);
    } else {
      // reset power colour
      powerColour = null;
    }

    // calculate and award points
    awardPoints(ai, human);
    awardPoints(human, ai);
  }

  public void showStats() {}

  public void awardPoints(Player player, Player opponent) {
    int points = 0;

    if (player.getGuess().equals(opponent.getColour())) {
      points += 1;
      if (player.getGuess().equals(powerColour)) {
        points += 2;
      }
    }

    MessageCli.PRINT_OUTCOME_ROUND.printMessage(player.getName(), points);
  }
}
