/* File I/O : 바이트 스트림 클래스 - FileInputStream IV
 * => 다양한 타입의 값을 읽기
 * 
 */
package step16;

import java.io.FileInputStream;

public class Test02_4_in {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("test02_4.data");
    
    byte b;
    b = (byte)in.read();
    
    short s;
    s = (short)(in.read() << 8);
    s |= (short)(in.read());
    
    int i;
    i = (int)(in.read() << 24);
    i |= (int)(in.read() << 16);
    i |= (int)(in.read() << 8);
    i |= (int)(in.read());
    
    // 문자열 바이트를 읽기 전에 몇 바이트를 읽어야 하는지 그 크기를 먼저 읽는다.
    int len;
    len = (int)(in.read() << 24);
    len |= (int)(in.read() << 16);
    len |= (int)(in.read() << 8);
    len |= (int)(in.read());
    
    // 문자열 배열의 크기 만큼 바이트 배열을 만든다.
    byte[] buf = new byte[len];
    
    // 문자열 배열을 읽어 바이트 배열에 저장한다.
    in.read(buf);
    
    // 바이트 배열에 들어 있는 값을 가지고 문자열 객체를 생성한다.
    // => 이때 그 바이트 배열이 어떤 문자집합으로 인코딩 되었는지 알려준다.
    String str = new String(buf, "UTF-8");
    
    System.out.printf("%x, %x, %x, %s\n", b, s, i, str);
    
    in.close();
  }

}









