/* Class 도구 사용법: 인스턴스 생성하기*/
package step26;

import java.util.Date;

public class Test08 {

  public static void main(String[] args) throws Exception {
    Class<?> clazz = Class.forName("java.util.Date");
    Date obj = (Date)clazz.newInstance();
    System.out.println(obj);
  }
}






