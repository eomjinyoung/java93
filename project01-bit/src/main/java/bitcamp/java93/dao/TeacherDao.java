package bitcamp.java93.dao;

import java.util.List;
import java.util.Map;

import bitcamp.java93.domain.Teacher;

public interface TeacherDao {
  List<Teacher> selectList(Map<String,Object> valueMap);
  Teacher selectOne(int no);
  Teacher selectOneByEmailPassword(Map<String,Object> valueMap);
  int countAll();
  int insert(Teacher teacher);
  int delete(int no);
  int update(Teacher teacher);
  void insertPhoto(Map<String,Object> valueMap);
  List<String> selectPhotoList(int teacherNo);
  void deletePhoto(int teacherNo);
}
