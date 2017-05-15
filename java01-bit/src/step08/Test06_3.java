/* 컬렉션(Collection) 클래스 : 사용자의 정의 컬렉션 클래스 사용 - LinkedList
 * => linked list 알고리즘을 이용하여 데이터 목록을 다루는 LinkedList 구현
 * => 배열의 단점을 제거한다.
 *    1) 연결 고리를 이용하여 값과 값을 연결한다.
 *    2) 삽입, 삭제 속도가 빠른다.
 * => 단점
 *    1) 값을 찾기 위해 계속 그 링크를 따라가야 하기 때문에 속도가 느리다. 
 * 
 */
package step08;

import java.sql.Date;

public class Test06_3 {
  
  public static void main(String[] args) {
    Test06_3_LinkedList dateList = new Test06_3_LinkedList();
    
    dateList.add(Date.valueOf("2017-3-1"));
    dateList.add(Date.valueOf("2017-5-3"));
    dateList.add(Date.valueOf("2017-5-5"));
    dateList.add(Date.valueOf("2017-5-9"));
    dateList.add(Date.valueOf("2017-6-6"));
    
    System.out.println(dateList.size());
    
    dateList.add(3, Date.valueOf("2017-2-22"));
    
    Object removedObj = dateList.remove(3);
    
    Object oldObj = dateList.set(1, Date.valueOf("2017-5-4"));
    
    for (int i = 0; i < dateList.size(); i++) {
      System.out.println(dateList.get(i));
    }
    System.out.println("=>" + removedObj);
    System.out.println("=>" + oldObj);
  }
}







