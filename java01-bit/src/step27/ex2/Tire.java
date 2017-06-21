package step27.ex2;

public class Tire {
  String maker;
  float inch;
  
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
