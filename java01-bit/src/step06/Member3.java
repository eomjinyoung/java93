package step06;

/* 메서드에서 static을 떼어내서 인스턴스를 다루는 메서드로 만든다.
 */
class Member3 {
  String name;
  int[] scores = new int[3];
  int total;
  float aver;
 
  // 메서드 앞에 static을 떼어내는 순간, 
  // 이 메서드는 인스턴스 주소로만 호출할 수 있다.
  // 인스턴스 주소 없이는 호출할 수 없다.
  // 그리고 그 인스턴스 주소도 메서드를 호출할 때 다음과 같이 메서드 앞에 주어야 한다.
  // => 인스턴스주소.메서드명();
  // 메서드를 호출할 때 넘겨준 인스턴스 주소는
  // 내부에 미리 장착되어 있는 this라면 변수에 보관된다.
  // 물론 static 붙은 메서드에는 this라는 변수가 내장되어 있지 않다.
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
    System.out.println("************************************");
    System.out.printf("%s, %d, %d, %d, %d, %f\n", 
        this.name, this.scores[0], this.scores[1], this.scores[2], this.total, this.aver);
    System.out.println("************************************");
  }
}
