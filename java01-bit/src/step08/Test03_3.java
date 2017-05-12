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
    @Override
    public boolean equals(Object obj) {
      
    }
  }
  
  public static void main(String[] args) {
    Student1 s1 = new Student1();
    s1.name = "홍길동";
    s1.age = 20;
    
    Student2 s2 = new Student2();
    s2.name = "임꺽정";
    s2.age = 30;
    
    System.out.println(s1.toString()); // 오리저널 toString() 호출
    System.out.println("-------------------------");
    System.out.println(s2.toString()); // 재정의한 toString() 호출
  }

}







