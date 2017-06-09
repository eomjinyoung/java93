/* 애노테이션 추출하기 
 * => RUNTIME 레벨의 애노테이션만 추출할 수 있다.
 */
package step25;

public class Test01 {
  public static void main(String[] args) throws Exception {
    // .class 파일에 들어있는 애노테이션을 추출하려면 
    // 1) 클래스 정보를 다루는 도구를 가져와야 한다.
    /* 방법1: 
    Class clazz = Class.forName("step25.Class01");
     */
    /* 방법2: */
    Class clazz = Class01.class;
    
    // 2) Class 객체를 통해 애노케이션을 추출한다.
    Annotation01 anno01 = (Annotation01)clazz.getAnnotation(Annotation01.class);
    if (anno01 == null) {
      System.out.println("Annotation01 애노테이션을 추출하지 못했다!");
      /* Annotation01은 CLASS 레벨이기 때문에
       * .class 파일에 존재하지만 JVM을 통해 꺼낼 수는 없다.
       */
    } else {
      System.out.println("Annotation01 애노테이션을 추출했다!");
    }
    
    Annotation03 anno03 = (Annotation03)clazz.getAnnotation(Annotation03.class);
    if (anno03 == null) {
      System.out.println("Annotation03 애노테이션을 추출하지 못했다!");
    } else {
      System.out.println("Annotation03 애노테이션을 추출했다!");
      /* Annotation03은 RUNTIME 레벨이기 때문에 
       * .class 파일에 존재한다.
       * 그리고 실행 중에 JVM을 통해 이렇게 꺼낼 수 있다.
       */
    }
    
  }
}
