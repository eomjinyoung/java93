package control;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
  
  public MyAdvice() {
    System.out.println("MyAdvice() 객체 생성됨!");
  }
  
  @Before("execution(* control.MyDao.*(..))")
  public void filter01() {
    System.out.println("############### AOP : MyAdvice.filter01() ###############");
  }
  
  @After( "execution(* control.MyDao.*(..))")
  public void filter02() {
    System.out.println("############### AOP : MyAdvice.filter02() ###############");
  }
}
