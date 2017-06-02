import java.util.ArrayList;
import java.util.Scanner;

public class StudentSelector {

  public static void main(String[] args) throws Exception {
    Scanner keyScan = new Scanner(System.in);
    
    //String[] names = {"양승렬","박규호","권봉수","신용주","송수정","신선아","김정준","우인재"};
    //String[] names = {"김정준","권봉수","김승원","홍순민","고진서","김미연",
    //    "김대연","정성룡","김민섭","서흥원","김승민"};
    String[] names = {"권봉수","김승원","고진서","정성룡","서흥원","홍길동"};
        
    ArrayList<String> students = new ArrayList<>();
    for (String name : names) {
      students.add(name);
    }
    
    for (int i = 0; i < 6; i++) {
      keyScan.nextLine();
      int count = (int)(Math.random() * 1000);
      for (int x = 0; x < count; x++) { 
        if (x % 10 == 0) System.out.print("."); 
      }
      int no = (int)(Math.random() * students.size());
      System.out.println(students.remove(no));
      
    }

  }

}
