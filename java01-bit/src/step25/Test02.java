/* 애노테이션 속성 값 추출하기 
 */
package step25;

public class Test02 {
  public static void main(String[] args) throws Exception {
    Class clazz = Class02.class;
    
    Annotation04 anno = (Annotation04)clazz.getAnnotation(Annotation04.class);

    // 애노케이션의 속성 값을 꺼낼 때는 메서드를 호출한다.
    System.out.printf("v1=%s\n", anno.v1());
    System.out.printf("v2=%s\n", anno.v2());
    System.out.printf("v3=%s\n", anno.v3());
    System.out.printf("v4=%s\n", anno.v4());
  }
}
