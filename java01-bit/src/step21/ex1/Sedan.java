package step21.ex1;

public class Sedan {
  String model;
  String maker;
  int cc;
  boolean auto;
  Object storage;
  
  public Sedan(String model, String maker, int cc, boolean auto) {
    this.model = model;
    this.maker = maker;
    this.cc = cc;
    this.auto = auto;
  }
  
  public void run() {
    System.out.println("부웅~~ 부드럽게 달린다.");
  }
  
  public void load(Object obj) {
    this.storage = obj;
    System.out.printf("%s를 실었습니다.", obj);
  }
}
