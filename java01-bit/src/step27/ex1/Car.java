package step27.ex1;

public class Car {
  String model;
  int cc;
  
  @Override
  public String toString() {
    return "Car [model=" + model + ", cc=" + cc + "]";
  }

  public Car() {
    this.model = "기본자동차";
    this.cc = 900;
  }
  
  public Car(String model, int cc) {
    this.model = model;
    this.cc = cc;
  }
  
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    this.model = model;
  }
  public int getCc() {
    return cc;
  }
  public void setCc(int cc) {
    this.cc = cc;
  }
}
