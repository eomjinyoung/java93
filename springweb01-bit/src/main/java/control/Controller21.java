/* Spring WebMVC: 세션 다루기 II
 * => @SessionAttribute 애노테이션 사용하기
 */
package control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/control/controller21/") 
public class Controller21 {
  
  @RequestMapping("ok1")
  public String ok1(Model model) throws Exception {
    return "controller21_ok1";
  }
  
  @RequestMapping("ok2")
  public String ok2(String name, Model model) throws Exception {
    Member member2 = new Member();
    member2.setName(name);
    model.addAttribute("member2", member2);
    return "controller21_ok2";
  }  

  @RequestMapping("ok3")
  public String ok3(@ModelAttribute("member2") Member member2) throws Exception {
    return "controller21_ok3";
  }
  
  @RequestMapping("ok4")
  public String ok4(@ModelAttribute("member2") Member member2) throws Exception {
    return "controller21_ok4";
  }
  
}









































