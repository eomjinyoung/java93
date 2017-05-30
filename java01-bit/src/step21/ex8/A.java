/* 인터페이스 1
 * => 인터페이스는 호출 규칙을 정의하는 것이기 때문에 추상 메서드만 선언 가능하다.
 *    즉 인터페이스에 선언된 모든 메서드는 public 이고 abstract 이다.
 * => 인터페이스는 인스턴스 변수를 가질 수 없다.
 *    즉 인터페이스에 선언된 모든 필드는 public 이고 static 이며 final 이다.
 */
package step21.ex8;

public interface A {
  // [메서드 선언 규칙]
  // 1) 규칙이기 때문에 무조건 공개 메서드이고, 추상 메서드이다.
  public abstract void m1();
  
  // 2) public을 생략해도 내부적으로 public으로 간주한다.
  abstract void m2();
  
  // 3) abstract를 생략해도 내부적으로 abstract로 간주한다.
  void m3();
  
  // 4) 절대 구현 메서드를 가질 수 없다.
  //void m4() {} // 컴파일 오류!
  
  // [필드 선언 규칙]
  // 1) 규칙이기 때문에 무조건 공개 필드이고, 스태틱 필드이다. 
  //    그리고 값을 바꿀 수 없는 상수 필드이다.
  public static final int v1 = 200;
  
  // 2) public을 생략하면 내부적으로 public으로 간주한다.
  static final int v2 = 200;
  
  // 3) static을 생략하면 내부적으로 static으로 간주한다.
  final int v3 = 200;
  
  // 4) final을 생략하면 내부적으로 final로 간주한다.
  int v4 = 200;
}
