package step06;

// 클래스 안에 정의된 클래스를 이렇게 별도의 파일로 분리시킬 때는
// static 을 붙이면 안된다.
class Student {
  String name;
  int[] scores = new int[3];
  int total;
  float aver;

  public static void init(Student s, String name, int kor, int eng, int math) {
    s.name = name;
    s.scores[0] = kor;
    s.scores[1] = eng;
    s.scores[2] = math;
  }

  public static void compute(Student s) {
    s.total = s.scores[0] + s.scores[1] + s.scores[2];
    s.aver = s.total / 3f;
  }

  public static void print(Student s) {
    System.out.printf("%s, %d, %d, %d, %d, %f\n", 
        s.name, s.scores[0], s.scores[1], s.scores[2], s.total, s.aver);
  }
}
