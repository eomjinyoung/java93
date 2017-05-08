/* 문장: 반복문 while - break */
package step04;

public class Test03_2 {
  public static void main(String[] args) {
    int i = 0;
    int r = 0;
    
    while (i < 10) {
      if (i == 5)
        break; // 가장 가까운 반복문을 나간다.
      r += ++i;
    }
    
    System.out.printf("i = %d, r = %d\n", i, r);
    
    
  }
}
