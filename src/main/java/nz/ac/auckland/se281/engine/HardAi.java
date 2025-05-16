package nz.ac.auckland.se281.engine;

public class HardAi extends Ai {

  private int currentRound;
  private Strategy avoidLastStrategy;
  private Strategy leastUsedStrategy;

  public HardAi(String name) {
    super(name);
    currentRound = 0;
    avoidLastStrategy = new AvoidLastStrategy();
    leastUsedStrategy = new LeastUsedStrategy();
  }

  private void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public void play() {
    currentRound++;

    if (currentRound == 3) {
      setStrategy(leastUsedStrategy);
    } else if (currentRound >= 4 && roundPoints == 0) {
      if (strategy.equals(leastUsedStrategy)) {
        strategy = avoidLastStrategy;
      } else {
        strategy = leastUsedStrategy;
      }
    }
    super.play();
  }
}
