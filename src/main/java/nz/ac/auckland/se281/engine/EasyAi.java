package nz.ac.auckland.se281.engine;

public class EasyAi extends Ai {

  public EasyAi(String name) {
    super(name);
  }

  @Override
  public void play() {
    super.play();
    guess = strategy.selectColour();
  }
}
