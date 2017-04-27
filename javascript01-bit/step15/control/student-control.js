// 학생 정보를 다루는 서비스를 정의한다.
const express = require('express')
const datasource = require('../util/datasource')
const studentDao = require('../dao/student-dao')
const memberDao = require('../dao/member-dao')
const studentService = require('../service/student-service')

const connection = datasource.getConnection()
studentDao.setConnection(connection)
memberDao.setConnection(connection)
studentService.setStudentDao(studentDao)
studentService.setMemberDao(memberDao)

const router = express.Router()

router.get('/list.do', (request, response) => {
  var pageNo = 1,
      pageSize = 3;
  if (request.query.pageNo) {
    pageNo = parseInt(request.query.pageNo)
  }
  if (request.query.pageSize) {
    pageSize = parseInt(request.query.pageSize)
  }
  studentService.list(pageNo, pageSize, function(results, totalCount) {
    var lastPageNo = parseInt(totalCount / pageSize) + (((totalCount % pageSize) > 0) ? 1 : 0)

    response.render('student/index', {
      'data': results,
      'pageNo': pageNo,
      'nextPageNo': pageNo + 1,
      'prevPageNo': pageNo - 1,
      'disabledPrevBtn': (pageNo == 1) ? 'disabled' : '',
      'disabledNextBtn': (pageNo == lastPageNo) ? 'disabled' : ''
    })
  }, function(error) {
    response.end('오류!')
    throw error
  })
})

router.get('/detail.do', function(request, response) {
  var no = parseInt(request.query.no)
  studentService.detail(no, function(result) {
    response.render('student/view', {
      'data': result,
      'checkedWorking': (result.work == 'Y' ? 'checked' : '')
    })
  }, function(error) {
    response.end('오류!')
    throw error
  })
})



module.exports = router
