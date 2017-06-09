/* 애노테이션 사용하기 : 속성 값 설정하기 
 */
package step25;

//@Annotation04 // 컴파일 오류! 필수 속성의 값은 반드시 입력해야 한다.
@Annotation04(v1 = "hello", v3 = 200) // v2와 v4는 선택 속성이기 때문에 생략 가능.
                                      // 생략하면 default 값이 사용된다.
public class Class02 {
}
