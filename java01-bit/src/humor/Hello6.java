package humor;

public class Hello6 {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("사용법: Hello5 메시지");
      return;
    }
    
    Greet obj = new Greet();
    obj.print(args[0]);
  }
  
}
