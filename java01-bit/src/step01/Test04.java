/* 리터럴 - 정수 리터럴과 자릿수 표시
 */
package step01;

public class Test04 {
  public static void main(String[] args) {
    System.out.println(21_4748_3647); // 4바이트 양의 정수 최대 값
    System.out.println(-21_4748_3648); // 4바이트 음의 정수 최대 값   
    System.out.println(922_3372_0368_5477_5807L); //8바이트 양의 정수 최대 값
    System.out.println(-9_223_372_036_854_775_808L); //8바이트 음의 정수 최대 값

  }
}
