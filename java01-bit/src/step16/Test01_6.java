/* File 다루기 - File 클래스 사용법 VI
 * => 특정 확장자를 가진 파일만 출력하기
 */
package step16;

import java.io.File;

public class Test01_6 {

  public static void main(String[] args) throws Exception {
    File f = new File("../");
    
    displayDirectory(f, 0);
  }
  
  public static void displayDirectory(File dir, int level) throws Exception {
    File[] files = dir.listFiles();
    
    // 목록에서 특정 확장자를 가진 파일을 걸러내어 처리한다.
    // 그러나, 목록의 개수 만큼 반복문을 돌려야 한다.
    for (File file : files) {
      if (file.isFile() && file.getName().endsWith(".class")) {
        System.out.printf("%s\n", file.getPath());
      }
      
      if (file.isDirectory())
        displayDirectory(file, level + 1);
    }
  }

}









