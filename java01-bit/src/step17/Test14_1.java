/* 예외처리 : 자원을 자동 해제시키는 try ~ catch ~ 문장(try-with-resources 문장) 
 * => try ~ catch ~ 문장에서 일반적으로 자원을 해제시키는 방법은
 *    finally 블록에서 수행한다.
 * => JDK 7부터 사용가능!
 */
package step17;

import java.io.FileInputStream;

public class Test14_1 {

  public static void main(String[] args) {
    
    // 자원을 자동 해제시키는 try ~ catch ~ 사용 전!
    FileInputStream in = null;
    try {
      in = new FileInputStream("step17.Test14.data");
      
      int b = 0;
      while((b = in.read()) != -1) {
        System.out.printf("%x,", b);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      
    } finally {
      // 파일의 자원을 해제시키다가, close() 호출하다가, 발생된 예외는 무시한다.
      try {in.close();} catch (Exception e) {/*무시*/}
    }
    
    System.out.println("안녕!");
  }

}




