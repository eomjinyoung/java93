/* File 다루기 - File 클래스 사용법 II*/
package step16;

import java.io.File;

public class Test01_2 {

  public static void main(String[] args) throws Exception {
    // 파일 경로가 '/'로 시작하면 절대 경로를 의미하고,
    // '/'로 시작하지 않으면 상대 경로를 의미한다.
    // => 상대경로일 때 기준은? 이클립스에서 실행하면 프로젝트 폴더가 기준이 된다.
    File f = new File("hello.txt"); 
    
    //1) 파일을 생성하기
    //f.createNewFile();
    
    //2) 파일을 삭제하기
    f.delete();
  }

}









