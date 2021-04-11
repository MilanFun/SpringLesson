package framework.lesson.ioc;

public class ClassicalMusic implements Music {
  private ClassicalMusic() {}

  public static ClassicalMusic getInstance(){
    return new ClassicalMusic();
  }

  @Override
  public String getSong() {
    return "Hungarian Rhapsody";
  }

  public void init() {
    System.out.println("Init bean");
  }

  public void destroy() {
    System.out.println("Destroy bean");
  }
}
