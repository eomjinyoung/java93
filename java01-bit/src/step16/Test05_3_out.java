/* 데이터 프로세싱 스트림 클래스 - 직렬화와 transient 변경자
 * => 인스턴스의 변수 중에서 다른 인스턴스의 값을 바탕으로 
 *    계산을 수행해서 나오는 값을 저장하는 변수의 경우,
 *    굳이 저장할 필요가 없다.
 *    저장하는 것이 오히려 계산 오류를 만들 수 있다.
 *    예) Student의 sum, aver 변수
 *    
 * => 그래서 이런 인스턴스 변수의 경우 데이터로 내보낸는 직렬화 대상에서 제외시키는 것이 
 *    바람직하다.
 *    
 * => 직렬화 대상에서 제외시키기 위해 인스턴스 변수에 붙이는 옵션이 "transient"이다.
 *      
 */
package step16;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test05_3_out {
  
  public static void main(String[] args) throws Exception {
    // Student2 클래스는 모든 변수가 직렬화 대상이다.
    // => 즉 모든 변수의 값이 파일로 내보내진다.
    //Student2 s = new Student2("홍길동", 100, 90, 80, false);
    
    Student3 s = new Student3("홍길동", 100, 90, 80, false);
    
    FileOutputStream out0 = new FileOutputStream("temp/test05_3.data");
    ObjectOutputStream out = new ObjectOutputStream(out0);
    
    out.writeObject(s);
    
    out.close();
    out0.close();
  }

}









