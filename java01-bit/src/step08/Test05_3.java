/* 유틸리티 클래스 : java.util.Date 클래스 와 import 명령문 
 * => 클래스를 사용하려면 반드시 패키지 명을 적어야 한다.
 * => 단 java.lang 패키지의 클래스는 안 적어도 된다.
 * => 주의! 
 *    그럼 java.lang.reflect 나 java.lang.ref 같은 하위 패키지에 있는 것은?
 *    안된다! 오직 java.lang 패키지에 소속된 클래스만 해당된다.
 *    그 외의 패키지에 있는 클래스들은 반드시 그 소속을 밝혀야 한다.
 * => 에이~~ 매번 코딩할 때마다 패키지명을 적으니 너무 불편하다.
 *    해결책? import 명령을 사용하여 그 클래스가 어떤 패키지에 있는지 명시하라!
 *            그러면 그 다음부터는 패키지 명을 쓰지 않아도 된다.
 *              
 */
package step08;

//import 는 반드시 package 명령 다음에 와야 한다.
import java.util.Date;

public class Test05_3 {
  
  public static void main(String[] args) {
    // 인스턴스를 만들면 현재 시간을 보관하고 있는 객체가 생성된다.
    Date today = new Date();
    
    System.out.println(today.getYear() + 1900); // 기준이 1900년이다. 
    System.out.println(today.getMonth() + 1); // 값의 범위가 0부터 11까지이다.
    System.out.println(today.getDate()); // 달을 기준으로 한다.
    System.out.println(today.getDay()); // 주를 기준으로 한다. 일(0), 월(1), ...
    System.out.println(today.getHours()); // 일을 기준으로 한다. 0 ~ 23
    System.out.println(today.getMinutes());
    System.out.println(today.getSeconds());
    System.out.println(today.getTime()); // 1970년 1월 1일  0시 0분 0초를 기준으로 경과된 밀리초.
    
    /* Deprecated Method
     * => 향후 제거될 메서드이니 사용하지 말라고 권고하는 메서드이다.
     * => 왜 제거하려는 건가?
     *    좀 더 유지보수 하기 좋게 다른 클래스로 기능을 이전하였기 때문이다.
     */
  }

}







