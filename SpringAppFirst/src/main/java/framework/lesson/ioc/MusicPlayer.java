package framework.lesson.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("player")
public class MusicPlayer {
  private Music music;
  private String name;
  private int volume;
  private List<Music> listOfMusic = new ArrayList<>();

  private ClassicalMusic classicalMusic;
  private RockMusic rockMusic;

  public List<Music> getListOfMusic() {
    return this.listOfMusic;
  }

  public void setListOfMusic(List<Music> listOfMusic) {
    this.listOfMusic = listOfMusic;
  }

  public Music getMusic() {
    return music;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getVolume() {
    return volume;
  }

  public void setVolume(int volume) {
    this.volume = volume;
  }

  //IoC
  //DI
  @Autowired
  public MusicPlayer(ClassicalMusic music, RockMusic rockMusic) {
    this.classicalMusic = music;
    this.rockMusic = rockMusic;
  }

  public MusicPlayer(){}

  @Override
  public String toString() {
    return "Playing " + this.classicalMusic.getSong() + ", " + this.rockMusic.getSong();
  }

  public void playMusicWithList() {
    System.out.println("Name: " + this.name);
    System.out.println("Volume: " + this.volume);
    for(Music i : this.listOfMusic) {
      System.out.print(i.getSong());
      System.out.print(" ");
    }
  }

  public void setMusic(Music music) {
    this.music = music;
  }
}
