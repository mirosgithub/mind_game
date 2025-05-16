package nz.ac.auckland.se281.engine;

public abstract class Ai extends Player {

  protected Strategy strategy;

  public Ai(String name) {
    super(name);
    strategy = new RandomStrategy();
  }

  public void play() {
    strategy.selectColour(this);
    strategy.guessColour(this);
  }
}
