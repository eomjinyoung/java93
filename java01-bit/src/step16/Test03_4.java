/* File I/O : 바이트 스트림 클래스 - DataOutputStream/DataInputStream
 */
package step16;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class Test03_4 {

  public static void main(String[] args) throws Exception {
    // 배열에 데이터 저장
    ByteArrayOutputStream out0 = new ByteArrayOutputStream();
    DataOutputStream out = new DataOutputStream(out0);
    
    byte b = 0x11;
    out.writeByte(b);
    
    short s = 0x2233;
    out.writeShort(s);
    
    int i = 0x44556677;
    out.writeInt(i);
    
    String str = "ABC가각간";
    out.writeUTF(str);
    
    // 출력 스트림 객체에 보관된 데이터를 배열로 뽑아낸다.
    byte[] buf = out0.toByteArray();
    
    out.close();
    
    
    // 배열에서 데이터 읽기
    ByteArrayInputStream in0 = new ByteArrayInputStream(buf);
    DataInputStream in = new DataInputStream(in0);
    
    byte b2 = in.readByte();
    short s2 = in.readShort();
    int i2 = in.readInt();
    String str2 = in.readUTF();
    in.close();
    
    System.out.printf("%x, %x, %x, %s\n", b2, s2, i2, str2);
  }

}









