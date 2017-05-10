/* 메서드 : 힙(heap) 메모리
 * => 어떤 메서드인지 상관없이 new 명령으로 만드는 메모리를 모두 힙 영역에 보관된다. 
 * => 힙 영역에 보관된 메모리는 메서드 호출이 끝나더라도 유지된다.
 * => 주소를 잃어 버려 가비지가 되고, 가비지 컬렉터에 의해 지워질 때까지 유지된다.
 * => 또는 JVM이 종료되기 전까지 유지된다. 
 */
package step05;

public class Test08 {
  public static int[] m1(int a) {
    int[] arr = m2(a + 1);
    arr[2] = a;
    return arr;
  }
  
  public static int[] m2(int a) {
    int[] arr = m3(a + 1);
    arr[1] = a;
    return arr;
  }
  
  public static int[] m3(int a) {
    int[] arr = new int[3];
    arr[0] = a;
    return arr;
  }
  
  public static void main(String[] args) {
    int[] arr = m1(100);
    for (int i = 0; i < arr.length; i++) {
      System.out.printf("%d=%d\n", i, arr[i]);
    }
  }
}








