/* 증가/감소 연산자 - 전위 연산자와 후위 연산자의 차이점 III
 */
package step03;

public class Test02_4 {

  public static void main(String[] args) {
    int i = 3;
    int r = ++i + ++i * ++i; // r = 4 + 5 * 6 = 4 + 30 = 34
    System.out.printf("i = %d, r = %d\n", i, r);
    
    i = 3;
    r = i++ + i++ * i++; // r = 3 + 4 * 5 = 3 + 20 = 23 
    System.out.printf("i = %d, r = %d\n", i, r);
    
    i = 3;
    r = ++i + ++i * i++; // r = 4 + 5 * 5 = 4 + 25 = 29
    System.out.printf("i = %d, r = %d\n", i, r);
  }
}



