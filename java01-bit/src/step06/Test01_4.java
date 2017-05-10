/* class 문법의 용도: 사용자 정의 데이터 타입 만들기 IV
 * => 클래스를 정의한 코드는 별도의 파일로 분리하는 것이 관리에 좋다.   
 */
package step06;

public class Test01_4 {
  
  public static void main(String[] args) {
    // 별도의 파일에 정의된 클래스를 사용해 보자!
    // 같은 패키지에 소속된 클래스는 그 클래스 앞에 패키지명을 적을 필요가 없다.
    // ArrayList나 HashMap처럼 다른 패키지에 선언된 클래스를 사용할 때는 
    // 반드시 패키지명을 적어야 한다.
    // 예) java.util.Array list = new java.util.ArrayList();
    Student s1 = new Student();
    Student.init(s1, "홍길동", 100, 100, 100);
    Student.compute(s1);
    
    Student s2 = new Student();
    Student.init(s2, "임꺽정", 90, 90, 90);
    Student.compute(s2);
    
    Student s3 = new Student();
    Student.init(s3, "유관순", 80, 80, 80);
    Student.compute(s3);
    
    Student.print(s1);
    Student.print(s2);
    Student.print(s3);

  }

}
