package bitcamp.java93.service;

import java.util.List;

import bitcamp.java93.dao.MemberDao;
import bitcamp.java93.dao.TeacherDao;
import bitcamp.java93.domain.Teacher;

public class TeacherService {
  MemberDao memberDao;
  TeacherDao teacherDao;
  
  public void setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
  }
  public void setTeacherDao(TeacherDao teacherDao) {
    this.teacherDao = teacherDao;
  }
  
  public List<Teacher> list(int pageNo, int pageSize) throws Exception {
    return teacherDao.selectList(pageNo, pageSize);
  }
  
  public Teacher get(int no) throws Exception {
    Teacher teacher = teacherDao.selectOne(no);
    teacher.setPhotoList(teacherDao.selectPhotoList(no));
    return teacher;
  }
  
  public void add(Teacher teacher) throws Exception {
    memberDao.insert(teacher);
    teacherDao.insert(teacher);
    teacherDao.insertPhoto(teacher.getNo(), teacher.getPhotoList());
  }
  
  public void update(Teacher teacher) throws Exception {
    int count = memberDao.update(teacher);
    if (count < 1) {
      throw new Exception(teacher.getNo() + "번 강사를 찾을 수 없습니다.");
    }
    
    count = teacherDao.update(teacher);
    if (count < 1) {
      throw new Exception(teacher.getNo() + "번 강사를 찾을 수 없습니다.");
    }
    
    // 강사 사진 갱신
    teacherDao.deletePhoto(teacher.getNo()); // 강사의 모든 사진을 지운다.
    teacherDao.insertPhoto(teacher.getNo(), teacher.getPhotoList()); // 강사의 사진을 추가한다.
  }
  
  public void remove(int no) throws Exception {
    teacherDao.deletePhoto(no);
    int count = teacherDao.delete(no);
    if (count < 1) {
      throw new Exception(no + "번 강사를 찾을 수 없습니다.");
    }
    
    try {
      count = memberDao.delete(no);
    } catch (Exception e) {}
  }
}







