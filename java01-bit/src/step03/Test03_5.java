/* 기타 연산자 : 비트 논리 연산자 응용
 */
package step03;

public class Test03_5 {
  public static void main(String[] args) {
    /* 권한 정보를 다룰 때 비트 연산자를 사용할 수 있다.
     * => 읽기, 쓰기, 실행 권한을 한 개의 값으로 표현할 수 있다.
     */
    int a = 0b111; // a의 권한: 읽기, 쓰기, 실행 
    int b = 0b100; // b의 권한: 읽기
    int c = 0b001; // c의 권한: 실행
    
    // a, b, c 중에서 누가 쓰기 권한이 있는지 검사해보자!
    final int READ = 0b100;
    final int WRITE = 0b010;
    final int EXEC = 0b0001;
    
    System.out.println((a & WRITE) == WRITE); // 111 & 010 == 010
    System.out.println((b & WRITE) == WRITE); // 100 & 010 == 010
    System.out.println((c & WRITE) == WRITE); // 001 & 010 == 010 
    
    
    
  }
}



