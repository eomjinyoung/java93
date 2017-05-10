package step06;

class Student3 {
  String name;
  int[] scores = new int[3];
  int total;
  float aver;

  // 생성자(constructor) 
  // => 생성자 (메서드)의 이름은 반드시 클래스 이름과 같아야 한다.
  // => 리턴 타입을 선언하지 않는다.
  // => 인스턴스를 생성할 때 메서드를 바로 호출해야 한다.
  // => 인스턴스를 생성한 후에 나중에 따로 호출할 수 없다.
  // => 인스턴스를 생성한 후 바로 호출되기 때문에 
  //    보통 인스턴스 변수의 값을 초기화시키는 코드를 생성자에 둔다. 
  public Student3(String name, int kor, int eng, int math) {
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
