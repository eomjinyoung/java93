/* 컬렉션(Collection) 클래스 II : java.util.HashSet IV   
 */
package step08;

import java.util.HashSet;
import java.util.Iterator;

public class Test07_6 {
  
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
    
    public int hashCode() {
      return 1;
    }
    
    /* hashCode() 메서드 뿐만아니라 equals()도 오버라이딩 해야 한다.
     * => 보통 두 객체가 같은지 비교할 때 hashCode()의 리턴 값과,
     *    equals()의 리턴 값을 모두 비교한다. 
     * => 그렇게 허술하지 않다. 꼼꼼하다. 
     *    그래서 개발자들은 보통 hashCode()를 오버라이딩 할 때
     *    equals()도 함께 오버라이딩 한다.
     */
    public boolean equals(Object obj) {
      return true;
    }
  }
  
  public static void main(String[] args) {
    HashSet set = new HashSet();
    
    set.add(new Book("aaaa", "비트출판사", 100));
    set.add(new Book("bbbb", "비트출판사", 200));
    set.add(new Book("cccc", "비트출판사", 300));
    set.add(new Book("dddd", "비트출판사", 400));
    set.add(new Book("eeee", "비트출판사", 500));
    set.add(new Book("ffff", "비트출판사", 600));
    set.add(new Book("ffff", "비트출판사", 600)); 

    Iterator iterator = set.iterator();
    while (iterator.hasNext()) { 
      System.out.println(iterator.next());
    }
    System.out.println("------------------------------");
    
    System.out.println(new Book("ffff", "비트출판사", 600).hashCode());
    System.out.println(new Book("ffff", "비트출판사", 600).hashCode());
    System.out.println(new Book("ffff", "비트출판사", 600).hashCode());
    
    /* 어? 객체가 처음 한 개만 저장되었네요?
     * => 우리가 hashCode()를 오버라이딩 할 때
     *    변수의 값에 상관없이 무조건 1을 리턴하게 했고,
     *    equals()의 리턴 값을 무조건 true를 리턴하게 했기 때문이다.
     * => HashSet 입장에서는 객체를 저장하기 전에
     *    hashCode(), equals()를 호출해봤더니만, 같다라고 
     *    결과가 나오기 때문에 같은 객체로 취급하여
     *    중복 저장하지 않는다. 
     * 
     */
  }
}







