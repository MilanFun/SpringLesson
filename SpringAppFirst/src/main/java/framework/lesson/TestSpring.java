package framework.lesson;

import framework.lesson.ioc.JazzMusic;
import framework.lesson.ioc.Music;
import framework.lesson.ioc.MusicPlayer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    TestBean testBean1 = context.getBean("testBean1", TestBean.class);
    TestBean testBean2 = context.getBean("testBean2", TestBean.class);
    System.out.println(testBean1.getName());
    System.out.println(testBean2.getName());
    context.close();

    ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext("applicationContext.xml");
    Music music = context1.getBean("musicBean", Music.class);
    MusicPlayer musicPlayer = new MusicPlayer(music);
    musicPlayer.playMusic();
    context1.close();

    ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("applicationContext.xml");
    Music music1 = context2.getBean("musicBean1", Music.class);
    MusicPlayer musicPlayer1 = new MusicPlayer(music1);
    musicPlayer1.playMusic();
    context2.close();

    ClassPathXmlApplicationContext context3 = new ClassPathXmlApplicationContext("applicationContext.xml");
    Music music2 = context3.getBean("jazzMusic", JazzMusic.class);
    MusicPlayer musicPlayer2 = new MusicPlayer(music2);
    musicPlayer2.playMusic();
    context3.close();

    ClassPathXmlApplicationContext context4 = new ClassPathXmlApplicationContext("applicationContext.xml");
    MusicPlayer musicPlayer3 = context4.getBean("musicPlayer", MusicPlayer.class);
    musicPlayer3.playMusic();
    context4.close();
  }
}
