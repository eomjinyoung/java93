/* 데이터 프로세싱 스트림 클래스 - ObjectOutputStream 도입 후
 * => 객체 출력하기! 
 * => 직렬화(Serialize = marshaling)
 *    인스턴스    ----> 바이트 배열 
 * => 객체로 복원(Deserialize = unmarshaling)
 *    바이트 배열 ----> 인스턴스  
 * => 주의!
 *    직렬화가 가능한 클래스는 java.io.Serializable 규격을 따르는 클래스이다.      
 */
package step16;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test05_2_out {
  
  public static void main(String[] args) throws Exception {
    Student s = new Student("홍길동", 100, 90, 80, false);
    
    FileOutputStream out0 = new FileOutputStream("temp/test05_2.data");
    ObjectOutputStream out = new ObjectOutputStream(out0);
    
    // 객체 출력
    // => 인스턴스의 값들을 바이트 배열로 만들어 출력한다. "직렬화(Serializable)" 한다.
    // => 단, 해당 클래스에서 직렬화를 허락해야 한다.
    out.writeObject(s);
    
    out.close();
    out0.close();
  }

}









