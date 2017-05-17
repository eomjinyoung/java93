package step15;

public class Student {
  public static final int HIGH_SCHOOL = 1;
  public static final int BACHELOR = 2;
  public static final int MASTER = 3;
  public static final int DOCTOR = 4;
  
  private String name;
  private int age;
  private int schoolLevel;
  
  public String toString() {
    return "Student [name=" + name + ", age=" + age + ", schoolLevel=" + schoolLevel + "]";
  }
  
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
  public int getSchoolLevel() {
    return schoolLevel;
  }
  public void setSchoolLevel(int schoolLevel) {
    // 최종 학력의 값이 무효한지 검사한다.
    if (schoolLevel < 1 || schoolLevel > 4) {
      throw new RuntimeException("유효한 값이 아닙니다.");
    }
    this.schoolLevel = schoolLevel;
  }
}
