/* File 다루기 - File 클래스 사용법 VIII
 * => FileFilter를 익명클래스를 사용하여 구현하기
 */
package step16;

import java.io.File;
import java.io.FileFilter;

public class Test01_8 {

  public static void main(String[] args) throws Exception {
    File f = new File("../");
    
    displayDirectory(f, 0);
  }
  
  public static void displayDirectory(File dir, int level) throws Exception {
    // FileFilter를 익명 클래스로 만들 때 이점?
    // => 어차피 한 개의 객체만 필요하다. 
    //    쓸데없이 이너 클래스를 만들 필요가 없다.
    // => 그 코드 가까이에 있기 때문에 익명 클래스가 뭘 하는지 이해하기 쉽다.
    File[] files = dir.listFiles(new FileFilter() {
      public boolean accept(File file) {
        if (file.isDirectory() || (file.isFile() && file.getName().endsWith(".class"))) {
          return true;
        }
        return false;
      }
    });
    
    for (File file : files) {
      if (file.isDirectory()) {
        displayDirectory(file, level + 1);
      } else {
        System.out.printf("%s\n", file.getPath());
      }
      
    }
  }
  
}









