/* 데이터 프로세싱 스트림 클래스 - BufferedInputStream 도입 전 II
 * => 버퍼를 준비하여 일정량 만큼 읽는다.         
 */
package step16;

import java.io.FileInputStream;

public class Test04_2_in {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("temp/jls8.pdf");
    
    byte[] buf = new byte[8196]; // 8KB = 1KB(1024byte) * 8
    int len = 0;
    int countPoint = 0;
    
    long start = System.currentTimeMillis();
    
    while ((len = in.read(buf)) != -1) {
      System.out.print(".");
      if ((++countPoint % 50) == 0) {
        System.out.println();
      }
    }
    
    long end = System.currentTimeMillis();
     
    System.out.printf("\n걸린 시간 = %d", end - start);
    
    in.close();
  }

}









