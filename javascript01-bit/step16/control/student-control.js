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

router.get('/list.json', (request, response) => {
  var pageNo = 1,
      pageSize = 3;
  if (request.query.pageNo) {
    pageNo = parseInt(request.query.pageNo)
  }
  if (request.query.pageSize) {
    pageSize = parseInt(request.query.pageSize)
  }
  studentService.list(pageNo, pageSize, function(results, totalCount) {
    response.json({'list': results, 'totalCount': totalCount})
  }, function(error) {
    response.status(200)
            .set('Content-Type', 'text/plain;charset=UTF-8')
            .end('error')
    console.log(error)
  })
})

router.get('/detail.json', function(request, response) {
  var no = parseInt(request.query.no)
  studentService.detail(no, function(result) {
    response.json(result)

  }, function(error) {
    response.status(200)
            .set('Content-Type', 'text/plain;charset=UTF-8')
            .end('error')
    console.log(error)
  })
})

router.post('/update.do', function(request, response) {
  studentService.update({
    no: request.body.no,
    working: (request.body.working == undefined ? 'N' : 'Y'),
    schoolName: request.body.schoolName,
    name: request.body.name,
    tel: request.body.tel,
    email: request.body.email,
    password: '1111'
  }, function(result) {
    response.json({'result': 'yes'})

  }, function(error) {
    response.status(200)
            .set('Content-Type', 'text/plain;charset=UTF-8')
            .end('error')
    console.log(error)
  })
})

router.get('/delete.do', function(request, response) {
  var no = parseInt(request.query.no)
  studentService.delete(no, function(result) {
    response.redirect('list.do')
  }, function(error) {
    response.render('error', {
      'message': '학생 데이터를 삭제하는 중 오류가 발생했습니다.'})
    console.log(error)
  })
})

router.get('/form.do', function(request, response) {
  response.render('student/view')
})

router.post('/add.json', function(request, response) {
  studentService.insert({
    working: request.body.working,
    schoolName: request.body.schoolName,
    name: request.body.name,
    tel: request.body.tel,
    email: request.body.email,
    password: '1111'
  }, function(result) {
    response.json({'result': 'yes'})

  }, function(error) {
    response.status(200)
            .set('Content-Type', 'text/plain;charset=UTF-8')
            .end('error')
    console.log(error)
  })
})





module.exports = router
