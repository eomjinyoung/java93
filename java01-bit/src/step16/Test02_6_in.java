/* File I/O : 바이트 스트림 클래스 - DataInputStream
 * => 상속이 아닌 위임이라는 방법을 사용해서 기능 확장하기
 * 
 */
package step16;

import java.io.FileInputStream;

public class Test02_6_in {

  public static void main(String[] args) throws Exception {
    FileInputStream in0 = new FileInputStream("test02_6.data");
    DataInputStream in = new DataInputStream(in0);
    
    byte b = in.readByte();
    short s = in.readShort();
    int i = in.readInt();
    String str = in.readUTF();
    
    System.out.printf("%x, %x, %x, %s\n", b, s, i, str);
    
    in.close();
  }

}









