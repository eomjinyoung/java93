/* 사용자 정의 데이터 타입: 1 클래스 1 파일
 * => 보통 유지보수를 쉽게 하기 위해 한 클래스 당 한 파일에 작성한다.
 * => class 문법?
 *    - 사용자 정의 데이터 타입을 만들 때 사용한다.
 *    - 그 데이터를 전문적으로 다루는 코드(=메서드=연산자)를 그 클래스에 둔다.
 *    
 */
package step02;

public class Test17 {
  
  public static void main(String[] args) {
    Student[] arr1 = new Student[3]; 
    
    arr1[0] = new Student("홍길동", 100, 100, 100);
    arr1[1] = new Student("임꺽정", 90, 90, 90);
    arr1[2] = new Student("유관순", 80, 80, 80);

    for (int i = 0; i < arr1.length; i++) {
      Student.print(arr1[i]); // 좀 더 어떤 클래스의 메서드인지 다루기가 쉬워진다.
    }
    
  }

}



