package step27.ex9;

import org.springframework.stereotype.Component;

//@Component
public class Engine {
  int valve;
  int cylinder;
  
  public Engine() {
    System.out.println("Engine()");
  }
  
  public Engine(int valve, int cylinder) {
    System.out.println("Engine(int, int)");
    this.valve = valve;
    this.cylinder = cylinder;
  }
  
  @Override
  public String toString() {
    return "Engine [valve=" + valve + ", cylinder=" + cylinder + "]";
  }
  
  public int getValve() {
    return valve;
  }
  public void setValve(int valve) {
    System.out.println("setValve()");
    this.valve = valve;
  }
  public int getCylinder() {
    return cylinder;
  }
  public void setCylinder(int cylinder) {
    System.out.println("setCylinder()");
    this.cylinder = cylinder;
  }
  
  
}
