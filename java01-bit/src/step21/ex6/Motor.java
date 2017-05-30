package step21.ex6;

public abstract class Motor {
  float ampere; // 암페어
  int rpm; // 분당 회전수
  float watt; // 와트
  
  public Motor() {}
  
  public Motor(float ampere, int rpm, float watt) {
    this.ampere = ampere;
    this.rpm = rpm;
    this.watt = watt;
  }
}
