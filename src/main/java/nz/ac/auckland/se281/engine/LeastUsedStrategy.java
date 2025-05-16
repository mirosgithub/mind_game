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

    if (human.getColourCount(Colour.GREEN) < human.getColourCount(leastUsed)) {
      leastUsed = Colour.GREEN;
    } else if (human.getColourCount(Colour.BLUE) < human.getColourCount(leastUsed)) {
      leastUsed = Colour.BLUE;
    } else if (human.getColourCount(Colour.YELLOW) < human.getColourCount(leastUsed)) {
      leastUsed = Colour.YELLOW;
    }

    player.setGuess(leastUsed);
  }
  
}
