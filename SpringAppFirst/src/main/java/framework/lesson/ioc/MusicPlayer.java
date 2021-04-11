package framework.lesson.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("player")
public class MusicPlayer {
  private Music music1;
  private Music music2;

  //DI
  @Autowired
  public MusicPlayer(@Qualifier("classicalMusic") Music music1, @Qualifier("rockMusic") Music music2) {
    this.music1 = music1;
    this.music2 = music2;
  }

  public MusicPlayer(){}

  @Override
  public String toString() {
    return "Playing " + this.music1.getSong() + ", " + this.music2.getSong();
  }

  public <T extends Enum<T>> void playMusic(T[] val) {
    for (T t : val) {
      if (t == Ganre.CLASSICAL) {
        int k = (int) (Math.random() * 3);
        System.out.println(this.music1.getSongByInt(k));
      }
      if (t == Ganre.ROCK) {
        int k = (int) (Math.random() * 3);
        System.out.println(this.music2.getSongByInt(k));
      }
    }
  }
}
