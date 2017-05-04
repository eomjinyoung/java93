/* 산술연산자(+, -, *, /, %): 명시적 형변환(explicit type conversion)
 * => 개발자가 형변환에 개입하는 것.
 * => 명령어를 사용하여 변수의 값을 특정 타입으로 강제 변환시키는 것.
 *    변수의 타입이 바뀌는 것이 아니라 
 *    변수의 값을 꺼내서 그 값의 타입을 바꾸는 것이다.
 *    이런 이유로 "type conversion" 말 대신에 "type casting"이라는 말을 사용하기도 한다.
 * => 문법
 *    (목표타입)변수
 *    (목표타입)값 
 * => boolean을 정수나 부동소수점으로 바꿀 수는 없다.
 * => 정수나 부동소수점을 boolean으로 바꿀 수 없다.
 * => 즉 byte, short, char, int, long, float, double 끼리 형변환 가능.
 * => 클래스 문법에서는 같은 상속관계를 갖는 부류끼리 형변환 가능.
 */
package step03;

public class Test01_3 {

  public static void main(String[] args) {
    int a = 5;
    int b = 2;
    float f = a / b; // int 변수들의 연산 결과는 int이다. 
                     // 이미 5 / 2의 계산 결과는 소수점 이하가 짤린 2로 결정된 것이다.
                     // 그러니 f에 저장되는 것은 2이다.
    System.out.println(f);
    
    //1) 명시적 형변환을 이용하여 계산하기
    float f2 = (float)a / (float)b; // float과 float의 연산 결과는 float이다.
    System.out.println(f2);
    
    //2) 명시적 형변환과 암시적 형변환을 함께 이용하기
    float f3 = (float)a / b; // float / int = float / (float) = (float)
    System.out.println(f3);
    
    float f4 = a / (float)b; // float / int = float / (float) = (float)
    System.out.println(f4);
  }
}



