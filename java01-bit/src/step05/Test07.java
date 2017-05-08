/* 메서드 : 스택(stack) 메모리
 * => 메서드가 호출되면 그 메서드의 로컬 변수가 스택 메모리에 준비된다.
 * => 메서드 호출이 끝나면 그 메서드가 사용한 스택 메모리가 제거된다.
 */
package step05;

public class Test07 {
  public static void m1(int a) {
    m2(++a);
    System.out.printf("m1():%d\n", a);
    m2(++a);
    System.out.printf("m1():%d\n", a);
  }
  
  public static void m2(int a) {
    m3(++a);
    System.out.printf("m2():%d\n", a);
  }
  
  public static void m3(int a) {
    ++a;
    System.out.printf("m3():%d\n", a);
  }
  
  public static void main(String[] args) {
    int a = 20;
    m1(a); // a 변수를 넘기는 것이 아니라, a 변수의 값을 넘긴다.
    System.out.printf("main():%d\n", a);
  }
}








