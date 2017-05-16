/* final : 변수에 final을 붙이는 경우
 */
package step12.ex3;

public class D {
  //1) 상수 값을 정의하고 싶을 때
  //   => 보통 클래스 변수를 상수 변수로 만든다.
  //   => 상수 변수는 보통 외부에 완전 공개한다.
  //   => 상수 변수임을 직관적으로 알 수 있도록 변수명을 대문자로 작성한다.
  //      그리고 단어와 단어 사이에는 밑줄(_)를 긋는다.
  public static final int LEVEL_GUEST = 0;
  public static final int LEVEL_MEMBER = 1;
  public static final int LEVEL_ADMIN = 0;
  
  //2) 파라미터 변수를 상수로 선언한다.
  //   => 파라미터 변수는 외부에서 전달한 값을 보관하는 변수이다.
  //   => 메서드 안에서 파라미터 변수를 임의로 변경하지 못하도록 막는 것이 좋다.
  public void m1(final int a, final String b, final Object obj, final boolean c) {
    // final 로 선언된 파라미터는 내부에서 변경할 수 없다.
    // 오직 조회용으로만 사용해야 한다.
    a = 20; // 컴파일 오류!
    b = "Hello"; // 컴파일 오류!
    obj = new java.util.Date(); // 컴파일 오류!
    c = true; // 컴파일 오류!
    
  }
}
