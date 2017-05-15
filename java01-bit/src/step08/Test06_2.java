/* 컬렉션(Collection) 클래스 : 사용 전 - 목록을 다루는 클래스 구현 
 * => 배열을 이용하여 데이터 목록을 다루는 ArrayList 구현
 * 
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
    
    for (int i = 0; i < dateList.size(); i++) {
      System.out.println(dateList.get(i));
    }
  }
}







