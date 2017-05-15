/* 컬렉션(Collection) 클래스 : 사용자의 정의 컬렉션 클래스 사용 - ArrayList 
 * => 배열을 이용하여 데이터 목록을 다루는 ArrayList 구현
* => 단점
 *    1) 배열은 고정된 크기의 메모리를 만들어 사용하기 때문에,
 *       배열의 크기를 늘리게 되면 이전 배열의 값을 새 배열로 복사해야 하는 
 *       작업이 필요하다.
 *       => 배열을 복사하는데 시간소요
 *       => 이전의 배열은 가비지가 되기 때문에 메모리를 비효율적으로 사용하게 된다.
 *    2) 입력이나 삭제할 때 마다 배열의 값을 밀고 당기는 작업이 필요하다.
 *       => 배열의 크기가 늘어날 수록 시간이 많이 소요된다.
 *       => 배열의 크기가 늘어나거나 줄어들게 되면 메모리 작업이 필요하기 때문에 
 *          비효율적이다.
 * => 장점
 *    1) 인덱스를 통해 값을 빠르게 찾을 수 있어 조회나 변경 속도가 빠르다.
 */
package step08;

import java.sql.Date;

public class Test06_2 {
  
  public static void main(String[] args) {
    Test06_2_ArrayList dateList = new Test06_2_ArrayList();
    
    dateList.add(Date.valueOf("2017-3-1"));
    dateList.add(Date.valueOf("2017-5-3"));
    dateList.add(Date.valueOf("2017-5-5"));
    dateList.add(Date.valueOf("2017-5-9"));
    dateList.add(Date.valueOf("2017-6-6"));
    
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







