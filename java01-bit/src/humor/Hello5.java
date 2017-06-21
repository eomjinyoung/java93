package humor;

public class Hello5 {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("사용법: Hello5 메시지");
      return;
    }
    greeting(args[0]);
  }
  
  public static void greeting(String message) {
    System.out.println(message);
  }
}
