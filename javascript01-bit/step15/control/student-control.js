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
  studentService.list(1, function(results, totalCount) {
    response.render('student/index', {data: results})
  }, function(error) {
    response.end('오류!')
    throw error
  })
})

module.exports = router
