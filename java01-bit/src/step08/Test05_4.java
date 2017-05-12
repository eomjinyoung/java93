/* 유틸리티 클래스 : java.util.Date 클래스 와 import 명령문 II
 * => import를 사용하여 클래스 정보를 명시할 때,
 *    와일드 카드(*)를 사용할 수 있다.
 * => 와일드 카드(*)를 사용한 import 명령문이 여러 개 있을 경우,
 *    개발자는 클래스가 어떤 패키지 있는 클래스인지 직관적으로 알 수 없다.
 *    그래서 코드의 가독성을 떨어뜨리는 문제가 있다.
 *    추천!
 *    가능한 와일드 카드(*)를 사용하지 말고 정확하게 패키지명과 클래스명을 기술하라! 
 */
package step08;

import java.util.*;
import java.net.*;
import java.awt.*;

public class Test05_4 {
  
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







