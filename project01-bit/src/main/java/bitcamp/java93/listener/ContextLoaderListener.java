package bitcamp.java93.listener;

import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.reflections.Reflections;

import bitcamp.java93.annotation.Component;
import bitcamp.java93.util.DBConnectionPool;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    ServletContext sc = sce.getServletContext(); // 페이지 컨트롤러를 담을 보관소
    HashMap<String,Object> objMap = new HashMap<>(); // 객체를 담을 바구니
    
    // 웹 애플리케이션이 시작될 때 DAO를 생성하여 ServletContext 보관소에 저장한다.
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    try {
      DBConnectionPool conPool = new DBConnectionPool(
          jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      objMap.put("conPool", conPool);
      
      // @Component 애노테이션이 붙은 클래스를 찾아 
      // 객체를 생성하여 ServletContext 에 보관한다.
      
      // @Component가 붙은 클래스의 전체 이름(패키지명 + 클래스명)을 알아내야 한다.
      // => 개발자가 직접 /WEB-INF/classes 폴더를 뒤져서 @Component가 붙은 클래스를 찾는 대신,
      //    그것을 전문적으로 해주는 외부 라이브러리를 이용하자!
      // => "reflections" 라이브러리 추가하라!
      
      // 1) 클래스를 찾을 패키지를 지정한다.
      Reflections reflections = new Reflections("bitcamp.java93");
      
      // 2) @Component 애노테이션이 붙은 클래스 목록을 알아낸다.
      Set<Class<?>> components = 
          reflections.getTypesAnnotatedWith(Component.class);
      
      Component anno = null;
      for (Class<?> clazz : components) {
        System.out.println(clazz.getCanonicalName());
        anno = clazz.getAnnotation(Component.class); // 클래스에서 @Component 애노테이션을 추출
        Object obj = clazz.newInstance();
        if (anno.value().equals("")) {
          objMap.put(clazz.getCanonicalName(), obj);
        } else {
          objMap.put(anno.value(), obj);
        }
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
  }

}
