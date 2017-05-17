/* 제네릭(Generic) 문법 : 사용 전
 * => 값을 꺼낼 때 마다 본래 타입으로 형변환 해야 한다.
 */
package step14;

public class Test01 {
  public static void main(String[] args) {
    Bucket b = new Bucket();
    
    String str = new String("Hello");
    System.out.println(str.length());
    
    b.setValue(str);
    
    //문제점! 번거롭게 값을 꺼낼 때 마다 형변환 해야 한다.
    String str2 = (String)b.getValue();
    System.out.println(str2.length());
  }
}
