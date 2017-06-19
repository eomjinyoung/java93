package bitcamp.java93.listener;

// static 멤버를 이 클래스에서 찾아라!
import static org.reflections.ReflectionUtils.getAllMethods;
import static org.reflections.ReflectionUtils.withModifier;
import static org.reflections.ReflectionUtils.withParametersCount;
import static org.reflections.ReflectionUtils.withPrefix;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.reflections.Reflections;

import bitcamp.java93.annotation.Component;
import bitcamp.java93.control.Controller;
import bitcamp.java93.util.DBConnectionPool;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
  HashMap<String,Object> objMap = new HashMap<>(); // 객체를 담을 바구니

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    ServletContext sc = sce.getServletContext(); // 페이지 컨트롤러를 담을 보관소
    
    // 웹 애플리케이션이 시작될 때 DAO를 생성하여 ServletContext 보관소에 저장한다.
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    try {
      DBConnectionPool conPool = new DBConnectionPool(
          jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      objMap.put("conPool", conPool);
      
      createObjects("bitcamp.java93"); // 객체 생성
      injectDependencies(); // 의존 객체 주입
      saveControllerIn(sc); // ServletContext 보관소에 페이지 컨트롤러를 보관한다.
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void createObjects(String packageName) throws Exception {
    // @Component 애노테이션이 붙은 클래스를 찾아 
    // 객체를 생성하여 ServletContext 에 보관한다.
    
    // @Component가 붙은 클래스의 전체 이름(패키지명 + 클래스명)을 알아내야 한다.
    // => 개발자가 직접 /WEB-INF/classes 폴더를 뒤져서 @Component가 붙은 클래스를 찾는 대신,
    //    그것을 전문적으로 해주는 외부 라이브러리를 이용하자!
    // => "reflections" 라이브러리 추가하라!
    
    // 1) 클래스를 찾을 패키지를 지정한다.
    Reflections reflections = new Reflections(packageName);
    
    // 2) @Component 애노테이션이 붙은 클래스 목록을 알아낸다.
    Set<Class<?>> components = 
        reflections.getTypesAnnotatedWith(Component.class);
    
    Component anno = null;
    for (Class<?> clazz : components) {
      anno = clazz.getAnnotation(Component.class); // 클래스에서 @Component 애노테이션을 추출
      Object obj = clazz.newInstance();
      if (anno.value().equals("")) {
        objMap.put(clazz.getCanonicalName(), obj);
      } else {
        objMap.put(anno.value(), obj);
      }
    }
  }
  
  @SuppressWarnings("unchecked")
  private void injectDependencies() throws Exception {
    Collection<Object> objList = objMap.values();
    for (Object obj : objList) {
      Set<Method> setters = getAllMethods(
          obj.getClass(), // 주어진 클래스로부터
          withModifier(Modifier.PUBLIC), // 접근 범위가 public ,
          withPrefix("set"), // 메서드의 이름이 set으로 시작, 
          withParametersCount(1)); // 파라미터 개수는 한 개인 메서드들을 찾는다.
      for (Method m : setters) {
        Class<?> paramType = m.getParameterTypes()[0];
        Object dependency = findDependency(paramType);
        if (dependency != null) {
          m.invoke(obj, dependency);
        }
      }
    }
  }
  
  private Object findDependency(Class<?> clazz) {
    Collection<Object> objList = objMap.values();
    for (Object obj : objList) {
      if (clazz.isInstance(obj)) {
        return obj;
      }
    }
    return null;
  }
  
  private void saveControllerIn(ServletContext sc) {
    Set<Entry<String,Object>> entrySet = objMap.entrySet();
    for (Entry<String,Object> entry : entrySet) {
      if (entry.getValue() instanceof Controller) {
        sc.setAttribute(entry.getKey(), entry.getValue());
      }
    }
  }
   
  @Override
  public void contextDestroyed(ServletContextEvent sce) {
  }

}
