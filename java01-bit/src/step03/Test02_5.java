/* 증가/감소 연산자 - 전위 연산자와 후위 연산자의 차이점 IV
 */
package step03;

public class Test02_5 {
  public static void m1(int value) {
    System.out.println(value);
  }

  public static void main(String[] args) {
    int i = 3;
    System.out.println(++i);
    /* 실행 순서
     * => i = i + 1
     * => System.out.println(4)
     * => println() 실행!
     */
    
    i = 3;
    System.out.println(i++);
    /* 실행 순서
     * System.out.println(3)  // 함수를 호출할 때 괄호() 안의 명령이 모두 실행돼야지만 
     *                        // 함수를 호출할 수 있다.
     * i = i + 1
     * println() 실행!
     */
  }
}



