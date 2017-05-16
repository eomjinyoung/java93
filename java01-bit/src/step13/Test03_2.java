/* nested class: non-static nested class II
 * => inner 클래스에서 바깥 클래스의 변수 사용하기 
 */
package step13;

public class Test03_2 {
  int v1;
  int v2;
  
  class A {
    int v1;
    public void m1() {
      this.v1 = 100;
      System.out.printf("A.v1 = %d\n", this.v1);
      
      // inner 클래스에서 바깥 클래스의 인스턴스 변수를 사용하기
      // => 어려워 말라! inner클래스도 Test03_2의 인스턴스 멤버이다.
      //    그러니 test() 메서드처럼 그냥 바깥 클래스의 인스턴스 멤버를 
      //    마음대로 사용할 수 있다.
      System.out.printf("Test03_2.v2 = %d\n", v2);
      
      // v2에 대해 this를 붙이지 말라! this를 붙이면 A 객체의 멤버로 간주한다.
      //System.out.printf("Test03_2.v2 = %d\n", this.v2);
      
      //문제는 A에서 v1변수가 있고, 바깥 클래스에도 v1 변수가 있을 때 
      //어떻게 바깥 클래스의 v1 변수를 사용하는가이다.
      //this를 안 적으면, 일단 현재 인스턴스에서 찾는다.
      //그래도 없으면, 바깥 인스턴스에서 찾는다.
      System.out.printf("A.v1 = %d\n", v1);
      
      //바깥 변수를 꼭 사용하고 싶다면, 
      //인스턴스 변수를 완전한 이름 형태로 기술하라.
      //완전한 이름? 클래스명.this.변수명
      System.out.printf("Test03_2.v1 = %d\n", Test03_2.this.v1);
    }
  }
  
  public void test() {
    A p = new A();
    p.m1();
    System.out.printf("v1=%d, v2=%d\n", this.v1, this.v2);
  }
  
  public static void main(String[] args) {
    Test03_2 obj = new Test03_2();
    obj.v1 = 10;
    obj.v2 = 20;
    obj.test();
    
    
  }
}
