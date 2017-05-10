/* class 문법의 용도: 사용자 정의 데이터 타입 만들기 VI
 * => 인스턴스 메서드 중에서 인스턴스를 생성할 때 자동으로 호출되는 메서드가 있는데
 *    그 메서드를 "생성자(constructor)"라고 부른다.
 * => 자바스크립트와 다르게 
 *    생성자 메서드를 정의하는 문법이 따로 있다.
 * => 문법
 *    클래스명(파라미터 선언, ...) { ... }   
 */
package step06;

public class Test01_6 {
  
  public static void main(String[] args) {
    // 생성자는 인스턴스를 생성할 때 바로 호출한다.
    // => 생성자가 원하는 값을 클래스 이름 옆의 괄호() 안에 둔다.
    Student3 s1 = new Student3("홍길동", 100, 100, 100);
    s1.compute();
    
    // 생성자 호출은 필수이다. 
    //Student3 s2 = new Student3; // 컴파일 오류!
    
    // 그 생성자 원하는 값을 반드시 파라미터로 넘겨야 한다.
    //Student3 s2 = new Student3(); // 컴파일 오류!

    // 반드시 생성자에 정의된 순서대로 넣어야 하고 한 개의 값이라도 빠뜨려서는 안된다. 
    //Student3 s2 = new Student3("임꺽정", 90, 90); // 컴파일 오류!
    
    Student3 s2 = new Student3("임꺽정", 90, 90, 90);
    s2.compute();
    
    Student3 s3 = new Student3("유관순", 80, 80, 80);
    s3.compute();
    
    s1.print();
    s2.print();
    s3.print();

  }

}
