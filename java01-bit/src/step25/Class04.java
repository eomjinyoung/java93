/* 애노테이션 사용하기 : value라는 이름의 속성 값 설정하기 
 */
package step25;

public class Class04 {
  @Annotation06()  // value나 value2 모두 default가 설정되었기 때문에 값을 지정하지 않아도 된다.
  class Test01 {}
  
  @Annotation06 // 속성의 값을 지정하지 않으면 괄호()를 생략할 수 있다.
  class Test02 {}
  
  @Annotation06(value="값값값") 
  class Test03 {}
  
  @Annotation06(value2="값값값")
  class Test04 {}
  
  //속성 이름을 생략하면 value를 의미한다. value 속성의 이름은 생략할 수 있다.
  @Annotation06("값값값") 
  class Test05 {}
  
  //두 개 이상의 속성 값을 설정할 때는 value 이름을 생략할 수 없다.
  //@Annotation06("값값값", value2="값값값") // 컴파일 오류! 
  @Annotation06(value="값값값", value2="값값값")
  class Test06 {}
  
  
}





