/* 스프링 사용법: Spring IoC 컨테이너 준비 II 
 * => 스프링 IoC 컨테이너를 사용하기 위한 라이브러리 준비
 *    1) mvnrepository.com에서 "spring-context" 검색
 *    2) build.gradle에 의존 라이브러리 정보 추가
 *    3) "gradle eclipse" 실행하여 이클립스 관련 설정 파일을 갱신
 *    4) 이클립스 프로젝트를 "refresh"
 */
package step27.ex1;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test02 {
  public static void main(String[] args) throws Exception {
    // 1) Spring 설정 파일 준비
    // => application-context-01.xml
    
    // 2) 설정 파일의 경로를 절대 경로로 지정할 때
    // => 절대 경로 앞에 "file:"을 반드시 붙여야 한다.
    File file = new File("src/step27/ex1/application-context-01.xml");
    System.out.println(file.getCanonicalPath());
    
    ApplicationContext ctx = 
        new FileSystemXmlApplicationContext("file:" + file.getCanonicalPath());
  }
}






