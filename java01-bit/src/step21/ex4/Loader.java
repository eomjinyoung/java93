package step21.ex4;

public abstract class Loader extends Car {
  Object storage;

  public Loader() {
    super();
  }

  public Loader(String model, String maker, int cc) {
    super(model, maker, cc);
  }

  // 서브 클래스에서도 그냥 사용할 수 있는 메서드라면,
  // 다음 메서드와 같이 수퍼 클래스에서 정의한다. 
  public void load(Object obj) {
    this.storage = obj;
    System.out.printf("%s를 실었습니다.\n", obj);
  }

}