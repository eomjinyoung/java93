package step27.ex3;

public class Tire {
  String maker;
  float inch;
  
  public Tire() {}
  
  public Tire(String maker, int inch) {
    this.maker = maker;
    this.inch = inch;
  }
  
  @Override
  public String toString() {
    return "Tire [maker=" + maker + ", inch=" + inch + "]";
  }
  public String getMaker() {
    return maker;
  }
  public void setMaker(String maker) {
    this.maker = maker;
  }
  public float getInch() {
    return inch;
  }
  public void setInch(float inch) {
    this.inch = inch;
  }
  
  
}
