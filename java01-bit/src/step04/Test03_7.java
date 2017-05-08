/* 문장: 반복문 do ~ while */
package step04;

public class Test03_7 {
  public static void main(String[] args) {
    int i = 2;
    
    while (i < 2) {
      System.out.println(i);
      i++;
    }
    System.out.println("------------------------");
    
    i = 2;
    do {
      System.out.println(i);
    } while (i < 2);
    
    
  }
}
