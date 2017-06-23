package step28.ex5;

import java.util.List;

public interface MemberDao {
  List<Member> selectList(int pageNo, int pageSize, String search, String value) throws Exception;
  List<Member> selectListByNames(int pageNo, int pageSize, String[] names) throws Exception;
  Member selectOne(int no) throws Exception;
  Member selectOneByEmailPassword(String email, String password) throws Exception;
  int insert(Member member) throws Exception;
  int delete(int no) throws Exception;
  int update(Member member) throws Exception;
}
