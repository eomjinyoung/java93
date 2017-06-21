package step27.ex3;

public class Engine {
  int valve;
  int cylinder;
  
  public Engine() {}
  
  public Engine(int valve, int cylinder) {
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
    this.valve = valve;
  }
  public int getCylinder() {
    return cylinder;
  }
  public void setCylinder(int cylinder) {
    this.cylinder = cylinder;
  }
  
  
}
