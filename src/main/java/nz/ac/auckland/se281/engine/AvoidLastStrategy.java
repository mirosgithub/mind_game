package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.model.Colour;

public class AvoidLastStrategy implements Strategy {

  @Override
  public void selectColour(Player player) {
    player.setColour(Colour.getRandomColourForAi());
  }

  @Override
  public void guessColour(Player player) {
    Colour lastColour = player.getOpponent().getColour();
    player.setGuess(Colour.getRandomColourExcluding(lastColour));
  }
}
