/* 제네릭(Generic) 문법 : 사용 후 II
 * => 값을 꺼낼 때 마다 본래 타입으로 형변환할 필요가 없다.
 * => 특정 타입의 값만 다루도록 제한할 수 있다.
 */
package step14;

import java.util.Date;

public class Test03 {
  public static void main(String[] args) {
    //2) 타입을 지정해보자!
    //Bucket2<String> b = new Bucket2<String>();
    
    // Java7 이상부터 new 명령 다음에 타입 지정을 생략할 수 있다.
    Bucket2<String> b = new Bucket2<>();
    
    b.setValue(new String("Hello"));
    String str = b.getValue(); // 형변환이 필요 없다.
    System.out.println(str);
    
    // 클래스를 만들 때 다룰 값의 타입을 String으로 제한했기 때문에,
    // 다음과 같이 다른 타입의 값은 저장할 수 없다.
    //b.setValue(new Date());  // 컴파일 오류!
    //b.setValue(new Integer(10)); // 컴파일 오류!
    
  }
}
