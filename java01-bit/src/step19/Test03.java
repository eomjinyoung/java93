/* 멀티 태스킹 : 스레드 만들고 실행하기 II
 * => 스레드와 프로세스들은 CPU 사용권을 두고 쟁탈전을 벌인다.
 *    OS는 이런 쟁탈전을 나름의 규칙에 따라 관리한다.
 *    "CPU Scheduling" = "Job Scheduling" = "Process Scheduling"
 *    이렇게 OS가 CPU 사용권을 관리하는 경우 "선점형 멀티 태스킹 운영체제"라 부른다.
 *    MS Windows의 경우 Windows95 버전부터 선점형 멀티 태스킹 운영체제가 되었다.
 *    
 * => 스케줄링 기법
 *    1) 라운드 로빈 방식(round-robin)
 *       - 각 프로세스에게 일정 시간을 분배하여 CPU를 사용하게 하는 방식이다.
 *       - MS Windows 운영체제에서 사용하는 방식
 *       
 *    2) 우선 순위 방식(priority + aging)
 *       - 우선 순위가 높은 프로세스에게 더 많은 시간을 분배하는 방식이다.
 *       - 이 방식의 문제는 우선 순위가 낮은 프로세스의 경우
 *         우선 순위가 높은 프로세스에게 계속 밀리는 문제가 있다.
 *       - 이를 극복하기 위해서 Aging 기법을 이용하여 
 *         실행이 한 번 밀릴 때마다 우선 순위를 높여 줌으로써
 *         결국에서 실행될 수 있게 만든다. 
 *       - 리눅스, 유닉스 운영체제에서 사용하는 방식
 * 
 * => 컨텍스트 스위칭(Context Switching)
 *    - 프로세스를 실행할 때 CPU에 실행정보를 가져온 후 그 정보를 바탕으로 실행한다.
 *    - 이전에 실행한 프로세스의 정보는 PCB 영역에 저장한다.
 *    - 이렇게 프로세스를 실행할 때 마다 이전 프로세스의 정보를 가져오고,
 *      실행했던 프로세스의 정보를 저장하는 것을 "컨텍스트 스위칭"이라 부른다.
 * => PCB(Process Control Block)
 *    - 프로세스를 실행하면 실행 정보를 관리하기 위해 각 프로세스 별로 PCB 영역이 준비된다.
 *    - PCB 영역에는 실행 상태, 실행할 때 참고하는 레지스트리의 값 등이 보관된다.
 *    
 *    
 */
package step19;

public class Test03 {

  static class MyThread extends Thread {
    public MyThread(String name) {
      this.setName(name);
    }
    
    public void run() {
      for (int i = 0; i < 1000; i++) {
        System.out.printf("[%s] %d\n", this.getName(), i);
      }
    }
  }
  
  public static void main(String[] args) {
    MyThread t1 = new MyThread("t1");
    MyThread t2 = new MyThread("t2");
    MyThread t3 = new MyThread("t3");
    
    t1.start(); // t1 스레드를 독립적으로 실행시킨 후 즉시 리턴한다.
    t2.start(); // t2 스레드를 독립적으로 실행시킨 후 즉시 리턴한다.
    t3.start(); // t3 스레드를 독립적으로 실행시킨 후 즉시 리턴한다.
    
    for (int i = 0; i < 1000; i++) {
      System.out.printf("[main] %d\n", i);
    }
  }
}









