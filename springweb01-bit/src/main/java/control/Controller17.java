/* Spring WebMVC: 같은 이름의 파라미터가 여러 개 넘어 올 때
 * => 배열 아규먼트로 받는다.  
 */
package control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/control/controller17/") 
public class Controller17 {
  
  @RequestMapping("ok1")
  @ResponseBody
  public String ok1(String[] name, int[] age) throws Exception {
    for (String n : name) {
      System.out.printf("name: %s\n", n);
    }
    
    for (int a : age) {
      System.out.printf("age: %d\n", a);
    }
    return "controller17_ok1";
  }

}









































