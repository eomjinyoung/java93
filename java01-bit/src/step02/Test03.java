/* 변수 선언: 부동소수점 변수 */
package step02;

public class Test03 {

  public static void main(String[] args) {
    float f;    // 4 byte 크기의 메모리 
    double d;   // 8 byte 크기의 메모리
    
    f = 9.999999f; // 유효자릿수 7자리
    System.out.println(f);
    
    f = 999999.9f; // 유효자릿수 7자리
    System.out.println(f);
    
    f = 9.9999997f; // 유효자릿수 7자리를 넘기면? 값이 짤리거나 반올림 한다.
      // 그래서 유효자릿수를 넘지 않는 값을 저장해야 올바르게 꺼낼 수 있다.
      // 즉 컴파일 할 때 오류가 안난다고 안심해서는 안된다.
      // 반드시 유효자릿수를 지켜야 한다.
    System.out.println(f); 
    
    f = 3.14159234567f;
    System.out.println(f); 
    
    d = 3.14159234567f; // 3.14159234567 값을 float으로 표현할 때 이미 값이 짤린다.
      // 그래서 d 변수에 들어 갈 때는 이미 짤린 값이 들어간다.
    System.out.println(d);
    
    d = 3.14159234567; // 부동소수점을 배정도 값으로 표현하고 싶다면 f, F를 붙이지 말라!
      // 그래서 8바이트 배정도 부동소수점으로 표현된다.
    System.out.println(d);
  }

}


