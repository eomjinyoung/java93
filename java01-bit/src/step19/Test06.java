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
 */
package step19;

public class Test06 {

  static class Worker {
    public void play() {
      System.out.println("오호라~~ 놀자!");
    }
  }
  
  static class MyThread extends Thread {
    Worker worker;
    
    public MyThread(Worker worker) {
      this.worker = worker;
    }
    
    public void run() {
      while (true) {
        worker.play();
        try {
          Thread.sleep(1000);
        } catch (Exception e) {}
      }
    }
  }
  
  public static void main(String[] args) {
    Worker worker = new Worker();
    MyThread t1 = new MyThread(worker);
    
    t1.start();
    
    // "main" 스레드는 t1 스레드를 실행시켜 놓고, main() 메서드 호출을 끝낸다.
    // 그런데 JVM이 종료되지 않고 계속 실행한다.
    // 이유는?
    // "main" 스레드는 자식스레드가 종료될 때까지 JVM을 종료하지 않는다.
    System.out.println("main() 끝!");
  }
}









