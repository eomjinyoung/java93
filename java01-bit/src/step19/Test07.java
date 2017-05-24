/* 멀티 태스킹 : 스레드의 라이프 사이클
 * => 생명 주기 
 *               start()                sleep(), wait()
 * new Thread() ----------> Runnable 상태 ----------> Not Runnable 상태
 *                              |         <----------
 *                              |       timeout, notify()
 *                              |
 *                              | 실행 완료
 *                              V
 *                            Dead
 * => Runnable 상태
 *    - CPU 쟁탈전에 놓인 상태
 *    - CPU를 받을 수 있는 상태
 *    - Runnable 상태에 있는 스레드 중 CPU를 사용하여 실행한다.
 * => Not Runnable 상태
 *    - CPU 쟁탈전에서 제외된 상태
 *    - CPU를 받을 수 없는 상태
 * => 실행이 완료되면 Dead 상태가 되어 다시는 실행할 수 없다.
 *    반복 실행 할 수 없다.
 *   
 *    
 * => wait()  
 *    - 특정 객체를 사용하는 스레드에 대해 동작을 중지시킬 때 사용한다.
 * => notify(), notifyAll() 
 *    - 특정 객체를 사용하다가 잠시 멈추고 있는 스레드를 다시 가동할 때 사용한다.
 */
package step19;

public class Test07 {
  static class Food {
    synchronized public void eat() throws Exception {
      System.out.println("먹지 말고 기다려... ");
      this.wait();
      System.out.println("맛있게 멋는다.");
    }
    
    synchronized public void allow() throws Exception {
      this.notify(); // Not Runnable 상태에서 기다리고 있는(wait()) 모든 스레드를 
                     // Runnable 상태로 만든다.
    }
  }
  
  static class Dog extends Thread {
    Food food;
    public Dog(Food food) {
      this.food = food;
    }
    public void run() {
      try {
        food.eat();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
  
  static class Counter extends Thread {
    Food food;
    int count = 10;
    
    public Counter(Food food) {
      this.food = food;
    }
    
    public void run() {
      while (true) {
        count--;
        System.out.printf("먹기 %d초 전...\n", count);
        
        if (count == 0) {
          try {food.allow();} catch (Exception e) {e.printStackTrace();}
          return; // run() 메서드를 나가면 이 스레드를 종료한다.
        }
        
        try {Thread.sleep(1000);} catch (Exception e) {}
      }
    }
  }
  
  public static void main(String[] args) {
    Food food = new Food();
    Dog dog = new Dog(food);
    dog.start();
    
    Counter counter = new Counter(food);
    counter.start();
    
    
  }
}









