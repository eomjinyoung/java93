/* class 문법의 용도: 관련된 메서드를 묶는 용도 III
 * => 서로 관련된 메서드를 관리하기 좋게 별도의 블록으로 묶는다.
 *    메서드를 기능에 따라 분류(classification)하여 별도의 블록으로 
 *    분리시킨 것을 "클래스(class)"라 부른다.
 * => 메서드를 분리할 때, 그 메서드가 사용하는 변수도 함께 묶어서 분리한다.
 */
package step06;

public class Test02_3 {
  // 성적 처리 관련 메서드와 변수를 별도의 블록으로 묶어 두었다.
  static class Member {
    //init(), compute(), print() 메서드에서 사용할 변수 선언
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
  }
  
  public static void main(String[] args) {
    // 성적을 처리하는 메서드를 별도의 블록(클래스) 안에 묶어 두었고,
    // 그 블록의 메서드를 호출한다.
    // 별도의 블록에 묶은 메서드를 호출할 때는 
    // 반드시 그 블록의 이름을 메서드 앞에 지정해야 한다.
    // => 이때 클래스 문법의 용도는 "메서드를 묶어 두는 블록"으로서의 역할을 한다.
    Member.init("홍길동", 100, 100, 100);
    Member.compute();
    Member.print();

  }

}
