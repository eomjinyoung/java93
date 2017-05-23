/* 키보드 입력처리
 * => System.in 객체가 키보드 입력 스트림이다.
 */
package step16;

import java.io.InputStream;
import java.util.Scanner;

public class Test07_1 {

  public static void main(String[] args) throws Exception {
    InputStream in = System.in;
    
    // InputStream 객체를 그대로 사용하면 read(), read(byte[]) 메서드 밖에 사용할 수 없다.
    // 도구가 너무 단순한다.
    // 어떻게? 한 줄 단위로 데이터를 읽어서 처리하는 클래스가 필요하다.
    // 어떤 클래스? java.util.Scanner 클래스를 사용하면 이 작업을 손쉽게 수행할 수 있다.
    Scanner keyScanner = new Scanner(in);
    
    // 키보드에서 입력한 데이터를 한 줄 읽어보자!
    String str = keyScanner.nextLine(); // 한 줄 읽을 때까지 리턴하지 않는다.
    System.out.printf("==>%s\n", str);
    
    keyScanner.close();
    in.close();
  }

}









