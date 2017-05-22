/* 예외처리 : 자원을 자동 해제시키는 try ~ catch ~ 문장(try-with-resources 문장)
 * => try ~ catch ~ 문장에서 일반적으로 자원을 해제시키는 방법은
 *    finally 블록에서 수행한다.
 * => JDK 7부터 사용가능!
 *    
 */
package step17;

import java.io.FileInputStream;

public class Test14_2 {

  public static void main(String[] args) {
    
    /* 자원을 자동 해제시키는 try ~ catch ~ 사용 후!
     * 문법)
     *    try (자원 선언) {...} catch (...) {...}
     */
    
    try (FileInputStream in = new FileInputStream("step17.Test14.data")){
      int b = 0;
      while((b = in.read()) != -1) {
        System.out.printf("%x,", b);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      
    } /*finally {
      // try () 괄호 안에 선언된 자원은 try ~ catch ~ 문장을 나가기 전에 자동 해제된다.
      // 따라서 finally 블록에서 개발자가 자원 해제시키는 코드를 작성할 필요가 없다.
    }*/
    
    System.out.println("안녕!");
  }

}




