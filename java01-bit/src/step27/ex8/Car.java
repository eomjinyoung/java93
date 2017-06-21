/* @Autowired 사용: 필드 선언에 붙이기
 * => Spring IoC 컨테이너가 Car 객체를 만들 때,
 *    @Autowired가 붙은 필드에 
 *    의존 객체를 주입해야 한다는 것을 의미한다. 
 * => @Autowired를 필드 선언에 붙이면,
 *    셋터 메서드를 안 만들어도 된다.
 *    물론 만들어도 된다.
 */
package step27.ex8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
  String model;
  int cc;
  @Autowired Engine engine;
  
  @Override
  public String toString() {
    return "Car [model=" + model + ", cc=" + cc + ", engine=" + engine + "]";
  }

  public Car() {
    System.out.println("Car()");
    this.model = "기본자동차";
    this.cc = 900;
  }
  
  public Car(String model, int cc) {
    System.out.println("Car(String, int)");
    this.model = model;
    this.cc = cc;
  }
  
  public Car(String model, int cc, Engine engine) {
    System.out.println("Car(String, int, Engine)");
    this.model = model;
    this.cc = cc;
    this.engine = engine;
  }

  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    System.out.println("setModel()");
    this.model = model;
  }
  public int getCc() {
    return cc;
  }
  public void setCc(int cc) {
    System.out.println("setCc()");
    this.cc = cc;
  }
}
