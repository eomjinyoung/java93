package step23.ex12;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// WebServlet이라는 주석은 JVM을 실행할 때도 유지하라!
@Retention(RetentionPolicy.RUNTIME)
public @interface WebServlet {
  String url();
}
