/* 컬렉션(Collection) 클래스 II : java.util.LinkedList
 * => 내부에서 목록을 다룰 때 bucket 역할을 수행하는
 *    Node 객체에 값을 담는다.
 * => 그리고 그 Node 객체를 앞, 뒤로 연결한다.
 * => Node를 추가하고, 삽입하고, 제거하고, 조회하는 방법은
 *    linked list 알고리즘을 따른다.
 * => ArrayList와 비교하면?
 *    1) ArrayList에 비해 조회 속도는 느리다.
 *       => 값을 찾기 위해서 링크를 따라 가야하기 때문이다.
 *    2) 대신 중간에 값을 삽입하거나, 삭제하는 속도가 빠르다.
 *       => 앞/뒤 노드의 주소를 조정하여 값을 삽입하거나 삭제하기 때문이다.
 *       => 배열은 값을 삽입하거나 삭제할 때 마다, 나머지 값을 미루거나 당겨야 한다. 
 */
package step08;

import java.sql.Date;
import java.util.LinkedList;

public class Test07_2 {
  
  public static void main(String[] args) {
    LinkedList dateList = new LinkedList();
    
    dateList.add(Date.valueOf("2017-3-1"));
    dateList.add(Date.valueOf("2017-5-3"));
    dateList.add(Date.valueOf("2017-5-5"));
    dateList.add(Date.valueOf("2017-5-9"));
    Date d1 = Date.valueOf("2017-6-6");
    dateList.add(d1);
    dateList.add(d1);
    
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







