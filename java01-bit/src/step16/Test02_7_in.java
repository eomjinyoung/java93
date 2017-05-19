/* File I/O : 바이트 스트림 클래스 - java.io.DataInputStream
 * 
 */
package step16;

import java.io.FileInputStream;

public class Test02_7_in {

  public static void main(String[] args) throws Exception {
    FileInputStream in0 = new FileInputStream("test02_7.data");
    java.io.DataInputStream in = new java.io.DataInputStream(in0);
    
    byte b = in.readByte();
    short s = in.readShort();
    int i = in.readInt();
    String str = in.readUTF();
    
    System.out.printf("%x, %x, %x, %s\n", b, s, i, str);
    
    in.close();
  }

}









