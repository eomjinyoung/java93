package humor;

public class Hello7 {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("사용법: Hello5 메시지");
      return;
    }
    
    Greet2 obj = new Greet2();
    obj.setPre("-------------");
    obj.setPost("*****************");
    obj.print(args[0]);
  }
  
}
