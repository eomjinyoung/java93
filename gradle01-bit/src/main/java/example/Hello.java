package example;

// 현재 이 자바 소스 파일은 UTF-8 로 인코딩 되어 있다.
// 영어인 경우 'ISO-8859-1' 이나 'UTF-8' 이나 동일하다.
// 그러나 한글인 경우 'ISO-8859-1'에는 정의되지 않았다.
public class Hello {
  public static void main(String[] args) {
    System.out.println("Hello");
    
    String level = "mgr";
    switch (level) {
    case "mgr": System.out.println("관리자입니다."); break;
    case "user": System.out.println("일반입니다."); break;
    default: System.out.println("없는 등급입니다.");
    }
  }
}