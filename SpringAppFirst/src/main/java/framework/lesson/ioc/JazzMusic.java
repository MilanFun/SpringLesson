package framework.lesson.ioc;

import org.springframework.stereotype.Component;

@Component
public class JazzMusic implements Music{
  @Override
  public String getSong() {
    return "B.B.King";
  }
}
