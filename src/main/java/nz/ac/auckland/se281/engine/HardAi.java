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
    
    // use different strategies from round 3
    if (currentRound == 3) {
      setStrategy(leastUsedStrategy);
    } else if (currentRound >= 4 && roundPoints == 0) {
      // switch strategies based on performance
      if (strategy instanceof LeastUsedStrategy) {
        setStrategy(avoidLastStrategy);
      } else {
        setStrategy(leastUsedStrategy);
      }
    }
    super.play();
  }
}
