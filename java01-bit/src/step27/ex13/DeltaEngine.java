package step27.ex13;

import org.springframework.stereotype.Component;

@Component("delta")
public class DeltaEngine extends Engine {
  boolean hybrid;

  @Override
  public String toString() {
    return "DeltaEngine [hybrid=" + hybrid + ", valve=" + valve + ", cylinder=" + cylinder + "]";
  }

  public boolean isHybrid() {
    return hybrid;
  }

  public void setHybrid(boolean hybrid) {
    this.hybrid = hybrid;
  }
}
