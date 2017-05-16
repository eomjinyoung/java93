/* nested class: non-static nested class
 * => 다른 말로 "inner 클래스"라고도 한다.
 * => 인스턴스 멤버이기 때문에 다른 인스턴스 멤버만이 사용할 수 있다. 
 */
package step13;

public class Test03_1 {
  // 인스턴스 멤버들
  int a;
  public void m1() {}
  class A { // non-static nested class = inner class
    int a;
  }
  
  // 인스턴스 블록에서는 인스턴스 멤버를 사용할 수 있다.
  public void test() {
    a = 20; // OK
    m1(); // OK
    A obj = new A(); // OK
    obj.a = 200;
  }
  
  public static void main(String[] args) {
    Test03_1 obj = new Test03_1();
    obj.test();
    
    /*
     * main() 은 static 멤버이다. 인스턴스를 생성하지 않고 바로 호출하는 메서드이다.
     * 인스턴스 없이 호출하기 때문에, 그래서 인스턴스 멤버를 직접 사용할 수 없다.
     * 항상 인스턴스를 만든 후에 인스턴스 멤버를 사용해야 한다.
     */
    //a = 20; // 컴파일 오류!
    //m1(); // 컴파일 오류!
    //test(); // 컴파일 오류!
    
    // non-static nested class도 인스턴스 변수나 메서드처럼 인스턴스 멤버이다.
    // 그냥 인스턴스 메서드라고 간주를 하고 사용하면 된다.
    //A obj2 = new A(); // 컴파일 오류!
    
    // 사용하는 방법은?
    // => 잊지마세요. 인스턴스 멤버입니다. 인스턴스 멤버는 인스턴스를 만들 후에 
    //    언제든지 사용할 수 있습니다.
    obj.a = 20; // OK
    obj.m1(); // OK
    obj.test(); // OK
    
    A obj3 = obj.new A(); // OK
    /* 설명
     * => 참조 변수를 선언할 때는 인스턴스 주소가 없어도 된다.
     * => 그러나 객체를 생성할 때는 인스턴스 주소를 앞에 두고 생성한다.
     */
  }
}
