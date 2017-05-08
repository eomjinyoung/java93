/* 문장: 반복문 while - continue */
package step04;

public class Test03_3 {
  public static void main(String[] args) {
    int i = 0;
    int r = 0;
    
    while (i < 10) {
      i++;
      if (i == 6)
        continue; // 다음에 나오는 문장들을 실행하지 않고 바로 비교문으로 보낸다.
      r += i;
    }
    
    System.out.printf("i = %d, r = %d\n", i, r);
    
    
  }
}
