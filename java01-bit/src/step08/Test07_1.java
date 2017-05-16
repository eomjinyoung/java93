/* 컬렉션(Collection) 클래스 II : java.util.ArrayList
 * => 내부에서 목록을 다룰 때 배열로 다루기 때문에 조회속도가 빠르다.
 * 
 * 자바에서 제공하는 컬렉션 클래스의 종류
 * 1) List 계열
 *    => null 값을 저장할 수 있다.
 *    => 값을 중복 저장할 수 없다.
 *    => 값을 넣는 순서대로 저장한다.
 *       그래서 값을 꺼낼 때도 넣은 순서대로 꺼낼 수 있다.
 *    => 값을 꺼낼 때 숫자 인덱스를 사용하여 꺼낸다.
 *    => 예) ArrayList, LinkedList
 *    
 * 2) Set 계열
 *    => null 값을 저장할 수 있다.
 *    => 값을 중복 저장할 수 없다.
 *       왜? 클래스 이름을 보라. 집합을 의미한다.
 *    => 값을 넣을 때 인스턴스의 해시값을 기준으로 저장하기 때문에 
 *       순서대로 저장되지 않는다.
 *       그래서 값을 꺼낼 때도 순서대로 꺼낼 수 없다.
 *    => 값을 꺼낼 때 숫자 인덱스로 꺼낼 수 없다.
 *    => 예) HashSet
 *    
 * 3) Map 계열
 *    => 값을 저장할 때 key 객체의 해시 값(hash value)을 사용하여 저장한다.
 *    => 값을 꺼낼 때도 key 객체의 해시 값을 사용하여 꺼낸다.
 *    => 값을 중복 저장할 수 있다.
 *    => 순서대로 저장하고 순서대로 꺼낼 수 없다.
 *    => 보통 문자열 라벨을 사용하여 값을 저장하고 꺼내는 경우에 주로 이용한다.
 *    => 예)
 *       HashMap 
 *       => key나 value로 null을 허용한다.
 *       => 동기화를 지원하지 않는다.
 *          => 여러 스레드가 동시에 접근하여 값을 변경하는 것을 막지 않는다.
 *          => 데이터의 입출력 속도가 빠르다.
 *          => 대신 여러 스레드가 동시에 값을 바꿀 수 있기 때문에
 *             멀티 스레드 상황에서 사용할 때 주의해야 한다.
 *       Hashtable
 *       => key 나 value로 null을 허용하지 않는다.
 *       => 동기화를 지원한다.
 *          => 여러 스레드가 동시에 접근하더라도 그 중 한 개의 스레드만이 접근할 수 있다.
 *          => 데이터의 입출력 속도가 느리다.
 *          => 대신 여러 스레드가 동시에 값을 바꿀 수 없기 때문에
 *             멀티 스레드 상황에서 안전하게 사용할 수 있다.
 */
package step08;

import java.sql.Date;
import java.util.ArrayList;

public class Test07_1 {
  
  public static void main(String[] args) {
    ArrayList dateList = new ArrayList();
    
    dateList.add(Date.valueOf("2017-3-1"));
    dateList.add(Date.valueOf("2017-5-3"));
    dateList.add(Date.valueOf("2017-5-5"));
    dateList.add(Date.valueOf("2017-5-9"));
    Date d1 = Date.valueOf("2017-6-6");
    dateList.add(d1);
    dateList.add(d1);
    
    dateList.add(2, Date.valueOf("2017-2-22"));
    Object removedObj = dateList.remove(3);
    
    Object oldObj = dateList.set(1, Date.valueOf("2017-5-4"));
    
    for (int i = 0; i < dateList.size(); i++) {
      System.out.println(dateList.get(i));
    }
    
    System.out.println("=>" + removedObj);
    System.out.println("=>" + oldObj);
  }
}







