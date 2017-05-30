/* 인터페이스 사용 전
 * => 특정한 클래스의 서브 클래스가 아니면 사용할 수 없는 문제.
 *    이것이 "상속의 한계"이다.
 */
package step21.ex5;

public class Test01 {

  public static void main(String[] args) {
    Truck car1 = new Truck("타이탄", "비트자동차", 10000);
    Sedan car2 = new Sedan("티코", "비트자동차", 980, true);
    Bulldozer car3 = new Bulldozer("제우스", "비트자동차", 20000);
    Tesla car4 = new Tesla();
    
    car1.run();
    car2.run();
    car3.run();
    car4.run();
    
    System.out.println("[Truck 테스트]----------------");
    CarTester.test(car1);
    
    System.out.println("[Sedan 테스트]----------------");
    CarTester.test(car2);
    
    System.out.println("[Bulldozer 테스트]----------------");
    CarTester.test(car3);
    
    System.out.println("[Tesla 테스트]----------------");
    CarTester.test(car4); // 컴파일 오류!
    /* Tesla 테스트 하기
     * => Tesla는 Car의 서브 클래스가 아니기 때문에 test() 메서드의 파라미터로 넘길 수 없다.
     * => 해결책
     * 1) Tesla를 Car의 서브 클래스로 만드는 방법
     *    - 이미 Tesla는 Motor의 서브 클래스이다. 
     *      그래서 Car를 상속 받을 수 없다.
     *      자바는 다중 상속을 지원하지 않는다.
     *    - Motor의 상속을 포기하고 Car를 상속 받는다면?
     *      그러면 Motor의 기능을 모두 Tesla에 재작성해야 한다.
     *      Motor의 기능이 몇 개 없다면 가능하겠지만,
     *      실무에서 그런 경우는 드물다. 그러니 현실성이 없다.
     *    - Car를 상속 한다면,
     *      Tesla에는 필요도 없는 필드나 메서드를 상속 받을 수 있다.
     *    => 결론!
     *      상속으로 해결하는데는 한계가 있다.
     *      새로운 기법이 필요하다!
     *      그래서 등장한 문법이 바로 "인터페이스(interface)"이다.
     * 2) 인터페이스를 이용하여 CarTester(자동차검사소)가 Car를 테스트 할 때 
     *    사용할 규칙을 정의하는 것이다.
     *    - 엔진으로 움직이는 차든 모터로 움직이는 차든 상관없이 
     *      지정된 규칙을 따르기만 한다면 테스트를 수행할 수 있을 것이다.
     */
  }

}







