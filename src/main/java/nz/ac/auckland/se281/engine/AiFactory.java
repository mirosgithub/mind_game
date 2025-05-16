package nz.ac.auckland.se281.engine;

import nz.ac.auckland.se281.Main.Difficulty;

public class AiFactory {
  
  public static Ai createAi(String name, Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new EasyAi(name);

      case MEDIUM:
        return new MediumAi(name);

      case HARD:
        return new HardAi(name);
      
      default:
        return null;
    }
  }
}
