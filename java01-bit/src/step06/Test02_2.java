/* class 문법의 용도: 관련된 메서드를 묶는 용도 II
 * => 코드를 기능 별로 묶어서 정의해두면 필요할 때 마다 다시 사용하기 편해진다.
 *    코드를 기능 별로 묶은 것을 "메서드(method)"라 부른다.
 */
package step06;

public class Test02_2 {
  // 이 클래스의 메서드들이 사용할 변수를 선언한다.
  static String name;
  static int[] scores = new int[3];
  static int total;
  static float aver;
  
  // 변수의 값을 초기화시키는 기능을 수행하는 코드를 init() 블록 안에 묶어 두었다.
  public static void init(String n, int k, int e, int m) {
    name = n;
    scores[0] = k;
    scores[1] = e;
    scores[2] = m;
  }
  
  // 합계와 총점을 계산하는 기능의 코드를 compute() 블록 안에 묶어 두었다. 
  public static void compute() {
    total = scores[0] + scores[1] + scores[2];
    aver = total / 3f;
  }
  
  // 성적 정보를 출력하는 기능을 수행하는 코드를 print() 블록 안에 묶어 두었다.
  public static void print() {
    System.out.println("************************************");
    System.out.printf("%s, %d, %d, %d, %d, %f\n", 
        name, scores[0], scores[1], scores[2], total, aver);
    System.out.println("************************************");
  }
  
  public static void main(String[] args) {
    // 코드가 지저분하게 있던 것을 메서드 블록 안에 묶어 둠으로써 
    // 관리하기 좋게 간결하게 유지할 수 있다.
    init("홍길동", 100, 100, 100);
    compute();
    print();

  }

}
