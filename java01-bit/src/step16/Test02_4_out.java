/* File I/O : 바이트 스트림 클래스 - FileOutputStream IV
 * => 다양한 타입의 값을 출력하기
 */
package step16;

import java.io.FileOutputStream;

public class Test02_4_out {

  public static void main(String[] args) throws Exception {
    FileOutputStream out = new FileOutputStream("test02_4.data");

    byte b = 0x11;
    short s = 0x2233;
    int i = 0x44556677;
    String str = "ABC가각간";
    
    
    
    
    out.close();
    System.out.println("파일 출력 완료!");
  }

}









