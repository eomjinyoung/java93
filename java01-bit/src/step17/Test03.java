/* 예외처리 : 예외 발생 시 그 정보를 전달하고 전달 받는 방법
 * => 예외 정보를 호출자에게 전달하는 방법
 *    throw 예외정보를_담은_객체;
 *    => 예외정보를 담은 객체란?
 *       java.lang.Throwable 타입의 객체이다.
 *    => java.lang.Throwable 클래스 계층 구조
 *       Throwable
 *         |--> Error
 *         |--> Exception
 *                |--> RuntimeException
 *                       |--> NullPointerException 
 *                |--> IOException
 *                       |--> FileNotFoundException
 *                       |--> EOFException
 *                |--> SQLException
 *    => 예외 종류
 *       1) 시스템 예외(Error 타입 예외)
 *          - JVM이 발생시키는 예외.
 *          - 개발자가 처리하는 예외가 아니다.
 *          - 치명적인 예외라서 개발자가 예외를 처리하더라도,
 *            가능한 JVM을 종료해야 한다. 
 *          - 이 예외의 경우, 
 *            개발자는 JVM이 종료되기 전에 작업 중인 파일을 저장한다거나 
 *            예외에 대한 로그를 파일에 쓴다거나 
 *            사용자에게 예외 상황을 출력하는 등의 마무리 작업을 하고
 *            JVM을 종료한다.
 *       2) 애플리케이션 예외(Exception 타입 예외)
 *          - 애플리케이션에서 발생하는 예외.
 *          - 개발자가 처리해야 하는 예외이다.
 *          - 예외를 처리한 후에 애플리케이션을 계속 실행할 수 있다. 
 * 
 * => 예외 정보를 받는 방법
 *    try {
 *      예외를 던지는 코드
 *    } catch (예외를 받을 변수 선언) {
 *      예외를 처리하는 코드
 *    }
 * 
 * => 예외 처리 문법의 이점
 *    1) 예외가 발생하더라도 적당한 처리를 한 후 
 *       시스템을 멈추지 않고 계속 실행시킬 수 있다.
 *    2) 메서드가 리턴하든 안하든, 리턴하는 값의 타입이 무엇이든 
 *       상관없이 안전하고 확실하게 호출자에게 예외 정보를 전달할 수 있다.
 *    3) 예외를 처리하는 입장에서는 try 블록 안에는 예외 상황이 아닐 때의 작업 코드를 두고,
 *       catch 블록 안에는 예외를 처리하는 코드를 둠으로써
 *       정상 작업 코드와 예외 처리 코드를 분리하는 효과가 있다.
 *       즉 코드의 가독성을 높여준다. 
 */
package step17;

public class Test03 {
  // 메서드를 실행하다가 예외를 던질 수 있는 경우
  // => 메서드 선언부에 어떤 예외가 던져질 수 있는지 적어야 한다.
  public static float divide(float a, float b) throws Throwable {
    if (b == 0) {
      // 예외 상황이 발생하면, 호출자에게 그 정보를 전달해야 한다.
      throw new Throwable("0으로 나누지 마세요!");
    }
    return a / b;
  }
  
  public static void main(String[] args) {
    try {
      // 예외를 던질 수 있는 코드는 try 블록 안에 둔다.
      float result = divide(10, 2);
      System.out.println(result);
      result = divide(10, 0);
      System.out.println(result);
      
    } catch (Throwable ex) {
      // 예외를 처리하는 코드는 catch 블록 안에 둔다.
      System.out.println(ex.getMessage());
    }
    
    System.out.println("안녕!!!");
  }

}
