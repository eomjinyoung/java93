package step28.ex6;

import java.util.List;
import java.util.Map;

public interface MemberDao {
  // Mybatis에서 DAO 구현체를 자동으로 만들게 하려면,
  // 메서드의 파라미터 타입이 SQL 맵퍼에 선언된 parameterType 속성의 값과 같아야 한다.
  List<Member> selectList(Map<String,Object> valueMap) throws Exception;
  List<Member> selectListByNames(Map<String,Object> valueMap) throws Exception;
  Member selectOne(int no) throws Exception;
  Member selectOneByEmailPassword(Map<String,Object> valueMap) throws Exception;
  int insert(Member member) throws Exception;
  int delete(int no) throws Exception;
  int update(Member member) throws Exception;
}
