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
  private boolean gameOn = false;

  public Game() {}

  public void newGame(Difficulty difficulty, int numRounds, String[] options) {
    // configure game settings
    this.difficulty = difficulty;
    this.numRounds = numRounds;
    this.currentRound = 0;

    // initialise players
    ai = AiFactory.createAi(AI_NAME, this.difficulty);
    human = new Human(options[0]);

    // set opponents
    ai.setOpponent(human);
    human.setOpponent(ai);

    // greet human player
    MessageCli.WELCOME_PLAYER.printMessage(human.getName());

    gameOn = true;
  }

  public void play() {
    if (!gameOn) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
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
    awardPoints(ai);
    awardPoints(human);

    // end game in the last round
    if (currentRound == numRounds) {
      showStats();
      endGame();
    }
  }

  public void showStats() {
    if (!gameOn) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    MessageCli.PRINT_PLAYER_POINTS.printMessage(ai.getName(), ai.getTotalPoints());
    MessageCli.PRINT_PLAYER_POINTS.printMessage(human.getName(), human.getTotalPoints());
  }

  public void awardPoints(Player player) {
    int points = 0;

    if (player.getGuess().equals(player.getOpponent().getColour())) {
      points += 1;
      if (player.getGuess().equals(powerColour)) {
        points += 2;
      }
    }

    player.setPoints(points);

    MessageCli.PRINT_OUTCOME_ROUND.printMessage(player.getName(), points);
  }

  public void endGame() {
    MessageCli.PRINT_END_GAME.printMessage();
    if (ai.getTotalPoints() == human.getTotalPoints()) {
      MessageCli.PRINT_TIE_GAME.printMessage();
    } else if (ai.getTotalPoints() > human.getTotalPoints()) {
      MessageCli.PRINT_WINNER_GAME.printMessage(ai.getName());
    } else {
      MessageCli.PRINT_WINNER_GAME.printMessage(human.getName());
    }

    gameOn = false;
  }
}
