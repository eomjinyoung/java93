/* 유틸리티 클래스 : java.util.Date 클래스 
 * => 1970년 1월 1일 0시 0분 0초부터 
 *    현재까지 경과된 시간을 밀리초(1/1000초)로 저장하는 객체  
 */
package step08;

public class Test05_1 {
  
  public static void main(String[] args) {
    // 현재 날짜 및 시간 알아내기
    java.util.Date today = new java.util.Date();
    System.out.println(today.toString());
    
    // println() 메서드의 아규먼트 값을 줄 때, 
    // 문자열을 주지 않고 그냥 원래의 인스턴스를 그대로 준다면,
    // println() 메서드 내부에서 자동으로 그 객체에 대해 toString() 호출한다.
    // 그리고 toString()의 리턴 값을 출력한다.
    // 결론! 그냥 인스턴스를 넘겨라. 
    // 괜히 수고롭게 toString() 호출해서 문자열을 뽑아 줄 필요가 없다.
    System.out.println(today);
    
  }

}







