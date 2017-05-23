/* 멀티 태스킹 : 스레드 만들고 실행하기
 * => 방법
 *    1) Thread를 상속 받아서 만들기 : 총 + 총알
 *       만들기:   class MyThread extends Thread {}
 *       실행하기: new MyThread().start()
 *    
 *    2) Runnable 규칙에 따라 만들기 : 총알 따로 , 총 따로 
 *       만들기:  class MyJob implements Runnable {}
 *       실행하기: new Thread(new MyJob()).start()
 */
package step19;

public class Test02 {
  static class MyThread extends Thread {
    // Thread를 상속 받아서 run() 메서드를 오버라이딩 한다.
    // 그리고 run() 메서드 안에 "main" 스레드와 병행하여(동시에) 실행할 코드를 둔다. 
    public void run() {
      System.out.println("MyThread....");
    }
  }
  
  static class MyJob implements Runnable {
    // Runnable 규칙에 따라 클래스를 작성한 후, run() 메서드를 만든다.
    // 그리고 run() 메서드 안에 "main" 스레드와 병행하여(동시에) 실행할 코드를 둔다. 
    public void run() {
      System.out.println("MyJob....");
    }
  }
  
  public static void main(String[] args) {
    //1) Thread를 상속 받아 만든 스레드를 실행하기
    //   MyThread = Thread 기능 + 독립적으로 분리해서 실행할 작업
    MyThread t = new MyThread();

    // start()를 호출하면 run() 메서드를 내부에서 자동으로 호출하여 독립적으로 실행한다.
    t.start();
    
    //2) Runnable 규칙에 따라 만든 클래스를 스레드로 실행하기
    //   MyJob = 독립적으로 분리해서 실행할 작업
    //   MyJob 클래스는 스레드 기능이 없다. 그래서 Thread 클래스의 도움을 받아서 실행한다.
    MyJob job = new MyJob();
    Thread t2 = new Thread(job);
    
    // start() 호출하면 내부적으로 생성자에 넘겨준 MyJob 객체의 run() 메서드를 자동으로 실행한다.
    t2.start(); 
  }
}









