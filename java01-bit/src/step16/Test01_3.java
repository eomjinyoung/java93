/* File 다루기 - File 클래스 사용법 III*/
package step16;

import java.io.File;

public class Test01_3 {

  public static void main(String[] args) throws Exception {
    File f = new File("../");
    
    // 지정된 폴더에 들어 있는 파일 및 하위 폴더의 이름 목록을 리턴한다.
    String[] files = f.list();
    
    for (String name : files) {
      System.out.println(name);
    }
  }

}









