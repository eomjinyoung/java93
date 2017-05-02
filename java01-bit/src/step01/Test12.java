/* 리터럴 - 이스케이프(escape) 문자 */
package step01;

public class Test12 {
  
  public static void main(String[] args) {
    // 큰 따옴표("")을 사용하여 문자열을 표현한다.
    // =>이클립스에서 실행하면 온전히 동작을 확인할 수 없다.
    // =>명령창에서 실행하라!
    System.out.println("ABC\b가각간"); // backspace (0x0008)
    System.out.println("ABC\t가각간"); // tab (0x0009)
    System.out.println("ABC\n가각간"); // line feed(new line; 0x000a). 줄 바꾸고 커서를 처음으로 보낸다.
    System.out.println("ABC\f가각간"); // form feed (0x000c). 현재 커서의 위치에서 줄을 바꾼다.
    System.out.println("-------------------");
    System.out.println("ABC\r가각간"); // carrage return (0x000d). 커서를 처음으로 보낸다.
    System.out.println("ABC\"가각간"); // double quote (0x0022)
    System.out.println("ABC'가각간"); // double quote 
    System.out.println("ABC\'가각간"); // single quote (0x0027) 큰 따옴표 안에서는 탈출할 필요가 없다. 
      // 그냥 작은 따옴표를 그대로 사용하면 된다. 
    //char c1 = '''; // 작은 따옴표 문자의 유니코드 값을 알고 싶을 때,
      // 작은 따옴표 안에서는 작은 따옴표를 그냥 적을 수 없다.
      // 이 경우 이스케이프 문자를 사용한다.
    char c2 = '\'';
    System.out.println(c2);
    System.out.println("ABC\\가각간"); // 역슬래시(0x005c)를 그냥 적으면, 다음에 이스케이프 문자가 와야 한다.
     // 역슬래시를 그냥 적고 싶다면, 이스케이프 문자로 적어라!
    
    // 특히 파일 경로에서 디렉토리 경로를 표현할 때 주의해야 한다.
    System.out.println("c:\\workspace\\java01\\src\\step01\\Test12.java");
  }
}

/*
 *이스케이프 문자
 * => 일반 문자가 아닌 특별한 명령어를 의미하는 문자.
 * => 문법
 *   \문자 
 *
 *줄바꿈 문자
 * => Windows: CRLF(0x0d0a, 2바이트로 표현)
 * => Unix/Linux: LF(0x0a, 1바이트로 표현)
 *   
 */





