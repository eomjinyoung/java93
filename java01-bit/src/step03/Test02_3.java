/* 증가/감소 연산자 - 전위 연산자와 후위 연산자의 차이점 II
 */
package step03;

public class Test02_3 {

  public static void main(String[] args) {
    //1) 전위(pre-fix) 연산자
    //=> 변수의 값을 먼저 증가시킨 다음에 그 자리에 현재 변수의 값을 놓는다.
    int i = 10;
    i = ++i;
    /* 실행순서
     * => i = i + 1 : 11
     * => i = 11
     * => i <== 11
     */
    System.out.printf("i = %d\n", i);
    
    //2) 후위(post-fix) 연산자
    //=> 현재 자리에 변수의 값을 먼저 놓고, 변수의 값을 증가시킨다.
    i = 10;
    
    i = i++;
    /* 실행순서
     * => i = 10 
     * => i = i + 1 : 11 
     * => i <== 10              
     */
     
    System.out.printf("i = %d\n", i);
  }
}



