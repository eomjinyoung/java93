/* 유틸리티 클래스 : Properties 클래스
 * => .properties 파일을 다룰 때 주로 사용한다.
 * => 파일 형식은 다음과 같다.
 *    key=value
 *    key=value
 *    ...
 */
package step08;

import java.io.FileReader;
import java.util.Properties;

public class Test08_1 {
  public static void main(String[] args) throws Exception {
    Properties props = new Properties();
    
    // test.properties 파일을 읽어서 그 내용을 보관한다.
    props.load(new FileReader("test.properties"));
    
    // String을 사용하여 값을 꺼내기
    System.out.println(props.getProperty("key1"));
    System.out.println(props.getProperty("key2"));
    System.out.println(props.getProperty("key3"));
    System.out.println(props.getProperty("key4"));
    System.out.println("---------------------------------");
    
    // Hashtable의 서브 클래스이기 때문에 get()/put() 사용가능!
    System.out.println(props.get("key1"));
    System.out.println(props.get("key2"));
    System.out.println(props.get("key3"));
    System.out.println(props.get("key4"));
  }
}







