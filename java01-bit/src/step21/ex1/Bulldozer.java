package step21.ex1;

public class Bulldozer {
  String model;
  String maker;
  int cc;
  int bucketHeight;
  
  public Bulldozer(String model, String maker, int cc) {
    this.model = model;
    this.maker = maker;
    this.cc = cc;
  }
  
  public void run() {
    System.out.println("빠르렁~~ 덜덜덜 간다.");
  }

  public void downBucket() {
    if (bucketHeight > -20) {
      bucketHeight--;
      System.out.println("버킷 내렸다!");
    } else {
      System.out.println("버킷을 더이상 내릴 수 없다.");
    }
  }
  
  public void upBucket() {
    if (bucketHeight < 40) {
      bucketHeight++;
      System.out.println("버킷 올렸다!");
    } else {
      System.out.println("버킷을 더이상 올릴 수 없다.");
    }
  }
}
