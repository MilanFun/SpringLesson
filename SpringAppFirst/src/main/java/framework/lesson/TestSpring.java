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

    //IoC
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

    //DI
    ClassPathXmlApplicationContext context4 = new ClassPathXmlApplicationContext("applicationContext.xml");
    MusicPlayer musicPlayer3 = context4.getBean("musicPlayer", MusicPlayer.class);
    musicPlayer3.playMusic();
    context4.close();

    //DI via setter
    ClassPathXmlApplicationContext context5 = new ClassPathXmlApplicationContext("applicationContext.xml");
    MusicPlayer musicPlayer4 = context5.getBean("setterMusicPlayer", MusicPlayer.class);
    musicPlayer4.playMusic();
    context5.close();

    ClassPathXmlApplicationContext context6 = new ClassPathXmlApplicationContext("applicationContext.xml");
    MusicPlayer musicPlayer5 = context6.getBean("advancedMusicPlayer", MusicPlayer.class);
    musicPlayer5.playMusic();
    context6.close();

    //DI via properties file
    ClassPathXmlApplicationContext context7 = new ClassPathXmlApplicationContext("applicationContext.xml");
    MusicPlayer musicPlayer6 = context7.getBean("musicPlayerProperties", MusicPlayer.class);
    musicPlayer6.playMusic();
    context7.close();

    //ArrayList and properties file
    ClassPathXmlApplicationContext context8 = new ClassPathXmlApplicationContext("applicationContext.xml");
    MusicPlayer musicPlayer7 = context8.getBean("listMusic", MusicPlayer.class);
    musicPlayer7.playMusicWithList();
    context8.close();
  }
}
