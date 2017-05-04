/* 변수 선언: 2차원 배열 변수와 레퍼런스 */
package step02;

public class Test09 {
  public static void main(String[] args) {
    byte[][] arr1 = new byte[3][2];
    
    arr1[0][0] = 10;
    arr1[0][1] = 20;
    arr1[1][0] = 11;
    arr1[1][1] = 21;
    arr1[2][0] = 12;
    arr1[2][1] = 22;
    
    for (int i = 0; i < 3; i++) {
      System.out.printf("%d, %d\n", arr1[i][0], arr1[i][1]);
    }
    System.out.println("------------------------");
    
    byte[] arr2 = arr1[0];
    System.out.printf("%d, %d\n", arr2[0], arr2[1]);

    arr2 = arr1[1];
    System.out.printf("%d, %d\n", arr2[0], arr2[1]);

    arr2 = arr1[2];
    System.out.printf("%d, %d\n", arr2[0], arr2[1]);
    
    arr1[1] = new byte[]{100, 101, 102};
    System.out.printf("%d, %d, %d\n", arr1[1][0], arr1[1][1], arr1[1][2]);
    
    //System.out.printf("%d, %d, %d\n", arr1[0][0], arr1[0][1], arr1[0][2]);
  }

}

