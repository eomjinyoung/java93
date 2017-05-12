/* 유틸리티 클래스 : Object - equals()
 * => 원본과 재정의       
 */
package step08;

public class Test03_3 {
  
  static class Student1 {
    String name;
    int age;
    
    // equals()를 재정의 하지 않았기 때문에, Object의 equals()를 사용할 것이다.
  }
  
  static class Student2 {
    String name;
    int age;
    
    // Object의 equals()를 사용하는 대신 이 서브 클래스에서 재정의한 equals()를 사용할 것이다.
    public boolean equals(Object obj) {
      if (!(obj instanceof Student2)) return false;
      
      // 파라미터로 넘어온 값이 Student2 인스턴스의 주소가 맞다면,
      // 검사하기 쉽게 일단 Student2 타입으로 형변환 한다.
      Student2 other = (Student2)obj;
      
      if (!this.name.equals(other.name)) return false;
      if (this.age != other.age) return false;
      
      return true;
    }
  }
  
  public static void main(String[] args) {
    Student1 s1 = new Student1();
    s1.name = "홍길동";
    s1.age = 20;
    
    Student1 s2 = new Student1();
    s2.name = "홍길동";
    s2.age = 20;
    
    System.out.println(s1 == s2); // 당연히 주소를 다르다. 
    System.out.println(s1.equals(s2)); // Object의 equals()는 주소를 비교한다. 
                                       // 결국 ==의 연산 결과와 같다. 
    
    
    Student2 s3 = new Student2();
    s3.name = "홍길동";
    s3.age = 20;
    
    Student2 s4 = new Student2();
    s4.name = "홍길동";
    s4.age = 20;
    
    System.out.println(s3 == s4); // 당연히 주소를 다르다. 
    System.out.println(s3.equals(s4)); // Student2에서 재정의한  equals()는 
                                       // 인스턴스의 주소가 아니라 값을 비교한다.
    
  }

}







