/* 데이터 프로세싱 스트림 클래스 - BufferedOutputStream 도입 전 II
 * => 버퍼를 이용하여 출력 속도 향상시키기
 *    1만 바이트 마다 출력하게 되면, 속도가 빨라진다.         
 */
package step16;

import java.io.FileOutputStream;

public class Test04_2_out {

  public static void main(String[] args) throws Exception {
    FileOutputStream out = new FileOutputStream("temp/test04_2.data");
    
    byte[] buf = new byte[8196];
    int len = 0;
    long start = System.currentTimeMillis();
    
    for (int i = 1; i <= 4000000; i++) {
      buf[len++] = (byte)i;
      
      if (len == 8196) {
        out.write(buf);
        len = 0;
      }
      
      if ((i % 10000) == 0) System.out.print(".");
      if ((i % 500000) == 0) System.out.println();
    }
    
    if (len > 0) {
      out.write(buf, 0, len);
    }
    
    long end = System.currentTimeMillis();
    System.out.printf("\n걸린 시간 = %d", end - start);
    
    out.close();
  }

}









