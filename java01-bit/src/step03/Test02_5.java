/* 증가/감소 연산자 - 전위 연산자와 후위 연산자의 차이점 IV
 */
package step03;

public class Test02_5 {
  
  public static void m1(int value) {
    System.out.println(value);
  }

  public static void main(String[] args) {
    int i = 3;
    m1(++i);
    /* 실행 순서
     * => i = i + 1
     * => m1(4) <-- i 변수의 값을 그 자리에 놓는다.
     * => m1(4) <-- 함수를 호출한다.
     */
    
    i = 3;
    m1(i++);
    /* 실행 순서
     * m1(3) <-- i 변수의 값을 그 자리에 놓는다. 
     *           함수를 호출할 때 괄호() 안의 명령이 모두 실행돼야지만 
     *           함수를 호출할 수 있다. 그래서 당장 호출하지는 않는다.
     * i = i + 1 
     * m1(3) <-- 함수를 호출한다.
     */
  }
}



