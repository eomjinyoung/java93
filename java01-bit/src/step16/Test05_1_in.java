/* 데이터 프로세싱 스트림 클래스 - ObjectInputStream 도입 전
 * => 파일에 저장된 객체 값을 순서대로 읽는다.        
 */
package step16;

import java.io.FileInputStream;

public class Test05_1_in {

  public static void main(String[] args) throws Exception {
    FileInputStream in0 = new FileInputStream("temp/test05_1.data");
    java.io.DataInputStream in = new java.io.DataInputStream(in0);
    
    Student s = new Student();
    
    // 저장된 순서대로 읽어야 한다.
    s.name = in.readUTF();
    s.kor = in.readInt();
    s.eng = in.readInt();
    s.math = in.readInt();
    s.sum = in.readInt();
    s.aver = in.readFloat();
    s.working = in.readBoolean();
        
    in.close();
    in0.close();
    
    System.out.println(s);
  }

}









