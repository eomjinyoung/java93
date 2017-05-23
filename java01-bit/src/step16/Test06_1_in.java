/* character stream 클래스: FileReader vs FileInputStream
 * => character stream 클래스   
 *    - 문자 단위로 데이터의 입출력을 다루는 클래스
 * => Reader(데이터를 읽는 스트림)
 *    1) Data Sink Stream
 *       FileReader
 *       CharArrayReader
 *       PipedReader
 *       StringReader
 *    2) Data Processing Stream
 *       BufferedReader
 *       LineNumberReader
 * => Writer(데이터를 쓰는 스트림)
 *    1) Data Sink Stream
 *       FileWriter
 *       CharArrayWriter
 *       PipedWriter
 *       StringWriter
 *    2) Data Processing Stream
 *       BufferedWriter
 *       PrintWriter
 */
package step16;

import java.io.FileInputStream;
import java.io.FileReader;

public class Test06_1_in {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("test06_1.txt");
    
    int b = 0;
    
    // 바이트(바이너리) 스트림 클래스는 바이트 단위로 그대로 데이터를 읽고 쓴다.
    while ((b = in.read()) != -1) {
      System.out.printf("%x,", b);
    }
    System.out.println();
    
    in.close();
    System.out.println("--------------------------------");
    
    FileReader in2 = new FileReader("test06_1.txt");
    
    // 캐릭터 스트림 클래스는 문자 단위로 데이터를 읽고 쓴다.
    // 1) 읽을 때
    //    => 문자의 인코딩 방식에 따라 1 ~ 4 바이트를 읽어서 
    //       자바에서 사용하는 2 byte 유니코드 값으로 바꿔 리턴한다.
    //    => 왜 바꾸는가? 자바 내부에서 문자를 다룰 때 유니코드 값을 사용하기 때문이다.
    // 2) 쓸 때
    //    => 문자의 인코딩 방식에 따라 2 byte 유니코드 값을 
    //       1 ~ 4 바이트 값으로 변환하여 출력한다.
    //       보통 OS의 기본 문자집합으로 변환하여 출력한다.
    //    => 왜 변환하는가? 
    //       문자 코드를 다룰 때 자바는 2바이트 유니코드를 사용하고,
    //       운영체제는 MS949(MS Windows)나 UTF-8(Unix)을 사용하기 때문이다.
    //       즉 JVM 환경과 OS 환경에서 문자코드를 다루는 방식이 다르기 때문이다.
    //       그래서 항시 변환이 필요하다.
    //
    while ((b = in2.read()) != -1) {
      System.out.printf("%x,", b);
    }
    System.out.println();
    
    in2.close();
  }

}









