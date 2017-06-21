package step27.ex4;

import java.sql.Date;

public class Tire {
  String maker;
  float inch;
  Date createdDate;
  
  public Tire() {}
  
  public Tire(String maker, int inch) {
    this.maker = maker;
    this.inch = inch;
  }
  
  @Override
  public String toString() {
    return "Tire [maker=" + maker + ", inch=" + inch + ", createdDate=" + createdDate + "]";
  }

  public Date getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
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
