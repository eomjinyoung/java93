package bitcamp.java93.dao;

import java.util.List;

import bitcamp.java93.domain.Member;

public interface MemberDao {
  List<Member> selectList(int pageNo, int pageSize) throws Exception;
  Member selectOne(int no) throws Exception;
  Member selectOneByEmailPassword(String email, String password) throws Exception;
  int insert(Member member) throws Exception;
  int delete(int no) throws Exception;
  int update(Member member) throws Exception;
}
