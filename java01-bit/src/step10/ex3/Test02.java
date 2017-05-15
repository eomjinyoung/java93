/* 다형성 - 오버로딩(overloading) II
 * => 같은 기능을 수행하는 메서드에 대해 같은 이름을 부여함으로써
 *    프로그래밍의 일관성을 확보하는 문법!
 */
package step10.ex3;

public class Test02 {

  public static void main(String[] args) {
    Calculator c1 = new Calculator();
    /*
    c1.plus(20);
    c1.plus(30);
    c1.plus(40);
    c1.plus(50);
    */
    int[] values = {20, 30, 40, 50};
    c1.plus(values);
    
    System.out.println(c1.result);

  }

}
