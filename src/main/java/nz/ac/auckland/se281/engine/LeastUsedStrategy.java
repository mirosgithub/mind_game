package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.model.Colour;

public class LeastUsedStrategy implements Strategy {

  @Override
  public void selectColour(Player player) {
    player.setColour(Colour.getRandomColourForAi());
  }

  @Override
  public void guessColour(Player player) {
    Human human = (Human) player.getOpponent();
    Colour leastUsed = Colour.RED;
    int minCount = human.getColourCount(leastUsed);

    // check each color and update if we find one used less
    if (human.getColourCount(Colour.GREEN) < minCount) {
      leastUsed = Colour.GREEN;
      minCount = human.getColourCount(leastUsed);
    }
    if (human.getColourCount(Colour.BLUE) < minCount) {
      leastUsed = Colour.BLUE;
      minCount = human.getColourCount(leastUsed);
    }
    if (human.getColourCount(Colour.YELLOW) < minCount) {
      leastUsed = Colour.YELLOW;
    }

    player.setGuess(leastUsed);
  }
}
