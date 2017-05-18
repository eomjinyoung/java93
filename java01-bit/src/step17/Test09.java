/* 예외처리 : throws 선언 II
 * => java.lang.RuntimeException 계열의 예외를 던질 때는
 *    예외를 처리하는 것이 선택사항이다.
 *    컴파일러가 강제로 요구하지 않는다.
 * => 즉,
 *    1) 예외를 처리하는 try ~ catch ~ 를 사용하지 않아도 되고, 
 *    2) 메서드 선언 부에 throws를 적시하지 않아도 된다.
 * => 왜?
 *    스텔스 모드로 예외를 전달하기 위해 특별히 정한 규칙이다.
 */
package step17;

public class Test09 {

  public static void main(String[] args) 
    /*throws IllegalArgumentException, NumberFormatException*/ {
    
    if (args.length < 1)
      throw new IllegalArgumentException("애플리케이션 아규먼트가 없습니다.");
    
    int age = Integer.parseInt(args[0]);
    
    if (age < 1)
      throw new IllegalArgumentException("나이가 유효하지 않습니다.");
    
    System.out.println(age);
  }

}
