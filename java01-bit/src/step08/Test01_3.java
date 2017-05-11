/* 프로그램 아규먼트 연습 II
 * => 가위, 바위, 보 게임 만들기 
 * => 예)
 *   > java -cp bin step08.Test01_3 가위
 *   당신이 이겼습니다. ^.^
 *   메롱~ 당신이 졌습니다. T.T
 *   비겼습니다. -.-
 * => Math.random() 의 리턴 값은 
 *    0 <= x < 1
 *    x는 부동소수점이다.
 * => 세가지 임의의 상태 값을 얻는 방법
 *    Math.random() * 3 = 0 <= x < 3
 *    x는 부동소수점이다.
 * => 소수점 이하를 날리는 방법 : 명시적 형변환을 사용하라!
 *    float f = 3.14f;
 *    int r = (int)f;
 */
package step08;

public class Test01_3 {

  public static void main(String[] args) {
    
    if (args.length < 1) {
      System.out.println("[사용법]");
      System.out.println(">java -cp bin step08.Test01_3 1");
      System.out.println("가능한 입력: (1)가위, (2)바위, (3)보");
      return; // 현재 위치에서 메서드의 실행을 멈추고 호출한 쪽으로 돌아가라!
    }
    
    int input = Integer.parseInt(args[0]);
    int robot = (int)(Math.random() * 3) + 1;
    boolean victory = false;
    
    if (input == robot) {
      System.out.println("비겼습니다. -.-");
      return;
    } else if ((input == 1 && robot == 3) ||
               (input == 2 && robot == 1) ||
               (input == 3 && robot == 2)) {
      victory = true;
    } 
    
    printResult(input, robot, victory);
  }
  
  public static void printResult(int input, int robot, boolean victory) {
    System.out.printf("(나) %s <---> %s (로봇)\n", getLabel(input), getLabel(robot));
    if (victory) {
      System.out.println("이겼습니다. ^.^");
    } else {
      System.out.println("졌습니다. T.T");
    }
  }
  
  public static String getLabel(int value) {
    switch (value) {
    case 1: return "가위";
    case 2: return "바위";
    case 3: return "보";
    default: return "?";
    }
  }
  
}
