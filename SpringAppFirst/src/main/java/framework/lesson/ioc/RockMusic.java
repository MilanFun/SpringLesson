package framework.lesson.ioc;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RockMusic implements Music {
  private final List<String> listOfRockMusic = Arrays.asList("Imagine Dragons", "ACDC", "Group-Alex");

  public static RockMusic getInstance() {
    return new RockMusic();
  }

  private RockMusic() {}

  @Override
  public String getSong() {
    return this.listOfRockMusic.toString();
  }

  public String getSongByInt(int i) {
    return this.listOfRockMusic.get(i);
  }
}
