package step28.ex6;

import java.util.List;
import java.util.Map;

public interface TeacherDao {
  // SQL 맵퍼 파일의 parameterType 속성과 같아야 한다.
  // parameterType="map" -----> Map<String,Object> valueMap
  List<Teacher> selectList(Map<String,Object> valueMap) throws Exception;
  Teacher selectOne(int no) throws Exception;
  int insert(Teacher teacher) throws Exception;
}
