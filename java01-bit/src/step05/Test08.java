/* 메서드 : 사용자 정의 타입과 힙(heap) 메모리
 * => 수요일에 강의해야 함!
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








