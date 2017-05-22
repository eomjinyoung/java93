/* 데이터 프로세싱 스트림 클래스 - ObjectOutputStream 도입 후
 * => 객체 출력하기! 
 * => 직렬화(Serialize = marshaling)
 *    인스턴스    ----> 바이트 배열 
 * => 객체로 복원(Deserialize = unmarshaling)
 *    바이트 배열 ----> 인스턴스  
 * => 주의!
 *    직렬화가 가능한 클래스는 java.io.Serializable 규격을 따르는 클래스이다. 
 *    일반 클래스는 인스턴스를 바로 출력할 수 없다. 왜? 보안 때문이다.     
 */
package step16;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test05_3_out {
  
  public static void main(String[] args) throws Exception {
    // Student 클래스는 직렬화 하는 것을 허락하지 않았기 때문에
    // 바로 출력할 수 없다. 
    // 물론, 객체의 인스턴스 변수의 값을 하나씩 꺼내서 출력하는 것은 가능하다.
    //Student s = new Student("홍길동", 100, 90, 80, false);
    
    // Student2 클래스는 직렬화를 허락하고 있다.
    // => java.io.Serializable 의 규약(=규격=규칙)을 따르고 있다.
    Student2 s = new Student2("홍길동", 100, 90, 80, false);
    
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









