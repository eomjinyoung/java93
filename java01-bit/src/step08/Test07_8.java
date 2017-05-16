/* 컬렉션(Collection) 클래스 II : java.util.HashMap
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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Test07_8 {
  
  static class Book {
    String title;
    String press;
    int page;
    
    public Book(String title, String press, int page) {
      this.title = title;
      this.press = press;
      this.page = page;
    }
    
    public String toString() {
      return String.format("%s,%s,%d", title, press, page);
    }
  }
  
  public static void main(String[] args) {
    HashMap map = new HashMap();
    
    /* put(key, value)
     * key 객체: 
     *   => key 객체의 hashCode() 리턴 값을 사용하여 
     *      value를 저장할 때 사용할 위치를 계산한다.
     *   => 그래서 key 객체는 같은 값을 가진 객체인 경우 
     *      같은 hashCode()를 리턴하는 클래스를 사용한다.
     *      예) String, 랩퍼 클래스(Byte, Short, Integer, Long, 
     *                              Float, Double, Boolean, Character)
     * value 객체: Map 컬렉션에 보관될 값 
     */ 
    map.put(new String("key1"), new Book("aaaa", "비트출판사", 100));
    map.put("key2", new Book("bbbb", "비트출판사", 200));
    map.put("key3", new Book("cccc", "비트출판사", 300));
    map.put("key4", new Book("dddd", "비트출판사", 400));
    map.put(1, new Book("eeee", "비트출판사", 500));
    map.put(2, new Book("ffff", "비트출판사", 600));
    map.put(3, new Book("ffff", "비트출판사", 600)); 

    // 값을 꺼내는 방법
    // => 값을 저장할 때 사용한 key를 가지고 꺼낸다.
    // => 반드시 같은 인스턴스일 필요는 없다.
    //    저장할 때 사용한 key의 hashCode() 리턴 값과
    //    같은 hash value를 가진다면 값을 꺼내는 key로 사용할 수 있다.
    //    물론, equals()의 결과도 true여야 한다.
    System.out.println(map.get(new String("key1")));
    System.out.println(map.get(1));
    
    /* Key로 사용할 수 있는 객체?
     * => 인스턴스 변수에 같은 값을 갖고 있으면 같은 hash 값을 리턴하는 크래스
     *    물론 equals()로 true를 리턴한다.
     * => 예) String, Wrapper classes
     */
    String s1 = new String("Hello");
    String s2 = new String("Hello");
    if (s1 == s2) 
      System.out.println("s1 == s2");
    else
      System.out.println("s1 != s2");
    System.out.printf("%d, %d\n", s1.hashCode(), s2.hashCode());
    System.out.println(s1.equals(s2));
  }
}







