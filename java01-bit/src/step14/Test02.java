/* 제네릭(Generic) 문법 : 사용 후
 * => 값을 꺼낼 때 마다 본래 타입으로 형변환할 필요가 없다.
 * => 특정 타입의 값만 다루도록 제한할 수 있다.
 */
package step14;

import java.util.Date;

public class Test02 {
  public static void main(String[] args) {
    //1) 제네릭 클래스를 사용할 때 타입을 지정하지 않으면 기본이 Object이다.
    Bucket2 b = new Bucket2();
    //Bucket2<Object> b = new Bucket2<Object>();
    
    b.setValue(new String("Hello"));
    //단, 예전처럼 값을 꺼낼 때 마다 형변환을 해야 한다.
    String str = (String)b.getValue();

    b.setValue(new Date());
    Date date = (Date)b.getValue();
    
    b.setValue(new Integer(10));
    Integer i = (Integer)b.getValue();
    
  }
}
