package framework.lesson.ioc;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
  private Music music;
  private String name;
  private int volume;
  private List<Music> listOfMusic = new ArrayList<>();

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
  public MusicPlayer(Music music) {
    this.music = music;
  }

  public MusicPlayer(){}

  public void playMusic() {
    System.out.println("Playing: " + this.music.getSong());
    System.out.println("Name: " + this.name);
    System.out.println("Volume: " + this.volume);
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
