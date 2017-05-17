/* 캡슐화(encapsulation): 필드와 프로퍼티 II
 */
package step11;

public class Test10 { 

  static enum SchoolLevel {
    HIGH_SCHOOL, BACHELOR, MASTER, DOCTOR
  }
  
  static class Student {
    // 필드 선언 
    private String name;
    private int age;
    private SchoolLevel level;
    
    // 프로퍼티 선언
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
    public int getAge() {
      return age;
    }
    public void setAge(int age) {
      this.age = age;
    }
    public SchoolLevel getLevel() {
      return level;
    }
    public void setLevel(SchoolLevel level) {
      this.level = level;
    }
  }
  
  public static void main(String[] args) {
    Student s = new Student();
    s.setName("홍길동");
    s.setAge(20);
    s.setLevel(SchoolLevel.BACHELOR);
  }

}
