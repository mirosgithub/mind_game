package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.model.Colour;

public abstract class Player {
  
  String name;
  Colour colour;
  Colour guess;

  public Player(String name) {
    this.name = name;
    this.colour = null;
    this.guess = null;
  }

  public String getName() {
    return name;
  }

  public Colour getColour() {
    return colour;
  }

  public void setColour(Colour colour) {
    this.colour = colour;
  }

  public Colour getGuess() {
    return guess;
  }

  public void setGuess(Colour guess) {
    this.guess = guess;
  }

}
