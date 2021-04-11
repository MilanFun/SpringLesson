package framework.lesson.ioc;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
//Factory-pattern
public class ClassicalMusic implements Music {
  private final List<String> listOfClassicalMusic = Arrays.asList("Mozart", "Rachmaninov", "Bah");
  private ClassicalMusic() {}

  public static ClassicalMusic getInstance(){
    return new ClassicalMusic();
  }

  @Override
  public String getSong() {
    return this.listOfClassicalMusic.toString();
  }

  public String getSongByInt(int i) {
    return this.listOfClassicalMusic.get(i);
  }
}
