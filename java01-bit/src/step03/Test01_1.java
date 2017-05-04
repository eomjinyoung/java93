/* 산술연산자(+, -, *, /, %) */
package step03;

public class Test01_1 {

  public static void main(String[] args) {
    System.out.println(10 + 3);
    System.out.println(10 - 3);
    System.out.println(10 * 3);
    
    System.out.println(10 / 3); 
    // 결과는 3이다. 이유는? 
    // int / int = int 이기 때문이다.
    // 소수점 이하가 제거된다.
                  
    System.out.println(10 % 3);
  }
}

/* 기본 연산 규칙?
 * => 자바는 같은 타입의 값끼리 연산이 가능하다.
 * => 그 결과 값이 그 타입이다.
 * 
 */
