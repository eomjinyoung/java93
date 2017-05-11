/* 프로그램 아규먼트
 * => 프로그램을 실행할 때 넘겨주는 값
 * => 예)
 *    > java -cp bin step08.Test01_1 aaa bbb ccc 111 222
 * => 위와 같이 클래스 이름 뒤에 값을 주게 되면
 *    공백을 기준으로 문자열 잘라서 배열에 담아
 *    main() 메서드의 파라미터 값으로 넘어온다.
 */
package step08;

public class Test01_1 {

  public static void main(String[] args) {
    // 프로그램 아규먼트가 없더라도 빈 배열의 주소가 넘어온다.
    // 즉 args가 null이 되지 않는다.
    System.out.println(args.length);
    for (String str : args) {
      System.out.println(str);
    }

  }

}
