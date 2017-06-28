package control;

import org.springframework.stereotype.Component;

@Component
public class MyDao {
  public void selectList() {System.out.println("      MyDao.selectList()");}
  public void selectOne() {System.out.println("      MyDao.selectOne()");}
  public void insert() {System.out.println("      MyDao.insert()");}
  public void update() {System.out.println("      MyDao.update()");}
  public void delete() {System.out.println("      MyDao.delete()");}
}
