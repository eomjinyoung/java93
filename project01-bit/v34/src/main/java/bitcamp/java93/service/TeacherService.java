package bitcamp.java93.service;

import java.util.List;

import bitcamp.java93.domain.Teacher;

public interface TeacherService {
  List<Teacher> list(int pageNo, int pageSize) throws Exception;
  Teacher get(int no) throws Exception;
  Teacher getByEmailPassword(String email, String password) throws Exception;
  int getSize() throws Exception;
  void add(Teacher teacher) throws Exception;
  void update(Teacher teacher) throws Exception;
  void remove(int no) throws Exception;
}







