/* 컬렉션(Collection) 클래스 II : java.util.HashSet II   
 */
package step08;

import java.util.HashSet;
import java.util.Iterator;

public class Test07_4 {
  
  public static void main(String[] args) {
    HashSet set = new HashSet();
    
    set.add(new String("홍길동"));
    set.add(new String("임꺽정"));
    set.add(new String("유관순"));
    set.add(new String("윤봉길"));
    set.add(new String("안중근"));
    set.add(new String("김구"));
    set.add(new String("김구")); 
    /* "김구" 문자열인 경우에 서로 다른 인스턴스임에도 불구하고 중복되지 않는다.
     * 왜? 
     * => Set은 객체(의 주소)를 저장할 때 그 객체에 대해 hashCode() 메서드를 호출한 후,
     *    그 리턴 값으로 위치를 계산한다.
     * => String 클래스는 같은 값을 갖는 경우 같은 hash value를 리턴하도록 
     *    hashCode()를 오버라이딩하였다.
     *    즉 위의 두 개의 "김구" String 객체는 비록 인스턴스는 다르지만,
     *    값이 같기 때문에 hashCode()의 리턴값도 같다.
     *    그래서 위치를 계산한 값도 같다.
     *    위치 계산 값이 같으니까 같은 값으로 간주하여 중복 저장하지 않는다.  
     */
    System.out.println(new String("김구").hashCode());
    System.out.println(new String("김구").hashCode());
    System.out.println(new String("김구").hashCode());
    
    /* 결론!
     * HashSet 컬렉션에 값을 저장할 때,
     * 인스턴스의 주소가 영향을 끼치는 것이 아니라 
     * hashCode()의 리턴 값이 영향을 끼친다.
     */
    
    
    Iterator iterator = set.iterator();
    while (iterator.hasNext()) { 
      System.out.println(iterator.next());
    }
    
  }
}







