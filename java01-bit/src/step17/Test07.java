/* 예외처리 : 사용자 정의 예외 던지기
 * => 예외 상황이 발생했을 때 예외 객체를 만들어 던진다.
 * => 예외 객체를 만들기 위해 예외 클래스를 선택해야 하는데,
 *    그 선택의 기준은 클래스의 이름이다.
 *    즉 예외 상황을 잘 표현할 수 있는 이름을 가진 클래스를 선택한다. 
 * => 그런데 예외 상황에 딱 맞는 마땅한 클래스가 없을 경우,
 *    또는 예외 상황을 좀 더 잘 표현하고 싶을 경우, 
 *    개발자가 직접 예외 클래스를 만들어 던질 수 있다.
 * => 이 때 그 클래스는 애플리케이션 예외이어야 하기 때문에 
 *    보통 java.lang.Exception을 상속 받아서 만든다.
 * => Exception을 상속 받아 뭔가 특별한 기능을 추가한다기 보다, 
 *    예외 상황을 잘 드러내는 이름을 가진 클래스를 만든다는 의미로 
 *    서브 클래스를 작성해야 한다. 
 */
package step17;

public class Test07 {
  
  // 사용자 정의 예외 클래스를 만드는 이유?
  // => 기능을 확장하기 위함이 아니다.
  // => 예외 상황이 발생했을 때 클래스 이름으로 즉시 그 예외 상황을 파악하려는 것이다.
  // => 그래서 예외 클래스의 상속 관계는 이름으로 예외를 분류하는 데 의미를 두고 있다.
  //    서브 클래스에 아무런 기능이 추가되지 않았다고 선배를 욕하지 말라!
  //    괜히 무식함만 드러낼 뿐이다.
  static class InvalidValueScopeException extends IllegalArgumentException {

    public InvalidValueScopeException() {
      super();
    }

    public InvalidValueScopeException(String message, Throwable cause) {
      super(message, cause);
    }

    public InvalidValueScopeException(String s) {
      super(s);
    }

    public InvalidValueScopeException(Throwable cause) {
      super(cause);
    }
  }
  
  public static void main(String[] args) {
    try {  
      if (args.length < 1)
        throw new IllegalArgumentException("애플리케이션 아규먼트가 없습니다.");
      
      int age = Integer.parseInt(args[0]);
      
      if (age < 1)
        throw new InvalidValueScopeException("나이가 유효하지 않습니다.");
      
      System.out.println(age);
      
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }

}
