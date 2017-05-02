/* 리터럴 - 논리 값 리터럴
 */
package step01;

public class Test09 {
  
  public static void main(String[] args) {
    System.out.println(true); 
    System.out.println(false);
    
    if (true) {
      System.out.println("참이다1");
    }
    
    if (false) {
      System.out.println("참이다2");
    }
    
    /*
    if (1) { //컴파일 오류! 자바에서는 논리값으로 true 또는 false만 가능하다.
      System.out.println("참이다3");
    }
    */
    
  }
}
