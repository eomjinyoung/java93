package bitcamp.java93.control.json;

public class JsonResult {
  public static final String SUCCESS = "success";
  public static final String FAIL = "fail";
  public static final String ERROR = "error";
  
  String status;
  Object data;
  
  public JsonResult() {}
  
  public JsonResult(String status, Object data) {
    this.status = status;
    this.data = data;
  }
  
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  public Object getData() {
    return data;
  }
  public void setData(Object data) {
    this.data = data;
  }
  
  
}
