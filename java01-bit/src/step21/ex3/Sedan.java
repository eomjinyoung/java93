package step21.ex3;

public class Sedan extends Loader {
  boolean auto;
  
  public Sedan(String model, String maker, int cc, boolean auto) {
    super(model, maker, cc);
    this.auto = auto;
  }
  
  // 상속 받은 메서드를 서브 클래스의 역할에 맞게끔 재정의하자! 오버라이딩
  public void run() {
    System.out.println("부웅~~ 부드럽게 달린다");
  }
}
