/* 멀티 태스킹 : Critical Section(Critical Region) II
 * => 크리티컬 섹션을 실행할 때, 
 *    한 번에 한 스레드 만이 진입하게 만드는 방법
 *    "synchronized" 로 영역을 표시하라!  
 *    
 * => 용어
 *    "뮤텍스(Mutex; mutual exclusion;상호 배제)"
 *      => 크리티컬 섹션에 한 번에 한 스레드만 진입하게 만드는 것.
 *      => Semaphore(1)
 *      => 일상 생활에서 상호 배제를 하는 예: 선풍기의 속도 조절, 라디오 채널 변경 등
 *    "세마포어(Semaphore)" 
 *      => 크리티컬 섹션에 지정된 개수만큼 스레드가 진입하게 만드는 것.
 *      => Semaphore(n)
 *      => 자바에서는 이 방식을 지원하지 않는다. 오직 뮤텍스만 지원한다.    
 *          
 */
package step19;

public class Test05_2 {

  static class Account {
    long balance;

    public Account(long balance) {
      this.balance = balance;
    }

    // Critical Section에 여러 스레드가 동시에 진입하지 못하게 막는 방법
    // => 그 메서드나 블록 앞에 synchronized를 붙인다.
    synchronized public long withdraw(long money) {
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









