/* 컬렉션(Collection) 클래스 II : java.util.HashSet III   
 */
package step08;

import java.util.HashSet;
import java.util.Iterator;

public class Test07_5 {
  
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
    
    /* "ffff" 제목의 책이 중복 저장되었다. 이유는?
     * => hashCode()의 리턴 값이 다르기 때문이다.
     * => HashSet은 값을 저장할 때 hashCode()의 리턴 값을 가지고 위치를 계산하는데,
     *    같은 값을 갖고 있더라도 hashCode()의 리턴 값이 다르기 때문에,
     *    다른 위치로 저장되어서 중복된 것이다.
     */
    System.out.println(new Book("ffff", "비트출판사", 600).hashCode());
    System.out.println(new Book("ffff", "비트출판사", 600).hashCode());
    System.out.println(new Book("ffff", "비트출판사", 600).hashCode());
    
    /* 어? 아까 String인 경우 값이 같으면 hashCode()의 리턴 값도 같지 않았는가?
     * => 그것은 String 클래스에서 Object로부터 상속 받은 hashCode()를 
     *    오버라이딩(재정의) 했기 때문이다.
     * 
     * 그럼, Book 클래스의 경우에도 hashCode()를 재정의 하면 중복을 피할 수 있겠는가?
     * => 예!
     * 
     */
  }
}







