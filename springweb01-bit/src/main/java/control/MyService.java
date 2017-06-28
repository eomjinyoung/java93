package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyService {
  @Autowired MyDao dao;
  
  public void list() {
    System.out.println("    MyService.list() ---->"); 
    dao.selectList();
    System.out.println("    <---- MyService.list()");
  }
  public void detail() {
    System.out.println("    MyService.detail() ---->"); 
    dao.selectOne();
    System.out.println("    <---- MyService.detail()");
  }
  public void insert() {
    System.out.println("    MyService.insert() ---->"); 
    dao.insert();
    System.out.println("    <---- MyService.insert()");
  }
  public void update() {
    System.out.println("    MyService.update() ---->"); 
    dao.update();
    System.out.println("    <---- MyService.update()");
  }
  public void delete() {
    System.out.println("    MyService.delete() ---->"); 
    dao.delete();
    System.out.println("    <---- MyService.delete()");
  }
}
