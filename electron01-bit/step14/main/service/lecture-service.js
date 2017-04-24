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
    this.lectureDao.selectOne(no, success, error)
  },//detail()

  insert(lecture, success, error) {
    this.lectureDao.insert(lecture, success, error)
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
