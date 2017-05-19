/* File I/O : 바이트 스트림 클래스 - ByteArrayOutputStream/ByteArrayInputStream
 * => 바이트 배열 메모리에 출력하고, 바이트 배열 메모리로부터 읽기
 */
package step16;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class Test03_2 {

  public static void main(String[] args) throws Exception {
    // 배열에 데이터 저장
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    byte b = 0x11;
    out.write(b);
    
    short s = 0x2233;
    out.write(s >> 8);
    out.write(s);
    
    int i = 0x44556677;
    out.write(i >> 24);
    out.write(i >> 16);
    out.write(i >> 8);
    out.write(i);
    
    String str = "ABC가각간";
    byte[] bytes = str.getBytes("UTF-8");
    
    int len = bytes.length;
    out.write(len >> 8);
    out.write(len);
    
    out.write(bytes);
    
    byte[] buf = out.toByteArray();
    out.close();
    
    
    // 배열에서 데이터 읽기
    ByteArrayInputStream in = new ByteArrayInputStream(buf);
    
    byte b2;
    b2 = (byte)in.read();
    
    short s2;
    s2 = (short)(in.read() << 8);
    s2 |= (short)(in.read());
    
    int i2;
    i2 = in.read() << 24;
    i2 |= in.read() << 16;
    i2 |= in.read() << 8;
    i2 |= in.read();
    
    // 문자열 바이트를 읽기 전에 몇 바이트를 읽어야 하는지 그 크기를 먼저 읽는다.
    int len2;
    len2 = in.read() << 8;
    len2 |= in.read();
    
    byte[] buf2 = new byte[len];
    in.read(buf2);
    String str2 = new String(buf2, "UTF-8");
    
    in.close();
    
    System.out.printf("%x, %x, %x, %s\n", b2, s2, i2, str2);
  }

}









