/* 메서드 : 여러 개의 값을 리턴하고 싶을 때 II*/
package step05;

public class Test04 {

  //2) 다른 종류의 값이라면 Collection 이나 Map 객체에 담아서 그 주소를 리턴하라!
  public static java.util.ArrayList getStudent(int studentNo) {
    // 지정된 번호의 학생 정보를 찾았다고 가정하자!
    java.util.ArrayList arr = new java.util.ArrayList();
    arr.add("홍길동");
    arr.add(100);
    arr.add(90);
    arr.add(80);
    arr.add(100 + 90 + 80);
    arr.add((100 + 90 + 80) / 3f);
    return arr;
  }
  
  public static void main(String[] args) {
    java.util.ArrayList list = getStudent(100); 
    // getStudent()의 호출이 끝나더라도, 이 메서드에서 만든 객체는 "힙"에 계속 유지되기 때문에,
    // 그 객체의 주소만 알고 있으면 언제든지 그 객체를 찾아가 값을 꺼낼 수 있다.
    
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }
}








