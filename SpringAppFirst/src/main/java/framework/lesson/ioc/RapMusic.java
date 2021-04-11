package framework.lesson.ioc;

import org.springframework.stereotype.Component;

public class RapMusic implements Music{
  @Override
  public String getSong() {
    return "AK-47";
  }
}
