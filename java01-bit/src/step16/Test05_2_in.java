/* 데이터 프로세싱 스트림 클래스 - ObjectInputStream 도입 후
 * => 직렬화(serialize)를 통해 출력된 데이터의 경우,
 *    역직렬화(deserialize)를 통해 객체로 복원시킬 수 있다.
 */
package step16;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test05_2_in {

  public static void main(String[] args) throws Exception {
    FileInputStream in0 = new FileInputStream("temp/test05_2.data");
    ObjectInputStream in = new ObjectInputStream(in0);
    
    // 직렬화 데이터를 바로 읽어 객체로 복원한다.
    // => readObject()의 리턴 값이 어떤 클래스의 인스턴스 인지 알려줘야 한다.
    //    그래서 타입 캐시팅(형변환)을 하는 것이다.
    Student2 s = (Student2)in.readObject();
        
    in.close();
    in0.close();
    
    System.out.println(s);
  }

}









