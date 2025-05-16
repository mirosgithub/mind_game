package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.model.Colour;

public class RandomStrategy implements Strategy {

  @Override
  public void selectColour(Player player) {
    player.setColour(Colour.getRandomColourForAi());
  }

  @Override
  public void guessColour(Player player) {
    player.setGuess(Colour.getRandomColourForAi());
  }
}
