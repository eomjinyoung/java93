/* 애노테이션 배열 속성 값 추출하기 
 */
package step25;

public class Test03 {
  public static void main(String[] args) throws Exception {
    Class clazz = Class03.class;
    
    Annotation05 anno = (Annotation05)clazz.getAnnotation(Annotation05.class);

    // 애노케이션의 속성 값을 꺼낼 때는 메서드를 호출한다.
    System.out.printf("v1=%s\n", anno.v1()[1]);
    System.out.printf("v2=%s\n", anno.v2()[0]);
    System.out.printf("v3=%s\n", anno.v3()[0]);
    System.out.printf("v4=%s\n", anno.v4()[1]);
    System.out.printf("v5=%s\n", anno.v5()[0]);
    System.out.printf("v6=%s\n", anno.v6()[0]);
  }
}
