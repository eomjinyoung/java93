/* 컬렉션(Collection) 클래스 : ArrayList 제네릭 적용 전 
 */
package step08;

import java.sql.Date;

public class Test06_4 {
  
  public static void main(String[] args) {
    Test06_2_ArrayList dateList = new Test06_2_ArrayList();
    
    dateList.add(Date.valueOf("2017-5-3"));
    dateList.add(Date.valueOf("2017-5-5"));
    dateList.add(Date.valueOf("2017-5-9"));
    dateList.add(Date.valueOf("2017-6-6"));
    
    for (int i = 0; i < dateList.size(); i++) {
      //=> 값을 꺼낼 때 마다 그 값의 본래 타입으로 형변환한 다음에 사용해야 한다.
      Date date = (Date)dateList.get(i);
      System.out.printf("%d월 %d일\n",date.getMonth() + 1, date.getDate());
    }
  }
}







