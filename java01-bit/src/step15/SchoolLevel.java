/* enum 문법: 상수를 전문적으로 정의하는 문법
 * => 값을 지정하지 않고 상수의 이름만 지정한다.
 * => 상수 타입의 변수를 선언할 수 있다.
 */
package step15;

public enum SchoolLevel {
  /* 다음 각각의 상수는 SchoolLevel의 객체이다.
   * 즉 "HIGH_SCHOOL"의 타입이 "SchoolLevel"라는 뜻이다.
   * 각 상수 객체는 상수명과 인덱스 값을 내부 변수에 보관한다.
   * => 각 상수 객체가 상수명과 인덱스를 갖고 있다는 것을 확인한 것이,
   *    Test03.java 예제이다.
   */
  HIGH_SCHOOL, /* 의미: SchoolLevel HIGH_SCHOOL = new SchoolLevel();*/ 
  BACHELOR,    /* 의미: SchoolLevel BACHELOR = new SchoolLevel();*/ 
  MASTER,      /* 의미: SchoolLevel MASTER = new SchoolLevel();*/ 
  DOCTOR       /* 의미: SchoolLevel DOCTOR = new SchoolLevel();*/ 
}
