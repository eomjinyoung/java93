/* File I/O : 바이트 스트림 클래스 - MyDataOutputStream
 * => FileOutputStream을 상속 받아서 다양한 타입의 값을 출력하는 기능을 추가한다.
 *    이 클래스를 사용하여 출력해보자!
 */
package step16;

public class Test02_5_out {

  public static void main(String[] args) throws Exception {
    MyDataOutputStream out = new MyDataOutputStream("test02_5.data");

    byte b = 0x11;
    out.writeByte(b);
    
    short s = 0x2233;
    out.writeShort(s);
    
    int i = 0x44556677;
    out.writeInt(i);
    
    String str = "ABC가각간";
    out.writeUTF(str);
    
    out.close();
    System.out.println("파일 출력 완료!");
  }

}









