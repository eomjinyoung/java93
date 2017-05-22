/* 데이터 프로세싱 스트림 클래스 - ObjectOutputStream 도입 전
 * => 객체 출력하기!         
 */
package step16;

import java.io.FileOutputStream;

public class Test05_1_out {
  
  public static void main(String[] args) throws Exception {
    Student s = new Student("홍길동", 100, 90, 80, false);
    
    FileOutputStream out0 = new FileOutputStream("temp/test05_1.data");
    java.io.DataOutputStream out = new java.io.DataOutputStream(out0);
    
    // 객체 출력
    // => 객체의 각 인스턴스 변수의 값을 출력한다. 
    out.writeUTF(s.name);
    out.writeInt(s.kor);
    out.writeInt(s.eng);
    out.writeInt(s.math);
    out.writeInt(s.sum);
    out.writeFloat(s.aver);
    out.writeBoolean(s.working);
    
    out.close();
    out0.close();
  }

}









