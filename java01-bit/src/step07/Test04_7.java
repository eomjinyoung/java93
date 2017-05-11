/* 클래스 변수와 인스턴스 메서드 II 
 * => 클래스 이름이 아닌 this를 사용하여 클래스 변수를 찾아갈 수 있다. 
 * => 다만, 다른 개발자가 오해할 수 있다.
 *    this 다음에 변수명을 주면 인스턴스 변수라고 오해할 가능성이 높다.
 *    따라서 실무에서는 가능한 this를 통해 클래스 변수를 사용하지 말라!
 */
package step07;

public class Test04_7 {
  
  static class Calculator {
    static int result;
    
    public void plus(int value) {
      this.result += value;
      /* 인스턴스에 result라는 변수가 없으면,
       * 자동으로 클래스 변수를 찾는다.
       * 그래스 위 코드는 오류는 아니다.
       * 다만 회사에 빅 엿을 먹이고 싶을 때,
       * 이런 식으로 코딩하라!
       */
    }
    
    public void minus(int value) {
      // 인스턴스 메서드에서는 로컬 변수가 아닌 경우,
      // 변수명 앞에 this를 자동으로 붙인다.
      // 이런 상황 때문에
      // this가 붙더라도 클래스 변수를 찾을 수 있도록 하기 위함이다.
      /*Calculator.this.*/result -= value;
      
      // 만약 this가 붙은 변수는 무조건 인스턴스 변수라고 규칙이 정해진다면,
      // 우리는 클래스 변수를 사용할 때 마다 반드시 클래스 이름을 
      // 다음과 같이 명시해야 할 것이다.
      //Calculator.result -= value;
      
      // 그런데 this를 통해서도 클래스 변수를 사용할 수 있도록
      // 문법이 허락하기 때문에 
      // 인스턴스 메서드에서 같은 클래스에 있는 클래스 변수를 사용할 때 
      // 우리는 편하게 클래스 이름을 지정하지 않고 변수명만 지정할 수 있다.
      //result -= value;
    }
  }
  
  public static void main(String[] args) {
    Calculator c = new Calculator();
    c.plus(10);
    System.out.println(Calculator.result);
  }

}
