/* 멀티 태스킹 : Critical Section(Critical Region)
 * => 사전 지식
 *    JVM의 메모리 영역 중 "Stack"은 각 스레드 별로 관리된다.
 *    Heap과 Method Area 영역은 모든 스레드가 공유한다. 
 * => 의미
 *    여러 스레드가 동시에 같은 코드를 실행하고,
 *    그 코드에서 같은 인스턴스 변수의 값을 바꾸려고 할 때,
 *    값이 중복 변경되는 문제가 발생한다. 
 *    이런 코드 블록을 "크리티컬 섹션(Critical Section)"이라 부른다.
 * 
 * => 스레드 안전(Thread Safe)   
 *    여러 스레드가 같은 코드를 동시에 실행하고, 
 *    그 코드가 같은 인스턴스 변수의 값을 단지 조회만하는 경우
 *    이런 경우에는 데이터가 중복되는 문제가 발생하지 않는다.
 *    이렇게 여러 스레드가 동시에 실행하더라도 안전한 코드 블록을
 *    "스레드 안전(Thread Safe) 하다"라고 표현한다. 
 *    
 * => 여러 스레드가 크리티컬 섹션을 실행할 때 문제가 발생하지 않게 만드는 방법?
 *    - 동시에 실행하지 않게 만들면 된다.
 *    - 한 번에 한 스레드만이 크리티컬 섹션의 코드를 실행하게 하면 된다.
 *    - 어떻게?
 *      Test05_2.java 코드를 보라!  
 *        
 */
package step19;

public class Test05_1 {

  static class Account {
    long balance;
    
    public Account(long balance) {
      this.balance = balance;
    }
    
    // 여러 ATM 스레드가 이 메서드를 호출한다.
    // 이 메서드 안에서는 인스턴스의 변수 값을 변경한다.
    // 문제는 여러 스레드들이 같은 인스턴스에 대해 withdraw() 메서드를 호출했을 때
    // 서로 중복하여 값을 변경할 수 있다는 것이다.
    // 이렇게 여러 스레드가 동시에 접근해서 실행했을 때 
    // 문제가 발생하는 코드 블록을 "Critical Section"이라 부른다.
    public long withdraw(long money) {
      long temp = this.balance;
      
      // 약간의 시간 지연을 발생시킨다.
      // 왜? 일부로 다른 스레드에게 CPU 사용권을 뺏기기 위함.
      double x = 3.141592;
      int delayCount = (int)(Math.random() * 10);
      for (int i = 0; i < delayCount; i++) 
        x /= 345.2345;
      //-------------------------------------------------
      
      temp -= money;
      
      if (temp >= 0) {
        this.balance = temp;
        return money;
      }
      return 0;
    }
  }
  
  static class ATM extends Thread {
    Account account;
    
    public ATM(String name, Account account) {
      super(name);
      this.account = account;
    }
    
    public void run() {
      long sum = 0;
      for (int i = 0; i < 10000; i++) {
        long money = this.account.withdraw(100);
        if (money == 0)
          break;
        sum += money;
      }
      System.out.printf("%s = %d\n", this.getName(), sum);
    }
  }
  
  public static void main(String[] args) {
    Account account = new Account(1_000_000);
    ATM t1 = new ATM("강남", account);
    ATM t2 = new ATM("강북", account);
    ATM t3 = new ATM("강원", account);
    ATM t4 = new ATM("제주도", account);
    
    t1.start();
    t2.start();
    t3.start();
    t4.start();
    
  }
}









