package step27.ex13;

import org.springframework.stereotype.Component;

@Component("seta")
public class SetaEngine extends Engine {
  boolean autoClean;

  @Override
  public String toString() {
    return "SetaEngine [autoClean=" + autoClean + ", valve=" + valve + ", cylinder=" + cylinder + "]";
  }

  public boolean isAutoClean() {
    return autoClean;
  }

  public void setAutoClean(boolean autoClean) {
    this.autoClean = autoClean;
  }
  
  
}
