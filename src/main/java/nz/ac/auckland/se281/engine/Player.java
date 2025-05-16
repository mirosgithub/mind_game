package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.model.Colour;

public abstract class Player {
  
  protected String name;
  protected Colour colour;
  protected Colour guess;

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
