/* 변수 선언: 변수의 범위 II */
package step02;

public class Test19 {
  public static void main(String[] args) {
    int a = 10;
    {
      //int a = 20; // 블록 바깥 쪽에 존재하는 변수를 중복해서 선언할 수 없다. 컴파일 오류!
      int b = 20;
      System.out.println(b);
      System.out.println(a); // 블록 안쪽에서는 바깥 쪽 변수를 사용할 수 있다.
    }
    
    //System.out.println(b); // 블록을 벗어나면 블록 안에 선언했던 모든 변수가 제거된다. 컴파일 오류!
    
  }
}
