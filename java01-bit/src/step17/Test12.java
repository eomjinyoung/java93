/* 예외처리 : 일반 모드(Exception 계열 예외)와 스텔스 모드(Error와 RuntimeException 계열 예외)
 * => 일반 모드의 예외가 발생하는 경우 반드시 둘 중 하나는 작성해야 한다.
 *    1) try ~ catch ~ 
 *    2) throws 
 * => 스텔스 모드의 예외가 발생하는 경우 예외처리 문법은 선택 사항이다.
 *    즉 try ~ catch ~, throws 를 작성하지 않아도 된다.
 */
package step17;

public class Test12 {

  static void m1(int v) {
    m2(v);
  }
  
  static void m2(int v) {
    m3(v);
  }
  
  static void m3(int v) {
    m4(v);
  }
  
  // m4()에서 발생시킨 예외를 main() 메서드처럼 스택의 상위 메서드에서 처리하도록 만들고 싶다면,
  // 스텔스 모드로 예외를 발생시켜라!
  // 즉 중간에 개입한 메서드들은 예외처리를 하지 않아도 문법적으로 오류가 아니다.
  // 예외 처리 문법을 작성하지 않는다고 해서 예외를 안 던지는 것은 아니다.
  // 단지 조용히 던질 뿐이다.
  static void m4(int v) {
    if (v < 0)
      throw new RuntimeException("음수는 허용하지 않습니다.");
    System.out.println(v);
  }
  
  public static void main(String[] args) { 
    try {
      if (args.length < 1) {
        System.out.println("[사용법] java -cp bin step17.Test11 숫자");
        return ;
      }
      
      m1(Integer.parseInt(args[0]));
      
    } catch (NumberFormatException e) {
      System.out.println("프로그램 아규먼트는 숫자여야 합니다.");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("안녕!");
  }

}




