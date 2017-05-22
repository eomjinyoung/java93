/* 데이터 프로세싱 스트림 클래스 - BufferedOutputStream 도입 후
 * => 출력할 데이터를 먼저 버퍼에 출력한다.
 *    버퍼가 꽉차면 비로소 파일로 출력한다.
 *         
 */
package step16;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Test04_3_out {
  
  static class MyBufferedOutputStream {
    OutputStream out;
    byte[] buf = new byte[8129];
    int cursor;
    
    MyBufferedOutputStream(OutputStream out) {
      this.out = out;
    }
    
    public void write(int b) throws IOException {
      buf[cursor++] = (byte)b;
      
      if (cursor == buf.length) { //버퍼가 꽉 찼다면 출력한다.
        out.write(buf);
        cursor = 0;
      }
    }
    
    public void flush() throws IOException {
      out.write(buf, 0, cursor);
    }
    
    public void close() {}
  }

  public static void main(String[] args) throws Exception {
    FileOutputStream out0 = new FileOutputStream("temp/test04_3.data");
    MyBufferedOutputStream out = new MyBufferedOutputStream(out0);
    
    long start = System.currentTimeMillis();
    
    for (int i = 1; i <= 4000000; i++) {
      out.write(i);
      if ((i % 10000) == 0) System.out.print(".");
      if ((i % 500000) == 0) System.out.println();
    }
    
    out.flush();
    
    long end = System.currentTimeMillis();
    System.out.printf("\n걸린 시간 = %d", end - start);
    
    out.close();
    out0.close();
  }

}









