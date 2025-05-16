package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.model.Colour;

public abstract class Player {

  protected String name;
  protected Colour colour;
  protected Colour guess;
  protected Player opponent;
  protected int roundPoints;
  protected int totalPoints;

  public Player(String name) {
    this.name = name;
    colour = null;
    guess = null;
    roundPoints = 0;
    totalPoints = 0;
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

  public int getRoundPoints() {
    return roundPoints;
  }

  public void setPoints(int points) {
    roundPoints = points;
    totalPoints += points;
  }

  public int getTotalPoints() {
    return totalPoints;
  }
}
