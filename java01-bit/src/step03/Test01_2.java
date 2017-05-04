/* 산술연산자(+, -, *, /, %): 정수 연산의 최소 단위는 int이다. */
package step03;

public class Test01_2 {

  public static void main(String[] args) {
    byte b1 = 10;
    byte b2 = 20;
    byte b3 = 10 + 20;
    /* => 상수와 상수이 연산 결과는 상수이다.
     * => 상수 값을 변수에 저장할 때, 
     *    저장 가능하다면 OK!
     *    저장 불가능하다면 컴파일 오류!
     */
    //byte b33 = 10 + 118; // 상수 값을 메모리에 담을 수 없기 때문에 컴파일 오류!
    
    //byte b4 = b1 + b2; // 컴파일 오류!
    //byte b5 = b1 + 20; // 컴파일 오류!
    //byte b6 = 10 + b2; // 컴파일 오류!
    /* 변수와 변수, 변수와 상수의 연산 결과는 변수이다.
     * 왜? 변수의 값에 따라 결과가 달라지기 때문에 당연히 그 결과는 변수일 수 밖에 없다.
     * 
     * 변수의 값을 계산할 때 자바는 내부에 정해진 법칙에 따라 계산을 수행한다.
     * 이 법칙을 "암시적 형변환(implicit type conversion)"이라 부른다.
     * 
     */
    int i1 = 10;
    long l1 = 20;
    
    //int i2 = i1 + l1; // 연산 결과는 long이다.
    long l2 = i1 + l1; // OK
    
    float f1 = 10.0f;
    //long l3 = f1 + l1; // 연산 결과는 float이다.
    float f2 = f1 + l1; // OK!
    
    float f3 = l1 + l2; // long + long = long ---> float 저장할 수 있다. 그러나 값일 짤릴 수 있다.
    
  }
}

/* 암시적 형변환
 * => JVM은 항상 같은 타입의 데이터끼리만 연산을 수행할 수 있다.
 * => 그래서 연산을 수행하려면 항상 타입을 일치시켜야 한다.
 * => 다음 규칙에 따라 타입을 일치시킨다.
 *    주의!
 *    형변환이라고 해서 기존 변수의 타입이 변경되는 것이 아니다!
 *    형변환이라는 이름 때문에 많은 입문자들이 헷갈려 한다.
 * => byte, short, char --> int --> long --> float --> double
 * 
 * 암시적 형변환 예 
 * => JVM은 기본 데이터를 4바이트 메모리에 담아서 다루기 때문에 
 *    다음 규칙에 따라 4바이트 메모리에 저장되어 연산을 수행하게 된다.
 *    * 실제 JVM은 메서드 안의 변수 값을 계산할 때
 *      스택 메모리를 사용하는데, 그 스택 메모리의 기본 크기가 4바이트이다.
 *      만약 8바이트 값을 계산하려하면 4바이트 메모리를 2개를 사용해서 계산을 수행한다.
 * => byte + byte = (int) + (int) = (int)
 * => short + short = (int) + (int) = (int)
 * => byte + int = (int) + int = (int) 
 * 
 * 4바이트 이상되는 변수의 계산은 다음과 같다.
 * => long + int = long + (long) = (long)
 * => long + float = (float) + float = (float)
 *    => 이런 연산이 가장 위험하다. 
 *    => long 값이 float 메모리에 저장될 때 float 메모리에 담기에 크다면,
 *       그 값이 짤려서 저장된다. 실행오류가 발생하지 않기 때문에 값이 짤렸는지 알 수 없다.
 *       주의해서 연산을 수행하라!
 * => int + float = (float) + float = (float)
 *    => 이 경우도 위험하다. 7자리가 넘어가는 int 값인 경우 짤려서 저장된다.
 *       조심해서 사용하라!
 * => int + double = (double) + double = (double)
 * => long + [char * int] + short + [byte / float] + double + long
 *    => long + [(int) * int] + short + [(float) / float] + double + long
 *    => long + (int) + short + (float) + double + long
 *    => [long + (int)] + short + (float) + double + long
 *    => [long + (long)] + short + (float) + double + long
 *    => (long) + short + (float) + double + long
 *    => [(long) + short] + (float) + double + long
 *    => [(long) + (long)] + (float) + double + long
 *    => (long) + (float) + double + long
 *    => [(long) + (float)] + double + long
 *    => [(float) + (float)] + double + long
 *    => (float) + double + long
 *    => [(float) + double] + long
 *    => [(double) + double] + long
 *    => (double) + long
 *    => [(double) + long]
 *    => [(double) + (double)]
 *    => (double)
 */




