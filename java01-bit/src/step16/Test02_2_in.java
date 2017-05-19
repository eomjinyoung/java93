/* File I/O : 바이트 스트림 클래스 - FileInputStream II
 * => 바이트 배열 읽기
 * 
 */
package step16;

import java.io.FileInputStream;

public class Test02_2_in {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("test02_2.data");
    
    // 바이트 배열을 저장할 메모리를 준비한다.
    byte[] bytes = new byte[1024];
    int len = 0;
    
    len = in.read(bytes); // 바이트 배열의 값을 저장할 수 있는 메모리 주소를 준다.
                          // 리턴 값은 파일에서 실제로 읽은 바이트 개수이다.

    for (int i = 0; i < len; i++) {
      System.out.printf("%x ", bytes[i]);
    }
    
    in.close();
  }

}









