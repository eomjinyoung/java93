/* 문장: 조건문 if와 중괄호{} */
package step04;

public class Test01_2 {
  public static void main(String[] args) {
    if (false) 
      System.out.println("홍길동");
      System.out.println("임꺽정");
    /* 주의!
     * 중괄호를 사용하지 않으면, 첫 번째 문장만 if에 소속된다.
     */
    System.out.println("------------------------");
    
    if (false) {
      System.out.println("홍길동");
      System.out.println("임꺽정");
    }
  }
}
