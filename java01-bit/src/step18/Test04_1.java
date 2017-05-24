/* 소켓 프로그래밍 : 파일 전송 서버 프로그램
 */
package step18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test04_1 {
  public static void main(String[] args) throws Exception {
    System.out.println("서버 실행 중...");
    
    ServerSocket serverSocket = new ServerSocket(8888);
   
    while (true) {
      try (
        Socket socket = serverSocket.accept();
        DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());) {
      
        // 클라이언트 보낸 데이터 읽기
        // 1) 파일명 읽기(2 byte를 읽어서 바이트 배열 수를 알아내고, 그 수 만큼 바이트배열을 읽는다.)
        String filename = in.readUTF(); 
        
        // 2) 파일 크기 읽기
        long length = in.readLong();
        
        // 3) 파일 읽기
        // => 파일 출력 스트림을 준비
        try (
          BufferedOutputStream fileOut = new BufferedOutputStream(
                                              new FileOutputStream("temp/" + filename));) {
          for (long i = 0; i < length; i++) {
            fileOut.write(in.read());
          }
          fileOut.flush(); // 버퍼에 남아있는 데이터를 마저 출력한다.
          
        } catch (Exception e) {
          System.out.println("파일 저장 중 오류 발생!");
        }
        
        // 4) 응답하기
        out.println("ok");
        
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}








