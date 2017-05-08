
/* 문장: 조건문 switch - break 사용*/
package step04;

public class Test02_2 {
  public static void main(String[] args) {
    int a = 10;
    int b = 20;
    char c = '*';
    
    // case 문장을 실행한 후 break 명령문이 없으면 계속 다음 문장을 실행한다.
    switch (c) {
    case '+':
      System.out.println(a + b);
      break;
    case '-':
      System.out.println(a - b);
      break;
    case '*':
      System.out.println(a * b);
      break;
    case '/':
      System.out.println(a / b);
      break;
    case '%':
      System.out.println(a % b);
      break;
    default:
      System.out.println("해당 연산자를 지원하지 않습니다.");
    }
    
    
  }
}
