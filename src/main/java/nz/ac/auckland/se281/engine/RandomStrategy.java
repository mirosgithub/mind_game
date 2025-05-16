package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.model.Colour;

public class RandomStrategy implements Strategy {

  @Override
  public Colour selectColour() {
    return Colour.getRandomColourForAi();
  }
}
