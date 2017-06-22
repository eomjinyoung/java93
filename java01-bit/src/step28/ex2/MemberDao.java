package step28.ex2;

import java.util.List;

public interface MemberDao {
  List<Member> selectList(int pageNo, int pageSize) throws Exception;
  List<Member> selectListByEmail(int pageNo, int pageSize, String email) throws Exception;
  List<Member> selectListByName(int pageNo, int pageSize, String name) throws Exception;
  List<Member> selectListByTel(int pageNo, int pageSize, String tel) throws Exception;
  Member selectOne(int no) throws Exception;
  Member selectOneByEmailPassword(String email, String password) throws Exception;
  int insert(Member member) throws Exception;
  int delete(int no) throws Exception;
  int update(Member member) throws Exception;
}
