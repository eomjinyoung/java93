package step27.ex4;

import java.beans.PropertyEditorSupport;

public class CustomEngineEditor extends PropertyEditorSupport {
  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    String[] values = text.split(",");
    Engine engine = new Engine(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
    this.setValue(engine);
  }
}
