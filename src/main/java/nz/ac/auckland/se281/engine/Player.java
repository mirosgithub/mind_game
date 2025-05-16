package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.model.Colour;

public abstract class Player {
  
  protected String name;
  protected Colour colour;
  protected Colour guess;
  protected Player opponent;
  protected int roundPoints;

  public Player(String name) {
    this.name = name;
    this.colour = null;
    this.guess = null;
    this.roundPoints = 0;
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

  public Player getOpponent() {
    return opponent;
  }

  public void setOpponent(Player opponent) {
    this.opponent = opponent;
  }

  public int getRoundPoint() {
    return roundPoints;
  }

  public void setRoundPoints(int points) {
    this.roundPoints = points;
  }

}
