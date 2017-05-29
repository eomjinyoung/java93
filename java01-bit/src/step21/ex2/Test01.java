/* 상속을 적용하기
 * => 상속 기법의 종류
 * 1) specialization
 *    - 수퍼 클래스를 상속 받아 기능을 추가하는 것!
 *    - 결국 더 특화시키는 것이다. 
 *    - "샤프"를 상속 받아 "볼펜 기능"을 추가한다면, 더 특별한 샤프가 된 것이다.   
 * 2) generalization
 *    - 서브 클래스들의 공통 분모를 찾아 그것을 부모 클래스로 뽑아 내는 것!
 *    - "에어콘", "온풍기", "선풍기", "공기청전기"의 공통 기능을 뽑아보면, 
 *      "프로펠러를 돌리는 기능", "단계별로 프로펠러 속도 조절 기능"이 있다.
 *      이런 공통 기능을 뽑아서 수퍼 클래스로 만든다!
 * => 실습!
 *    - Sedan, Truck, Bulldozer의 공통 기능 및 공통 필드를 뽑아서 수퍼클래스로 정의하고,
 *      이들 클래스가 그 수퍼 클래스의 서브 클래스가 되도록 변경한다.
 *      이것을 상속 기법 중에서 "generalization"이라 부른다.
 *    1) Sedan, Truck, Bulldozer의 공통 필드 및 메서드(model, maker, cc, run())를 
 *       추출하여 Car 클래스를 만든다.
 *    2) Sedan, Truck, Bulldozer를 Car의 서브 클래스로 정의한다.
 *    3) Sedan, Truck의 공통 필드 및 메서드(storage, load())를 
 *       추출하여 Loader 클래스를 만든다.
 *    4) Sedan, Truck 클래스를 Loader의 서브 클래스로 정의한다. 
 */
package step21.ex2;

public class Test01 {

  public static void main(String[] args) {
    Truck car1 = new Truck("타이탄", "비트자동차", 10000);
    car1.load("자갈");
    car1.run();
    car1.dump();

  }

}
