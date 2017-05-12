/* 유틸리티 클래스 : 랩퍼(wrapper) 클래스 
 * => 자바의 원시 데이터 타입(primitive type)을 다루는 클래스를 말한다.
 * => byte      ---> java.lang.Byte
 *    short     ---> java.lang.Short
 *    int       ---> java.lang.Integer
 *    long      ---> java.lang.Long
 *    float     ---> java.lang.Float
 *    double    ---> java.lang.Double
 *    boolean   ---> java.lang.Boolean
 *    char      ---> java.lang.Character
 * => 왜 이런 클래스를 만들었는가?
 *    - 프로그래밍을 하다보면 원시 데이터 타입의 값을 객체처럼 다뤄야 할 경우가 있다.
 *      예) Object obj = new Integer(20);
 *    - 또 산술 연산자나 관계 연산자, 비트 논리 연산자, 논리 연산자, 비트 이동 연산자,
 *      조건 연산자 외에 추가적인 기능을 클래스에 추가해 두었다.
 *      예) Integer.parseInt(문자열)  
 */
package step08;

public class Test04_1 {
  
  public static void main(String[] args) {
    int i = 10;
    
    Integer obj = new Integer(10);
    
    // 인스턴스에서 int 값을 뽑아내는 기능도 있다.
    int x = obj.intValue();
    
    // 인스턴스에서 정수 값을 문자열로 뽑아내는 기능도 있다.
    String str = obj.toString();
    
    // int 값을 다양한 타입의 값으로 뽑아내는 기능도 있다.
    byte b = obj.byteValue();
    short s = obj.shortValue();
    long l = obj.longValue();
    float f = obj.floatValue();
    double d = obj.doubleValue();
    
    // 두 수의 크기를 비교하는 기능도 있다.
    System.out.println(obj.compareTo(new Integer(5))); // 아규먼트의 값 보다 작으면 음수 
    System.out.println(obj.compareTo(new Integer(10))); // 아규먼트의 값과 같으면 0
    System.out.println(obj.compareTo(new Integer(20))); // 아규먼트의 값 보다 크면 양수
  }

}







