package nz.ac.auckland.se281.engine;

public interface Strategy {
  void selectColour(Player player);
  
  void guessColour(Player player);
}
