/* 유틸리티 클래스 : java.util.Calendar 클래스
 * => 날짜 데이터에서 년, 월, 일, 시, 분, 초를 추출하거나 설정하고 싶다면,
 *    Calendar 클래스를 사용하라!
 *    기존의 java.util.Date 클래스나, java.sql.Date 클래스의 경우
 *    이런 정보를 추출하는 메서드가 deprecated 메서드로 권고받고 있다.
 *    즉 제거될 메서드이니 쓰지 말라는 것이다!
 */
package step08;

import java.util.Calendar;

public class Test05_7 {
  
  public static void main(String[] args) {
    // Calendar 객체는 new 명령을 사용하여 직접 만들 수 없다.
    // getInstance() 메서드를 호출하여 그 리턴 값을 사용하라!
    Calendar cal = Calendar.getInstance();
    
    // 날짜 정보 추출
    //cal.get(꺼낼 값을 숫자로 지정한다.)
    // 년도(1), 월(2), 일(5), 요일(7), 시(10), 분(12), 초(13)
    System.out.println(cal.get(1));
    System.out.println(cal.get(2) + 1); // 0 ~ 11
    System.out.println(cal.get(5)); 
    System.out.println(cal.get(7)); // 일(1) ~ 토(7)
    System.out.println(cal.get(10)); // 0 ~ 11
    System.out.println(cal.get(11)); // 0 ~ 23
    System.out.println(cal.get(12));
    System.out.println(cal.get(13));
  }

}







