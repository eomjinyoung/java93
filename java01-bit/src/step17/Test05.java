/* 예외처리 : catch 
 * => throw가 전달한 예외 객체를 받는 명령이다.
 * => 문법
 *    catch (예외 객체를 받을 변수) 
 * => 예외 객체의 타입 별로 구분하여 받을 수 있다.
 *    - 변수의 타입에 따라 예외 정보를 받을 catch 문이 선택된다.
 */
package step17;

public class Test05 {
  public static void main(String[] args) {
    try {  
      if (args.length < 1)
        throw new Throwable("애플리케이션 아규먼트가 없습니다.");
      
      int age = Integer.parseInt(args[0]);
      
      if (age < 1)
        throw new Throwable("나이가 유효하지 않습니다.");
      
      System.out.println(age);
      
    } catch (NumberFormatException e) {
      System.out.println("애플리케이션의 아규먼트가 숫자가 아닙니다.");
      
    } catch (Throwable ex) { 
      System.out.println(ex.getMessage());
    }
  }

}
