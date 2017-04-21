"use strict"

function createStudentService(memberDao, studentDao) {
  return {
    /* list(pageNo, success, error) 스펙
    => pageNo: 가져올 페이지의 번호
    => success: 데이터 가져오는데 성공했을 때 호출될 함수
        success(학생데이터배열, 전체개수)
    => error: 데이터 가져오는데 실패했을 때 호출될 함수
        error(오류객체)
    */
    list(pageNo, success, error) {
      studentDao.selectList(pageNo, function(students) {
        studentDao.countAll(function(result) {
          success(students, result[0].cnt)
        }, error)
      }, error)
    },
    detail(no, success, error) {
      studentDao.selectOne(no, success, error)
    },
    insert(student, success, error) {
      memberDao.insert(student, function(result) {
        student.no = result.insertId
        studentDao.insert(student, success, error)
      }, error)
    },
    update(student, success, error) {
      memberDao.update(student, function(result) {
        studentDao.update(student, success, error)
      }, error)
    },
    delete(no, success, error) {
      studentDao.delete(no, function(result) {
        memberDao.delete(no, success, error)
      }, error)
    }
  }
}
