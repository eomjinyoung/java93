/* 데이터 프로세싱 스트림 클래스 - BufferedInputStream 도입 후 
 * => 버퍼를 준비하여 일정량 만큼 읽는다.         
 */
package step16;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test04_3_in {

  static class MyBufferedInputStream {
    InputStream in;
    byte[] buf = new byte[8192];
    int len;
    int cursor;
    
    MyBufferedInputStream(InputStream in) {
      this. in = in;
    }
    
    public int read() throws IOException {
      if (cursor == len) { // 버퍼를 다 읽었다면
        cursor = 0;
        len = in.read(buf);
        if (len < 0) // 파일을 모두 읽었다면 -1을 리턴하여 호출자에게 알려준다.
          return -1;
      }
      return buf[cursor++] & 0x000000FF;
    }
    
    public void close() {}
    
  }
  
  public static void main(String[] args) throws Exception {
    FileInputStream in0 = new FileInputStream("temp/jls8.pdf");
    MyBufferedInputStream in = new MyBufferedInputStream(in0);

    int b = 0;
    int count = 0;
    long start = System.currentTimeMillis();
    
    while ((b = in.read()) != -1) {
      if ((++count % 10000) == 0) System.out.print("."); 
      if ((count % 500000) == 0) System.out.println();
    }
    
    long end = System.currentTimeMillis();
     
    System.out.printf("\n걸린 시간 = %d", end - start);
    
    in.close();
    in0.close();
  }

}









