/* 기타 연산자 : 비트 이동 연산자(>>, >>>, <<)
 */
package step03;

public class Test03_6 {
  public static void main(String[] args) {
    int a = 0b0000_1011; 
    
    // >> 연산자: 빈자리를 부호비트와 같은 값으로 채운다.
    System.out.println(a); 
    System.out.println(a >> 1); // => 0000_0101|1    (= a / 2^1)
    System.out.println(a >> 2); // => 0000_0010|11   (= a / 2^2)
    System.out.println(a >> 3); // => 0000_0001|011  (= a / 2^3)
    
    // >>> 연산자: 빈자리를 무조건 0으로 채운다.
    System.out.println(-10 >> 2); // 음수
    System.out.println(-10 >>> 2); // 양수
    
    // << 연산자: 오른쪽 빈자리를 무조건 0으로 채운다.
    // <<< 연산자는 없다!
    System.out.println(a << 1); // => 0001_0110  (= a * 2^1)
    System.out.println(a << 2); // => 0010_1100  (= a * 2^2)
    System.out.println(a << 3); // => 0101_1000  (= a * 2^3)
    
  }
}



