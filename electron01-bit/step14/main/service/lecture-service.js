"use strict"

module.exports = {
  setLectureDao(dao) {
    this.lectureDao = dao
  },

  list(pageNo, success, error) {
    var obj = this
    this.lectureDao.selectList(pageNo, function(lectures) {
      obj.lectureDao.countAll(function(result) {
        success(lectures, result[0].cnt)
      }, error)
    }, error)
  },//list()

  detail(no, success, error) {
    this.studentDao.selectOne(no, success, error)
  },//detail()

  insert(student, success, error) {
    var obj = this
    this.memberDao.insert(student, function(result) {
      student.no = result.insertId
      obj.studentDao.insert(student, success, error)
    }, error)
  },//insert()

  update(student, success, error) {
    var obj = this
    this.memberDao.update(student, function(result) {
      obj.studentDao.update(student, success, error)
    }, error)
  }, // update()

  delete(no, success, error) {
    var obj = this
    this.studentDao.delete(no, function(result) {
      obj.memberDao.delete(no, success, error)
    }, error)
  } // delete()
} // exports
