/* File 다루기 - File 클래스 사용법 */
package step16;

import java.io.File;

public class Test01_1 {

  public static void main(String[] args) {
    // 이클립스에 자바 프로그램을 실행할 때 현재 위치는 프로젝트 폴더이다.
    
    File f = new File("../.."); 
    
    // getAbsolutePath()
    // => 최종 계산된 경로를 리턴하는 것이 아니라, 경로 그 값을 그대로 리턴한다.
    System.out.printf("getAbsolutePath() = %s\n", f.getAbsolutePath());

    // getCanonicalPath()
    // => .. 이나 . 명령을 처리하여 최종 경로를 리턴한다.
    // => 문제는 .. 을 잘못 사용하여 존재하지 않는 디렉토리 경로가 나왔을 때,
    //    예외를 던진다.
    // => 그래서 이 메서드를 호출할 때는 예외를 던졌을 때 받을 수 있도록 
    //    예외처리 문장을 작성해야 한다.
    //System.out.printf("getCanonicalPath() = %s\n", f.getCanonicalPath());
  }

}
