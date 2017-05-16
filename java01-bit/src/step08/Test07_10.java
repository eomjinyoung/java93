/* 컬렉션(Collection) 클래스 II : java.util.HashMap III
 */
package step08;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Test07_10 {
  
  // 사용자 정의 클래스를 Map 컬렉션의 key로 사용할 때!
  static class MyKey {
    String value;
    
    public MyKey(String value) {
      this.value = value;
    }
    
    public String toString() {
      return value;
    }

    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((value == null) ? 0 : value.hashCode());
      return result;
    }

    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      MyKey other = (MyKey) obj;
      if (value == null) {
        if (other.value != null)
          return false;
      } else if (!value.equals(other.value))
        return false;
      return true;
    }
  }
  
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
    
    map.put(new MyKey("key1"), new Book("aaaa", "비트출판사", 100));
    map.put(new MyKey("key2"), new Book("bbbb", "비트출판사", 200));
    map.put(new MyKey("key3"), new Book("cccc", "비트출판사", 300));
    map.put(new MyKey("key4"), new Book("dddd", "비트출판사", 400));

    // Map 컬렉션에서 값 꺼내기
    // 방법1) value 목록을 리턴 받아 꺼내기 
    // => value 목록을 리턴 받는다.
    Collection valueList = map.values();
    
    // => 값이 들어 있는 컬렉션에서 값을 한 개씩 꺼내줄 도구를 얻는다. 
    Iterator iterator = valueList.iterator();
    
    // => 그 도구를 사용하여 값을 꺼낸다.
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    System.out.println("------------------------------");
    
    // => for (변수선언 : 배열 또는 Collection) 문법 사용하기 
    for (Object value : valueList) {
      System.out.println(value);
    }
    System.out.println("------------------------------");
    
    
    // 방법2) key 목록을 리턴 받아 꺼내기
    // => key 목록을 리턴 받는다.
    Set keySet = map.keySet();
    
    // => key 목록에서 key 배열을 얻는다. 
    //    안타깝게도 Set 에는 값을 한 개씩 꺼내는 메서드가 없기 때문에 
    //    이런 번거로운 방식을 취한다.
    Object[] keyArray = keySet.toArray();
    for (int i = 0; i < keyArray.length; i++) {
      System.out.println(map.get(keyArray[i]));
    }
    System.out.println("--------------------------");
    
    // => Set은 Collection의 서브 타입이다.
    //    Collection에 있는 값을 꺼낼 때 다음의 for 문법을 사용할 수 있다. 
    //    for(변수선언 : 배열 또는 Collection 객체)
    for (Object key : keySet) {
      System.out.println(map.get(key));
    }
    System.out.println("--------------------------");
    
    // 방법3) key와 value를 한쌍으로 하는 목록을 리턴 받기 
    // => key/value를 한 묶음으로 만든 목록을 리턴받는다.
    Set entrySet = map.entrySet();
    for (Object object : entrySet) {
      Entry entry = (Entry)object;
      System.out.printf("%s=%s\n", entry.getKey(), entry.getValue());
    }
  }
}







