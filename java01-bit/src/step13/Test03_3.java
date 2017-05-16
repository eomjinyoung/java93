/* nested class: non-static nested class III
 * => inner 클래스에서 바깥 클래스의 변수 사용하기 
 */
package step13;

public class Test03_3 {
  int v1 = 100;
  int v2 = 300;
  
  class A {
    int v1 = 200;
    
    public void m1() {
      System.out.printf("A.v1 = %d\n", v1);
      System.out.printf("A.v1 = %d\n", this.v1);
      System.out.printf("A.v1 = %d\n", A.this.v1);
      System.out.printf("Test03_3.v1 = %d\n", Test03_3.this.v1);
      
      System.out.printf("Test03_3.v2 = %d\n", v2);
    }
  }
  
  public static void main(String[] args) {
    Test03_3 obj = new Test03_3();
    A obj2 = obj.new A();
    obj2.m1();
  }
}
