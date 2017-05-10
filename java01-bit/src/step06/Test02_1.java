/* class 문법의 용도: 관련된 메서드를 묶는 용도 II
 * => 학생 성적 정보를 다룰 변수를 선언하고,
 *    그 변수에 값을 넣는다.
 */
package step06;

public class Test02_1 {
  // 이 클래스의 메서드들이 사용할 변수를 선언한다.
  static String name;
  static int[] scores = new int[3];
  static int total;
  static float aver;
  
  public static void main(String[] args) {
    name = "홍길동";
    scores[0] = 100;
    scores[1] = 90;
    scores[2] = 80;
    total = scores[0] + scores[1] + scores[2];
    aver = total / 3f;
    
    System.out.printf("%s, %d, %d, %d, %d, %f\n", 
        name, scores[0], scores[1], scores[2], total, aver);

  }

}
