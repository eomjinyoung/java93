/* 유틸리티 클래스 : Properties 클래스 응용 II
 * => 프로그램을 실행할 때 전달하는 아규먼트의 종류
 *    1) JVM 아규먼트
 *       예) > java -cp bin -D프로퍼티명=값 -D프로퍼티명=값 step08.Test08_3
 *       => -D 옵션 다음에 공백없이 이름과 값을 전달한다.
 *       => 프로그램 아규먼트와 달리 이름=값 한 쌍으로 값을 전달할 수 있다. 
 *    2) 프로그램 아규먼트
 *       예) > java -cp bin step08.Test08_3 aaa bbb ccc 
 *       => 클래스 이름 다음에 오는 값을 "프로그램 아규먼트"라 부른다.
 *       => main() 메서드의 파라미터(args)를 통해 그 값을 꺼낼 수 있다.
 */
package step08;

import java.util.Properties;
import java.util.Set;

public class Test08_3 {
  public static void main(String[] args) throws Exception {
    // 1) 프로그램 아규먼트 출력
    for (String value : args) {
      System.out.println(value);
    }
    System.out.println("---------------------------");
    
    // 2) JVM 프로퍼티 출력
    Properties props = System.getProperties();
    System.out.printf("name=%s\n", props.get("name"));
    System.out.printf("age=%s\n", props.get("age"));
    
    // 프로퍼티 이름 중간에 점(.)이 있다고 해서 당황하지 말라! 
    // 그냥 이름의 일부일 뿐이다.
    // 다만, 점을 사용하면 이름을 쉽게 분류할 수 있다.
    System.out.printf("tel.home=%s\n", props.get("tel.home"));
    System.out.printf("tel.office=%s\n", props.get("tel.office"));
  }
}







