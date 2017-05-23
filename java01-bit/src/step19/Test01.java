/* 멀티 태스킹 : 개요 및 JVM 기본 스레드와 스레드 그룹들
 * => CPU 한 개로 여러 프로그램을 동시에(?), 병행으로 실행하는 방법
 * => 멀티 태스킹을 수행하는 방법
 *    1) 멀티 프로세싱
 *       - 프로세스(실행 중인 프로그램)를 복제하여 실행하는 방법
 *       - 원본 프로세스의 모든 메모리를 그대로 복제(fork() 호출)한다.
 *         => 메모리 낭비가 심하다.
 *         => 구현하기가 쉽다.
 *         => 프로세스끼리 독립적이기 때문에 원본 프로세스의 영향을 받지 않는다.
 *          
 *    2) 멀티 스레딩
 *       - 메인 프로세스의 작업 중 "일부 작업만 독립해서 실행(스레드)"시키는 방법
 *       - 메인 프로세스의 힙 메모리는 공유하고 스택 메모리만 별도로 유지한다.
 *         => 메모리 낭비를 줄인다.
 *         => 프로세스 복제 방식 보다는 구현하기가 조금 복잡하다.
 *         => 스레드들은 원본 프로세스에 종속되기 때문에,
 *            원본 프로세스가 종료되면 스레드들도 자동으로 종료한다.
 *            
 * => 현재 대부분의 멀티 태스킹은 "멀티 스레드" 방식으로 처리한다.
 * 
 * => 스레드와 스레드 그룹
 *    - 스레드: 프로세스의 작업 중에서 독립적으로(병행하여) 실행하는 작업.
 *    - 스레드 그룹: 스레드를 묶어 놓은 것.
 *    
 * => JVM이 기본으로 생성하는 스레드와 스레드 그룹
 *    => OS와 Java 버전에 따라 다를 수 있다
 *    => 스레드 구조
 *    TG("system")
 *      ==> TG("main")
 *          > T("main") : main() 메서드 실행
 *      ==> T("Reference Handler")  : 인스턴스의 주소를 관리
 *      ==> T("Finalizer")          : 인스턴스의 메모리 해제를 관리
 *      ==> T("Signal Dispatcher")  
 */
package step19;

public class Test01 {
  public static void main(String[] args) {
    // 현재 main() 메서드를 실행하는 스레드를 알아내기
    Thread t = Thread.currentThread();
    System.out.println(t.getName());
    
    // "main" 스레드가 소속되어 있는 스레드 그룹
    ThreadGroup g = t.getThreadGroup();
    System.out.println(g.getName());
    
    // "main" 그룹의 상위 스레드 그룹
    ThreadGroup g2 = g.getParent();
    System.out.println(g2.getName());
    
    // "system" 그룹의 상위 스레드 그룹
    ThreadGroup g3 = g2.getParent(); // = null
    //System.out.println(g3.getName());
    
    System.out.println("-------------------------");

    // "system" 그룹의 하위 스레드 그룹
    printThreadGroup(g2, "");
    
  }
  
  static void printThreadGroup(ThreadGroup tg, String prefix) {
    // 파라미터로 넘어온 스레드 그룹의 이름을 먼저 출력한다.
    System.out.printf("%s['%s']--\n", prefix, tg.getName());
    
    // 하위 스레드 그룹의 정보를 얻어서 출력한다.
    ThreadGroup[] groupArray = new ThreadGroup[10];
    int count = tg.enumerate(groupArray, false);
    for (int i = 0; i < count; i++) {
      printThreadGroup(groupArray[i], prefix + "  ");
    }
    
    Thread[] threadArray = new Thread[10];
    count = tg.enumerate(threadArray, false);
    for (int i = 0; i < count; i++) {
      System.out.printf("%s(%s)\n", prefix + "  ", threadArray[i].getName());
    }
  }
}









