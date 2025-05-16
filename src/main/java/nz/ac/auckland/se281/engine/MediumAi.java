package nz.ac.auckland.se281.engine;

public class MediumAi extends Ai {

  private boolean firstRound;

  public MediumAi(String name) {
    super(name);
    firstRound = true;
  }

  private void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public void play() {
    if (firstRound) {
      setStrategy(new AvoidLastStrategy());
      firstRound = false;
    }
    super.play();
  }
}
