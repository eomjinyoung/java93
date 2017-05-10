package step06;

class Student2 {
  String name;
  int[] scores = new int[3];
  int total;
  float aver;

  // => static이 붙지 않은 메서드를 "인스턴스 메서드"라 부른다.
  // => 파라미터로 인스턴스 주소를 받지 않는다면 어떻게 받는다고?
  //    => 호출할 때 메서드 앞에서 인스턴스 주소를 받는다.
  //      예) 인스턴스주소.메서드명();
  // => 메서드 앞에 놓은 인스턴스를 주소를 
  //    메서드 안에서 어떻게 사용하는가?
  //    => 인스턴스 주소가 그 메서드의 내장 변수 this에 자동 보관되기 때문에
  //       this 변수를 사용하면 된다.
  // => 즉 모든 인스턴스 메서드는 this라는 인스턴스 주소를 보관하는 변수가 내장되어 있다.
  // => static이 붙은 클래스 메서드는 this 라는 변수가 내장되어 있지 않다.
  public void init(String name, int kor, int eng, int math) {
    this.name = name;
    this.scores[0] = kor;
    this.scores[1] = eng;
    this.scores[2] = math;
  }

  public void compute() {
    this.total = this.scores[0] + this.scores[1] + this.scores[2];
    this.aver = this.total / 3f;
  }

  public void print() {
    System.out.printf("%s, %d, %d, %d, %d, %f\n", 
        this.name, this.scores[0], this.scores[1], this.scores[2], 
        this.total, this.aver);
  }
}
