/* 메서드 : 반복 실행해야 하는 코드를 묶어 둔 블록 */
package step05;

public class Test01 {

  public static void displayDan(int dan) {
    for (int j = 1; j <= 9; j++) {
      System.out.printf("%d * %d = %d\n", dan, j, (dan * j));
    }
  }
  
  public static void displayHeader(int dan) {
    System.out.printf("[%d 단] -----------------------\n", dan);
  }
  
  public static void main(String[] args) {
    for (int dan = 2; dan <= 9; dan++) {
      displayHeader(dan);
      displayDan(dan);
    }
  }

}
