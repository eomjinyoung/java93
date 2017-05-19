/* File I/O : 바이트 스트림 클래스 - ByteArrayOutputStream
 * => 바이트 배열 메모리를 출력하는 클래스이다.
 */
package step16;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class Test03_1 {

  public static void main(String[] args) throws Exception {
    //1) 바이트 배열에 데이터를 저장하기
    // 일반 방식:
    /*
    byte[] buf = new byte[3];
    buf[0] = 0x99;
    buf[1] = 0x44;
    buf[2] = 0x78;
    */
    
    // 스트리밍 API 이용:
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    // 이 출력 스트림 객체는 파일이 아니라 내부에서 따로 관리하는 
    // 바이트 배열 메모리로 출력한다.
    out.write(0x66778899);
    out.write(0x77665544);
    out.write(0x12345678);
    
    // 이 출력 스트림 객체가 관리하는 바이트 배열 얻기 
    byte[] buf = out.toByteArray();
    out.close();
    
    //2) 바이트 배열에서 데이터 읽기
    // 일반 방식:
    /*
    for (byte b : buf) {
      System.out.printf("%x ", b);
    }
    */
    
    // 스트리밍 API 이용:
    ByteArrayInputStream in = new ByteArrayInputStream(buf);
    
    int b = 0;
    while (true) {
      b = in.read();
      if (b == -1) // 바이트 배열의 끝에 도달 하면,
        break; // 반복을 종료한다.
      System.out.printf("%x ", b);
    }
    
    in.close();
  }

}









