/* 리터럴 - 정수 리터럴과 2진수, 8진수, 10진수, 16진
 */
package step01;

public class Test05 {
  public static void main(String[] args) {
    System.out.println(100); // 10진수
    System.out.println(0144); // 8진수
    System.out.println(0x64); // 16진수. 소문자 x를 더 많이 사용.
    System.out.println(0X64); // 16진수
    System.out.println(0xA9); // 16진수의 숫자에서 a ~ f는 대.소문자 모두 가능.
    System.out.println(0xa9); // 16진수의 숫자에서 a ~ f는 대.소문자 모두 가능.
    System.out.println(0b0110_0100); // 2진수. 소문자 b를 더 많이 사용.
    System.out.println(0B0110_0100); // 2진수
    
  }
}
