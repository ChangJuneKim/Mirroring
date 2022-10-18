package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

// JSON을 객체화
@Getter @Setter
public class HelloData {

  private String username;
  private int age;
}
