/* 변수 선언: 배열 변수와 초기화 */
package step02;

public class Test07 {
  public static void main(String[] args) {
    //1) 변수 선언과 동시에 배열을 준비시키는 명령을 같이 사용할 수 있다.
    byte[] arr1 = new byte[3]; // => 배열을 준비해서 그 메모리의 주소를 arr1에 저장하라!
    
    arr1[0] = 10;
    arr1[1] = 20;
    arr1[2] = 30;
    
    System.out.printf("%d, %d, %d\n", arr1[0], arr1[1], arr1[2]);
    
    //2) 배열 선언과 동시에 그 배열 항목에 값을 지정할 수 있다.
    byte[] arr2 = new byte[]{40, 50, 60};
    System.out.printf("%d, %d, %d\n", arr2[0], arr2[1], arr2[2]);
   
    byte[] arr3;
    arr3 = new byte[]{100, 101, 102}; // OK
    System.out.printf("%d, %d, %d\n", arr3[0], arr3[1], arr3[2]);

    //3) 배열 선언과 동시에 그 배열 항목에 값을 지정할 때 new 명령을 생략할 수 있다.
    byte[] arr4 = {70, 80, 90};
    System.out.printf("%d, %d, %d\n", arr4[0], arr4[1], arr4[2]);
    
    //그러나, 변수를 선언한 후에 값을 초기화시키는 명령을 사용할 수 없다.
    byte[] arr5;
    //arr5 = {70, 80, 90}; // 컴파일 오류!
  }

}

