/* 애노테이션 사용하기 
 * => SOURCE, CLASS, RUNTIME 유지 범위 확인
 */
package step25;

@Annotation01
@Annotation02
@Annotation03
//@Annotation03 // 컴파일 오류! 같은 애노테이션을 중복해서 붙일 수 없다.
public class Class01 {
  // 애노테이션이 .class 파일에 유지되는지 확인하라!
  // => Class01.class 파일을 읽어 보면 된다.
}
