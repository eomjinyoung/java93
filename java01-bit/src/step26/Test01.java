/* 클래스 정보를 다루는 도구 얻기 */
package step26;

public class Test01 {

  public static void main(String[] args) throws Exception {
    // 1) 인스턴스를 통해서 얻기
    String obj = new String("Hello");
    Class<?> c1 = obj.getClass();
    // => 인스턴스만 있으면 그 인스턴스가 어떤 클래스의 객체인지 쉽게 알아낼 수 있다.
    
    // 2) Class.forName() 메서드를 통해서 얻기
    Class<?> c2 = Class.forName("java.lang.String");
    // => 클래스 이름을 문자열로 받을 수 있기 때문에 유지보수가 쉽다.
    
    // 3) 모든 클래스에 내장된 "class" 스태틱 변수를 통해서 얻기
    Class<?> c3 = String.class;
    // => 코딩이 쉽다. 그러나 클래스 이름을 코드로 명시하기 때문에 유지보수가 어렵다.  

  }

}
