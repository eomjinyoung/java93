package step06;

/* Test02_3.java 에 있던 성적 처리 관련 클래스를 분리하였다.
 * 클래스 블록을 다음과 같이 별도 파일로 분리시킬 때는 
 * 클래스 선언 앞에 static을 빼야 한다.
 */
class Member {
  //init(), compute(), print() 메서드에서 사용할 변수 선언
  static String name;
  static int[] scores = new int[3];
  static int total;
  static float aver;
 
  // 변수의 값을 초기화시키는 기능을 수행하는 코드를 init() 블록 안에 묶어 두었다.
  public static void init(String n, int k, int e, int m) {
    name = n;
    scores[0] = k;
    scores[1] = e;
    scores[2] = m;
  }
  
  // 합계와 총점을 계산하는 기능의 코드를 compute() 블록 안에 묶어 두었다. 
  public static void compute() {
    total = scores[0] + scores[1] + scores[2];
    aver = total / 3f;
  }
  
  // 성적 정보를 출력하는 기능을 수행하는 코드를 print() 블록 안에 묶어 두었다.
  public static void print() {
    System.out.println("************************************");
    System.out.printf("%s, %d, %d, %d, %d, %f\n", 
        name, scores[0], scores[1], scores[2], total, aver);
    System.out.println("************************************");
  }
}
