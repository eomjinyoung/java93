package bitcamp.java93.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import bitcamp.java93.control.LoginControl;
import bitcamp.java93.control.LogoutControl;
import bitcamp.java93.control.TeacherAddControl;
import bitcamp.java93.control.TeacherDeleteControl;
import bitcamp.java93.control.TeacherDetailControl;
import bitcamp.java93.control.TeacherListControl;
import bitcamp.java93.control.TeacherUpdateControl;
import bitcamp.java93.dao.MemberDao;
import bitcamp.java93.dao.TeacherDao;
import bitcamp.java93.dao.mysql.MemberDaoImpl;
import bitcamp.java93.dao.mysql.TeacherDaoImpl;
import bitcamp.java93.service.impl.TeacherServiceImpl;
import bitcamp.java93.util.DBConnectionPool;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    // 웹 애플리케이션이 시작될 때 DAO를 생성하여 ServletContext 보관소에 저장한다.
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    try {
      DBConnectionPool conPool = new DBConnectionPool(
          jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      MemberDao memberDao = new MemberDaoImpl(conPool);
      TeacherDao teacherDao = new TeacherDaoImpl(conPool);
      
      TeacherServiceImpl teacherService = new TeacherServiceImpl();
      teacherService.setMemberDao(memberDao);
      teacherService.setTeacherDao(teacherDao);
      
      TeacherListControl teacherListControl = new TeacherListControl();
      teacherListControl.setTeacherService(teacherService);
      
      TeacherDetailControl teacherDetailControl = new TeacherDetailControl();
      teacherDetailControl.setTeacherService(teacherService);
      
      TeacherAddControl teacherAddControl = new TeacherAddControl();
      teacherAddControl.setTeacherService(teacherService);
      
      TeacherUpdateControl teacherUpdateControl = new TeacherUpdateControl();
      teacherUpdateControl.setTeacherService(teacherService);
      
      TeacherDeleteControl teacherDeleteControl = new TeacherDeleteControl();
      teacherDeleteControl.setTeacherService(teacherService);
      
      LoginControl loginControl = new LoginControl();
      loginControl.setTeacherService(teacherService);
      
      LogoutControl logoutControl = new LogoutControl();
      
      ServletContext sc = sce.getServletContext();
      sc.setAttribute("/teacher/list", teacherListControl);
      sc.setAttribute("/teacher/detail", teacherDetailControl);
      sc.setAttribute("/teacher/add", teacherAddControl);
      sc.setAttribute("/teacher/update", teacherUpdateControl);
      sc.setAttribute("/teacher/delete", teacherDeleteControl);
      sc.setAttribute("/auth/login", loginControl);
      sc.setAttribute("/auth/logout", logoutControl);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
  }

}
